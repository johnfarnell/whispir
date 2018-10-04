package au.com.farnellj.robot.util;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Scanner;

@Component
public class ScannerUtility {

    private static String LINE_SEPARATOR = System.getProperty("line.separator");

    private void showMessagesAndAllowExit(String... messages) {
        for (int i = 0; i < messages.length; i++) {
            System.out.print(messages[i] + LINE_SEPARATOR);
        }
        System.out.print("or just press ENTER to exit" + LINE_SEPARATOR);
    }

    public String getString(Scanner in, String... messages) throws ScannerTerminatingException {
        return getInput(in, messages);

    }

    private String getInput(Scanner in, String[] messages) throws ScannerTerminatingException {
        showMessagesAndAllowExit(messages);
        showMessages("");
        System.out.print("---> ");
        String line = in.nextLine();
        while (StringUtils.isEmpty(line)) {
            System.out.print("Do you wish to exit : Y/N" + LINE_SEPARATOR);
            String exit = in.nextLine();
            if (StringUtils.isEmpty(exit)) {
                continue;
            }
            if (exit.equalsIgnoreCase("Y")) {
                throw new ScannerTerminatingException();
            }
            showMessagesAndAllowExit(messages);
            showMessages("");
            System.out.print("---> ");
            line = in.nextLine();
        }
        showMessages("");
        return line;
    }

    public void showMessages(String... messages) {
        for (int i = 0; i < messages.length; i++) {
            System.out.print(messages[i] + LINE_SEPARATOR);
        }
    }
}
