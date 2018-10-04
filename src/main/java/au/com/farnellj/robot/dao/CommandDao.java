package au.com.farnellj.robot.dao;

import au.com.farnellj.robot.instruction.Instruction;

/**
 * An interface which provides the next instruction
 */
public interface CommandDao {

    /**
     * @return the next {@link Instruction}
     */
    Instruction getNextInstruction();
}
