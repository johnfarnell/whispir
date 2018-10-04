package au.com.farnellj.robot.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrientationTest {
    private Orientation target;

    @Before
    public void setUp() {
        Coordinate coordinate = new Coordinate(4, 8);
        Direction direction = Direction.WEST;
        target = new Orientation(coordinate, direction);
    }

    @Test
    public void shouldCorrectlyAssignCoordinateAndDirection() {
        assertEquals(4, target.getCoordinate().getX());
        assertEquals(8, target.getCoordinate().getY());
        assertEquals(Direction.WEST, target.getDirection());
    }
}
