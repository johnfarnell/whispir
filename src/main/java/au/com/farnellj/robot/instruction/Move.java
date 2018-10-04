package au.com.farnellj.robot.instruction;

import au.com.farnellj.robot.entity.Coordinate;
import au.com.farnellj.robot.entity.Orientation;
import au.com.farnellj.robot.entity.Robot;
import au.com.farnellj.robot.entity.Table;
import au.com.farnellj.robot.exception.InstructionException;

/**
 * Moves the {@link Robot} 1 position in the {@link au.com.farnellj.robot.entity.Direction} it is facing.
 */
public class Move extends Instruction {

    public Orientation executeInternal(Table table, Robot robot) {

        if (robot.getOrientation() == null) {
            throw new InstructionException("The Robot must be on the table before it can be MOVED");
        }
        int xPos = robot.getPositionX();
        int yPos = robot.getPositionY();
        Coordinate newPos = null;
        //Create a new position by moving 1 spot, depending on heading
        switch (robot.getDirection()) {
            case NORTH:
                newPos = new Coordinate(xPos, ++yPos);
                break;
            case SOUTH:
                newPos = new Coordinate(xPos, --yPos);
                yPos--;
                break;
            case EAST:
                newPos = new Coordinate(++xPos, yPos);
                xPos++;
                break;
            case WEST:
                newPos = new Coordinate(--xPos, yPos);
                xPos--;
                break;
        }

        //now check the position is still on the table

        if (table.isValidPosition(newPos)) {
            return new Orientation(newPos, robot.getDirection());
        } else {
            throw new InstructionException(newPos + " is not a valid position on the table " + table);
        }


    }

}
