package au.com.farnellj.robot.integration;

import au.com.farnellj.robot.RobotApplication;
import org.junit.Test;

public class RobotApplicationTest {
    @Test
    public void testCompleteRunMockWrite() throws Exception {

        //Do the complete run, but switch off the write out put and use the test DAO just so we can see the results easil
        RobotApplication.main(new String[]{"--commandDao=file"});
    }
}
