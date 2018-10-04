package au.com.farnellj.robot.service;

import au.com.farnellj.robot.dao.CommandDao;
import au.com.farnellj.robot.instruction.Instruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Wraps an implementation of a {@link CommandDao} which returns the next {@link Instruction}
 */
@Component
public class CommandService {
    @Autowired
    private CommandDao commandDao;

    /**
     * It is expected that if the particular {@link CommandDao} wishes to provide functionality to terminate the
     * process, that it throw a {@link RuntimeException} - see
     * {@link au.com.farnellj.robot.util.ScannerTerminatingException} in
     * {@link au.com.farnellj.robot.dao.ScannerCommandDao}
     *
     * @return the next {@link Instruction} if available, otherwise NULL
     * @link au.com.farnellj.robot.dao.ScannerCommandDao}
     */
    public Instruction getNextInstruction() {
        return commandDao.getNextInstruction();
    }
}
