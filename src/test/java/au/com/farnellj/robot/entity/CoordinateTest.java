package au.com.farnellj.robot.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinateTest {
    private Coordinate target;

    @Before
    public void setUp() {
        target = new Coordinate(4, 8);
    }

    @Test
    public void shouldCorrectlyAssignXAndYValueToCoordinate() {
        assertEquals(4, target.getX());
        assertEquals(8, target.getY());
        assertEquals("(4,8)", target.toString());
    }

}
