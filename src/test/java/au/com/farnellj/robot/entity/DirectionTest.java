package au.com.farnellj.robot.entity;

import au.com.farnellj.robot.exception.InstructionException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {

    @Test
    public void shouldTurnLeftSuccessfullyFromEveryDirection() {
        //Check left turn
        Direction target = Direction.NORTH;
        target = target.turnLeft();
        assertEquals(target, Direction.WEST);
        target = target.turnLeft();
        assertEquals(target, Direction.SOUTH);
        target = target.turnLeft();
        assertEquals(target, Direction.EAST);
        target = target.turnLeft();
        assertEquals(target, Direction.NORTH);

        //Check right turn
        target = Direction.NORTH;
        target = target.turnRight();
        assertEquals(target, Direction.EAST);
        target = target.turnRight();
        assertEquals(target, Direction.SOUTH);
        target = target.turnRight();
        assertEquals(target, Direction.WEST);
        target = target.turnRight();
        assertEquals(target, Direction.NORTH);
    }

    @Test
    public void shouldConvertStringToDirection() {
        /*
        Check that the 4 characters are correctly assigned to a Direction class
         */
        Direction target = Direction.fromString("N");
        assertEquals(Direction.NORTH, target);
        target = Direction.fromString("n");
        assertEquals(Direction.NORTH, target);
        target = Direction.fromString("north");
        assertEquals(Direction.NORTH, target);
        target = Direction.fromString("NORTH");
        assertEquals(Direction.NORTH, target);

        target = Direction.fromString("S");
        assertEquals(Direction.SOUTH, target);
        target = Direction.fromString("s");
        assertEquals(Direction.SOUTH, target);
        target = Direction.fromString("south");
        assertEquals(Direction.SOUTH, target);
        target = Direction.fromString("SOUTH");
        assertEquals(Direction.SOUTH, target);


        target = Direction.fromString("E");
        assertEquals(Direction.EAST, target);
        target = Direction.fromString("e");
        assertEquals(Direction.EAST, target);
        target = Direction.fromString("east");
        assertEquals(Direction.EAST, target);
        target = Direction.fromString("EAST");
        assertEquals(Direction.EAST, target);

        target = Direction.fromString("W");
        assertEquals(Direction.WEST, target);
        target = Direction.fromString("w");
        assertEquals(Direction.WEST, target);
        target = Direction.fromString("west");
        assertEquals(Direction.WEST, target);
        target = Direction.fromString("WEST");
        assertEquals(Direction.WEST, target);
    }

    @Test(expected = InstructionException.class)
    public void shouldThrowExceptionWhenInvalidCharactersAreSupplied() {
        /*
        Check that a dodgy character throws an exception
         */
        Direction.fromString("Z");
    }

}
