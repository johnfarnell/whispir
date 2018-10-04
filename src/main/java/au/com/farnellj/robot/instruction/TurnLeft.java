package au.com.farnellj.robot.instruction;

import au.com.farnellj.robot.entity.Direction;
import au.com.farnellj.robot.entity.Orientation;
import au.com.farnellj.robot.entity.Robot;
import au.com.farnellj.robot.entity.Table;
import au.com.farnellj.robot.exception.InstructionException;

/**
 * Turns the {@link Robot} to the left thus changing its {@link Direction}.
 */
public class TurnLeft extends Instruction {

    public Orientation executeInternal(Table table, Robot robot) throws InstructionException {
        if (robot.getOrientation() == null) {
            throw new InstructionException("The Robot must be on the table before it can be TURNED");
        }
        Direction newDirection = robot.getDirection().turnLeft();

        return new Orientation(robot.getCoordinate(), newDirection);
    }
}