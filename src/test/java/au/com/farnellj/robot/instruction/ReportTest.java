package au.com.farnellj.robot.instruction;


import au.com.farnellj.robot.entity.Orientation;
import au.com.farnellj.robot.entity.Robot;
import au.com.farnellj.robot.entity.Table;
import au.com.farnellj.robot.exception.InstructionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReportTest {
    @InjectMocks
    private Report target;

    @Mock
    private Listener listener;

    @Test
    public void shouldReturnNullAndCallListenerWhenRobotIsOnTable() {
        //Set up mock input arguments
        Table table = mock(Table.class);
        Robot robot = mock(Robot.class);

        //Mock that robot is on the table, i.e. Orientation is NOT Null.
        when(robot.getOrientation()).thenReturn(mock(Orientation.class));

        assertNull(target.executeInternal(table, robot));
        verify(listener, times(1)).execute(table, robot);
    }

    @Test(expected = InstructionException.class)
    public void shouldThrowExceptionAndNotCallListenerWhenRobotIsNotOnTable() {
        //Set up mock input arguments
        Table table = mock(Table.class);
        Robot robot = mock(Robot.class);

        //Mock that robot is on the table, i.e. Orientation is Null.
        when(robot.getOrientation()).thenReturn(null);

        assertNull(target.executeInternal(table, robot));
        verify(listener, never()).execute(isA(Table.class), isA(Robot.class));
    }


}
