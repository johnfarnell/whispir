package au.com.farnellj.robot.factory;

import au.com.farnellj.robot.entity.Coordinate;
import au.com.farnellj.robot.entity.Direction;
import au.com.farnellj.robot.exception.InstructionException;
import au.com.farnellj.robot.instruction.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * This class is supplied a string and attempts to generate a @{@link Instruction}
 */
@Component
public class InstructionFactory {
    public static final String PLACE = "PLACE";
    public static final String MOVE = "MOVE";
    public static final String REPORT = "REPORT";
    public static final String LEFT = "LEFT";
    public static final String RIGHT = "RIGHT";
    @Autowired
    private Listener listener;

    public Instruction createInstructions(String instructionLine) {
        if ((instructionLine == null) || StringUtils.trimWhitespace(instructionLine).length() == 0) {
            throw new InstructionException("Input Robot line can not be an empty string or NULL");
        }

        Instruction result = null;
        String[] instructionLineSplit = instructionLine.split(" ");
        String verb = instructionLineSplit[0];

        switch (verb.toUpperCase()) {
            case MOVE:
                result = new Move();
                break;
            case (LEFT):
                result = new TurnLeft();
                break;
            case RIGHT:
                result = new TurnRight();
                break;
            case REPORT:
                result = new Report(listener);
                break;
            case PLACE:
                if (instructionLineSplit.length == 2) {
                    String[] orientationAsStr = instructionLineSplit[1].split(",");
                    if (orientationAsStr.length == 3) {
                        int x = Integer.valueOf(orientationAsStr[0]);
                        int y = Integer.valueOf(orientationAsStr[1]);
                        Coordinate coordinate = new Coordinate(x, y);
                        Direction direction = Direction.fromString(orientationAsStr[2]);
                        result = new Place(coordinate, direction);
                    }
                }
                if (result == null) {
                    throw new InstructionException(
                            String.format("PLACE instruction not in the correct format",
                                    instructionLine));
                }
                break;
            default:
                throw new InstructionException(
                        String.format("Input Robot line %s does not contain a recognised verb",
                                instructionLine));

        }
        return result;


    }
}
