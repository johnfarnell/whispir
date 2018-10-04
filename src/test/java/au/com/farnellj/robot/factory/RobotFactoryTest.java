package au.com.farnellj.robot.factory;

import au.com.farnellj.robot.entity.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RobotFactoryTest {
    private RobotFactory target;

    @Before
    public void setUp() {
        target = new RobotFactory();
    }

    @Test
    public void shouldCreateRobotWithCorrectId() {
        Robot robot = target.createRobot("abc");
        assertNotNull(robot);
        assertEquals("abc", robot.getId());
    }
}
