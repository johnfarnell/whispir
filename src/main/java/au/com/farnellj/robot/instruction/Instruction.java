package au.com.farnellj.robot.instruction;

import au.com.farnellj.robot.entity.Orientation;
import au.com.farnellj.robot.entity.Robot;
import au.com.farnellj.robot.entity.Table;

/**
 * Parent class of all instructions
 */
public abstract class Instruction {

    public void execute(Table table, Robot robot) {
        Orientation orientation = executeInternal(table, robot);
        /**
         * if a {@link Orientation} is returned then assign assign it to the {@link Robot}
         */
        if (orientation != null) {
            robot.setOrientation(orientation);
        }
    }

    /**
     * Subclasses override this method to implement the specific behaviour of the instruction
     *
     * @param table
     * @param robot
     * @return
     */
    protected abstract Orientation executeInternal(Table table, Robot robot);
}
