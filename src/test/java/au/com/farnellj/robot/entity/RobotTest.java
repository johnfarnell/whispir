package au.com.farnellj.robot.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotTest {
    private Robot target;
    private Orientation orientation;

    @Before
    public void setUp() {
        target = new Robot("id");
        Coordinate coordinate = new Coordinate(4, 8);
        Direction direction = Direction.WEST;
        orientation = new Orientation(coordinate, direction);
        target.setOrientation(orientation);
    }

    @Test
    public void shouldCorrectlyAssignOrientationAndId() {
        assertEquals(4, target.getCoordinate().getX());
        assertEquals(8, target.getCoordinate().getY());
        assertEquals(Direction.WEST, target.getDirection());
        assertEquals("id", target.getId());
        assertEquals(orientation, target.getOrientation());
    }
}
