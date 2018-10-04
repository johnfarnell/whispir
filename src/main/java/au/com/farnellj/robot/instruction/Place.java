package au.com.farnellj.robot.instruction;

import au.com.farnellj.robot.entity.*;
import au.com.farnellj.robot.exception.InstructionException;

/**
 * Allows the {@link Robot} to be placed on the {@link Table}. This is the first {@link Instruction} that
 * is successfully action, i.e. any other {@link Instruction} (e.g. {@link Move}) will be ignored if there has
 * not been a {@link Place}
 */
public class Place extends Instruction {
    private final Orientation orientation;

    public Place(Coordinate coordinate, Direction direction) {
        this.orientation = new Orientation(coordinate, direction);
    }

    public Coordinate getCoordinate() {
        return orientation.getCoordinate();
    }

    public Direction getDirection() {
        return orientation.getDirection();
    }

    @Override
    public Orientation executeInternal(Table table, Robot robot) {
        /*
        If the robot is being placed on the table, return the orientaion
         */
        if (table.isValidPosition(getCoordinate())) {
            return orientation;
        } else {
            throw new InstructionException(getCoordinate() + " is not a valid position on the table " + table);
        }
    }
}
