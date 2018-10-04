package au.com.farnellj.robot.dao;

import au.com.farnellj.robot.factory.InstructionFactory;
import au.com.farnellj.robot.instruction.Instruction;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileCommandDaoTest {
    @Test
    public void shouldReturnAnInstructionPerLineInTheFile() {

        FileCommandDao target = new FileCommandDao("FileCommandDaoTest.txt");
        InstructionFactory instructionFactory = mock(InstructionFactory.class);
        ReflectionTestUtils.setField(target, "instructionFactory", instructionFactory);

        Instruction instruction1 = mock(Instruction.class);
        Instruction instruction2 = mock(Instruction.class);
        Instruction instruction3 = mock(Instruction.class);
        when(instructionFactory.createInstructions("PLACE 0,0,EAST")).thenReturn(instruction1);
        when(instructionFactory.createInstructions("MOVE")).thenReturn(instruction2);
        when(instructionFactory.createInstructions("LEFT")).thenReturn(instruction3);

        Instruction actual1 = target.getNextInstruction();
        Instruction actual2 = target.getNextInstruction();
        Instruction actual3 = target.getNextInstruction();
        assertEquals(instruction1, actual1);
        assertEquals(instruction2, actual2);
        assertEquals(instruction3, actual3);

        assertNull(target.getNextInstruction());
    }
}
