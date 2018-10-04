package au.com.farnellj.robot.entity;

import au.com.farnellj.robot.exception.InstructionException;

/**
 * This enum holds the 4 possible directions that a {@link Robot} could have
 */
public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    /**
     * @param directionAsStr the character to be matched to a {@link Direction}
     * @return the {@link Direction} that matches the supplied character
     */
    public static Direction fromString(String directionAsStr) {
        Direction result = null;
        switch (directionAsStr.toUpperCase()) {
            case "N":
            case "NORTH":
                result = NORTH;
                break;
            case "E":
            case "EAST":
                result = EAST;
                break;
            case "S":
            case "SOUTH":
                result = SOUTH;
                break;
            case "W":
            case "WEST":
                result = WEST;
                break;
            default:
                throw new InstructionException("Invalid character " + directionAsStr + " supplied as a direction");
        }

        return result;

    }

    /**
     * Turn right from current direction
     *
     * @return the Direction after the turn has been made
     */
    public Direction turnRight() {
        /*         Find the next ordinal  - use modulo (%) to return to keep within the range of directions
         */
        int newIndex = (ordinal() + 1) % values().length;
        return values()[newIndex];
    }

    /**
     * Turn left from current direction
     *
     * @return the Direction after the turn has been made
     */
    public Direction turnLeft() {
        /*
        Adding a value of 1 less than the number of directions, is the same
        as subtracting 1 (left turn) without the complication of arriving at -1
         */
        int numberOfAvailabledirectionsMinus1 = values().length - 1;
        /*
         Find the next ordinal  - use modulo (%) to return to keep within the range of directions
          */
        int newIndex = (ordinal() + numberOfAvailabledirectionsMinus1) % values().length;
        return values()[newIndex];
    }

    @Override
    public String toString() {
        return name().toUpperCase();
    }
}
