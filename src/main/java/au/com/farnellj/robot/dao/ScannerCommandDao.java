package au.com.farnellj.robot.dao;

import au.com.farnellj.robot.factory.InstructionFactory;
import au.com.farnellj.robot.instruction.Instruction;
import au.com.farnellj.robot.util.ScannerTerminatingException;
import au.com.farnellj.robot.util.ScannerUtility;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

/**
 * Reads the instructions from details read in from the command line
 */
public class ScannerCommandDao implements CommandDao {
    @Autowired
    private ScannerUtility scannerUtility;
    @Autowired
    private InstructionFactory instructionFactory;

    public static void main(String[] args) {
        ScannerCommandDao dao = new ScannerCommandDao();
        dao.scannerUtility = new ScannerUtility();
//        Place place = dao.getNextInstruction();
//        System.out.println(place.getCoordinate().getX());
//        System.out.println(place.getCoordinate().getY());
//        System.out.println(place.getDirection());
    }

    @Override
    public Instruction getNextInstruction() {

//        scannerUtility.showMessages(
//                "",
//                "",
//                "Enter an instruction",
//                "e.g. \"PLACE 0,0,NORTH\" ",
//                "or \"LEFT\"",
//                "or \"RIGHT\"",
//                "or \"MOVE\"",
//                "or \"REPORT\"");
        Scanner in = new Scanner(System.in);
        try {
            String instruction = scannerUtility.getString(in, "",
                    "",
                    "Enter an instruction",
                    "e.g. \"PLACE 0,0,NORTH\" ",
                    "or \"LEFT\"",
                    "or \"RIGHT\"",
                    "or \"MOVE\"",
                    "or \"REPORT\"");
            return instructionFactory.createInstructions(instruction);
        } catch (ScannerTerminatingException e) {
            //If there are any ScannerTerminatingException then we are exiting
            return null;
        }
    }
}
