package au.com.farnellj.robot.instruction;

import au.com.farnellj.robot.entity.Orientation;
import au.com.farnellj.robot.entity.Robot;
import au.com.farnellj.robot.entity.Table;
import au.com.farnellj.robot.exception.InstructionException;

/**
 * Delegates to a supplied {@link Listener} (e.g {@link StandardListener}) to output the {@link Robot}
 * {@link Orientation} to a particular source (e.g. console)
 */
public class Report extends Instruction {
    private final Listener listener;

    public Report(Listener listener) {
        this.listener = listener;
    }

    @Override
    public Orientation executeInternal(Table table, Robot robot) {
        if (robot.getOrientation() == null) {
            throw new InstructionException("The Robot must be on the table before it can be REPORTED");
        }
        listener.execute(table, robot);
        //Always return NULL to reflect there has been no change
        return null;
    }
}
