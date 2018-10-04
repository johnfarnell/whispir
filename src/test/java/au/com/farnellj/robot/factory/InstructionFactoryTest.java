package au.com.farnellj.robot.factory;

import au.com.farnellj.robot.entity.Direction;
import au.com.farnellj.robot.exception.InstructionException;
import au.com.farnellj.robot.instruction.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class InstructionFactoryTest {
    @InjectMocks
    private InstructionFactory target;
    @Mock
    private Listener listener;

    @Test(expected = InstructionException.class)
    public void shouldThrowExceptionWhenLineIsNull() {
        target.createInstructions(null);
    }

    @Test(expected = InstructionException.class)
    public void shouldThrowExceptionWhenLineIsEmptyString() {
        target.createInstructions(" ");
    }

    @Test(expected = InstructionException.class)
    public void shouldThrowExceptionWhenLineIsUnrecognised() {
        target.createInstructions(" What is this ");
    }

    @Test(expected = InstructionException.class)
    public void shouldThrowAnExceptionWhenPlaceDoesNotHave3Arguments() {
        target.createInstructions("PLACE blah");
    }

    @Test
    public void shouldCreateAPlaceInstructionFromAValidPlaceLine() {
        Instruction instruction = target.createInstructions("PLACE 0,1,EAST");
        assertNotNull(instruction);
        assertEquals(instruction.getClass(), Place.class);

        assertEquals(0, ((Place) instruction).getCoordinate().getX());
        assertEquals(1, ((Place) instruction).getCoordinate().getY());
        assertEquals(Direction.EAST, ((Place) instruction).getDirection());
    }

    @Test
    public void shouldCreateLeftInstructionFromAValidLeftLine() {
        Instruction instruction = target.createInstructions("LEFT");
        assertNotNull(instruction);
        assertEquals(instruction.getClass(), TurnLeft.class);
    }

    @Test
    public void shouldCreateRightInstructionFromAValideRightLine() {
        Instruction instruction = target.createInstructions("RIGHT");
        assertNotNull(instruction);
        assertEquals(instruction.getClass(), TurnRight.class);
    }

    @Test
    public void shouldCreateAMoveInstructionFromAValidMoveLine() {
        Instruction instruction = target.createInstructions("MOVE");
        assertNotNull(instruction);
        assertEquals(instruction.getClass(), Move.class);
    }

    @Test
    public void shouldCreateAReportInstructionFromAValidReportLine() {
        Instruction instruction = target.createInstructions("REPORT");
        assertNotNull(instruction);
        assertEquals(instruction.getClass(), Report.class);
        //Additional check, ensure the listener has been passed to the Report
        assertEquals(listener, ReflectionTestUtils.getField(target, "listener"));
    }
}
