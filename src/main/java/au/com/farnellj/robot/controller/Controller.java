package au.com.farnellj.robot.controller;

import au.com.farnellj.robot.entity.Robot;
import au.com.farnellj.robot.entity.Table;
import au.com.farnellj.robot.exception.InstructionException;
import au.com.farnellj.robot.factory.RobotFactory;
import au.com.farnellj.robot.instruction.Instruction;
import au.com.farnellj.robot.service.CommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Uses the injected {@link CommandService} to receive a number of @{@link Instruction} which it then applies
 * to the {@link Robot}
 */
@Component
public class Controller {
    private static Logger logger = LoggerFactory.getLogger(Controller.class);
    @Autowired
    private RobotFactory robotFactory;
    @Autowired
    private Table table;
    @Autowired
    private CommandService commandService;


    /**
     * This scope of this method provides the complete set of {@link Instruction} which are applied to the {@link Robot}
     * This method will terminate when there are no {@link Instruction} returned by the {@link CommandService}
     * Any {@link Instruction} that is deemed invalid (e.g. takes the {@link Robot} of the {@link Table}) will result in
     * a {@link InstructionException} being thrown. Such an {@link Instruction} will be ignored and the next
     * {@link Instruction} will be requested.
     */
    public void execute() {

        logger.info(table.toString());
        Robot robot = robotFactory.createRobot("Robot 1");
        boolean keepRunning = true;
        //After that the following instructions can be anything
        do {
            /**
             * While there is an {@link Instruction} to process, this loop will continue
             */
            try {
                Instruction instruction = commandService.getNextInstruction();
                if (instruction != null) {
                    instruction.execute(table, robot);
                } else {
                    //If there is no Instruction returned and there is no InstructionException then we're finished
                    keepRunning = false;
                }
            } catch (InstructionException e) {
                //The requirement is to ignore instructions that cannot be performed, but do NOT end the loop
                logger.error("Instruction ignored " + e.getMessage());
            }
        } while (keepRunning);

    }
}
