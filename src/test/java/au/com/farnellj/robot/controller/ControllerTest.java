package au.com.farnellj.robot.controller;

import au.com.farnellj.robot.entity.Robot;
import au.com.farnellj.robot.entity.Table;
import au.com.farnellj.robot.factory.RobotFactory;
import au.com.farnellj.robot.instruction.Instruction;
import au.com.farnellj.robot.service.CommandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    @InjectMocks
    private Controller target;
    @Mock
    private RobotFactory robotFactory;
    @Mock
    private Table table;
    @Mock
    private CommandService commandService;

    @Test
    public void shouldExecuteEachInstructionReturnedByCommandService() {
        Robot robot = mock(Robot.class);
        when(robotFactory.createRobot(any())).thenReturn(robot);
        Instruction instruction1 = mock(Instruction.class);
        Instruction instruction2 = mock(Instruction.class);
        when(commandService.getNextInstruction())
                .thenReturn(instruction1)
                .thenReturn(instruction2)
                .thenReturn(null);

        target.execute();

        verify(instruction1, times(1)).execute(table, robot);
        verify(instruction2, times(1)).execute(table, robot);
        verify(commandService, times(3)).getNextInstruction();
    }
}
