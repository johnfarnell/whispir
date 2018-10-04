package au.com.farnellj.robot.config;

import au.com.farnellj.robot.dao.CommandDao;
import au.com.farnellj.robot.dao.FileCommandDao;
import au.com.farnellj.robot.dao.ScannerCommandDao;
import au.com.farnellj.robot.factory.InstructionFactory;
import au.com.farnellj.robot.instruction.Instruction;
import au.com.farnellj.robot.instruction.Listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableConfigurationProperties(TableConfigurationProperties.class)
public class ApplicationConfiguration {
    @Autowired
    private Listener listener;
    @Autowired
    private InstructionFactory instructionFactory;
    @Value("${command.file}")
    private String fileName;

    @Bean
    @ConditionalOnProperty(name = "commandDao", havingValue = "internal", matchIfMissing = true)
    CommandDao commandDaoInternal() {
        return new CommandDao() {
            List<String> instructions = Arrays.asList(
                    "PLACE 1,2,EAST",
                    "REPORT",
                    "MOVE",
                    "REPORT",
                    "LEFT",
                    "REPORT",
                    "MOVE",
                    "REPORT",
                    "LEFT",
                    "REPORT",
                    "RIGHT",
                    "REPORT");
            int indexInstruction = 1;

            @Override
            public synchronized Instruction getNextInstruction() {
                return indexInstruction < instructions.size() ?
                        instructionFactory.createInstructions(instructions.get(indexInstruction++)) : null;
            }
        };
    }

    @Bean
    @ConditionalOnProperty(name = "commandDao", havingValue = "scanner")
    CommandDao commandDaoScanner() {
        return new ScannerCommandDao();
    }

    @Bean
    @ConditionalOnProperty(name = "commandDao", havingValue = "file")
    CommandDao commandDaoFile(@Value("${command.file}") String fileName1) {
        return new FileCommandDao(fileName1);
    }
}
