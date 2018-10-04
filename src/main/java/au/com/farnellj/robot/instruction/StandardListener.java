package au.com.farnellj.robot.instruction;

import au.com.farnellj.robot.entity.Robot;
import au.com.farnellj.robot.entity.Table;
import org.springframework.stereotype.Component;

/**
 * Used by {@link Report}, outputs the {@link Robot} {@link au.com.farnellj.robot.entity.Orientation} to the console
 */
@Component
public class StandardListener implements Listener {
    @Override
    public void execute(Table table, Robot robot) {
        System.out.println(robot);
    }
}
