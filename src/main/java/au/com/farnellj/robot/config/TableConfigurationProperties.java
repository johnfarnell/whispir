package au.com.farnellj.robot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Holds the bottom left anf top right coordinates of the {@link au.com.farnellj.robot.entity.Table},
 * the {@link au.com.farnellj.robot.entity.Robot} is constrained in this area. All subclasses of
 *
 * @link au.com.farnellj.robot.instruction.Instruction} need to ensure this constraint is met
 */
@ConfigurationProperties("table")
public class TableConfigurationProperties {
    private int bottomLeftX;
    private int bottomLeftY;
    private int topRightX;
    private int topRightY;

    public int getBottomLeftX() {
        return bottomLeftX;
    }

    public void setBottomLeftX(int bottomLeftX) {
        this.bottomLeftX = bottomLeftX;
    }

    public int getBottomLeftY() {
        return bottomLeftY;
    }

    public void setBottomLeftY(int bottomLeftY) {
        this.bottomLeftY = bottomLeftY;
    }

    public int getTopRightX() {
        return topRightX;
    }

    public void setTopRightX(int topRightX) {
        this.topRightX = topRightX;
    }

    public int getTopRightY() {
        return topRightY;
    }

    public void setTopRightY(int topRightY) {
        this.topRightY = topRightY;
    }


}
