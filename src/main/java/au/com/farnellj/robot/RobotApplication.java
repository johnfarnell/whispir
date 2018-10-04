package au.com.farnellj.robot;

import au.com.farnellj.robot.controller.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class in the application, standard Spring Boot {@link CommandLineRunner} which delegates the processing to
 * the injected {@link Controller}
 */
@SpringBootApplication
public class RobotApplication implements CommandLineRunner {

    @Autowired
    private Controller controller;

    public static void main(String[] args) {
        SpringApplication.run(RobotApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        controller.execute();
    }
}
