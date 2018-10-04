package au.com.farnellj.robot.instruction;

import au.com.farnellj.robot.entity.Robot;
import au.com.farnellj.robot.entity.Table;

/**
 * Instances of this interface are supplied to the {@link Report} class to provide an output
 */
public interface Listener {
    void execute(Table table, Robot robot);
}
