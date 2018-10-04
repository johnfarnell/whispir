package au.com.farnellj.robot.dao;

import au.com.farnellj.robot.exception.InstructionException;
import au.com.farnellj.robot.factory.InstructionFactory;
import au.com.farnellj.robot.instruction.Instruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * File based implementation which retrieves instructions from a file name on the root of the classpath
 */
public class FileCommandDao implements CommandDao {

    private static Logger logger = LoggerFactory.getLogger(FileCommandDao.class);
    private final List<String> instructions;
    @Autowired
    private InstructionFactory instructionFactory;
    private int index = 0;

    public FileCommandDao(String inputFile) {
        instructions = new ArrayList<>();

        /*
        Read in the instruction lines one by one from the file
         */
        try (InputStream stream = this.getClass().getResourceAsStream("/" + inputFile);
             InputStreamReader isr = new InputStreamReader(stream);
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                instructions.add(line);
            }
        } catch (IOException e) {
            throw new InstructionException("Input file cannot be read", e);
        }
    }

    @Override
    public Instruction getNextInstruction() {
        /*
        Return the next line in the list and create an (@link Instruction) from it
         */
        if (index < instructions.size()) {
            logger.info("instruction " + instructions.get(index));
            return instructionFactory.createInstructions(instructions.get(index++));
        } else {
            logger.info("No more instructions");
            return null;
        }
    }
}
