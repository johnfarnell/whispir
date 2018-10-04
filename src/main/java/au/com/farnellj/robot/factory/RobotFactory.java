package au.com.farnellj.robot.factory;

import au.com.farnellj.robot.entity.Robot;
import org.springframework.stereotype.Component;

/**
 * Generatea robot instances
 */
@Component
public class RobotFactory {
    public Robot createRobot(String id) {
        return new Robot(id);
    }
}
