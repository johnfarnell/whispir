package au.com.farnellj.robot.entity;

import au.com.farnellj.robot.config.TableConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A class which holds the TABLE details
 */
@Component
public class Table {
    private final Coordinate bottomLeftCoordinate;
    private final Coordinate topRightCoordinate;

    public Table(@Autowired TableConfigurationProperties tableConfigurationProperties) {
        bottomLeftCoordinate = new Coordinate(tableConfigurationProperties.getBottomLeftX()
                , tableConfigurationProperties.getBottomLeftY());
        topRightCoordinate = new Coordinate(tableConfigurationProperties.getTopRightX()
                , tableConfigurationProperties.getTopRightY());
    }

    /**
     * @param coordinate the {@link Coordinate} to validate
     * @return true if the supplied position is in a valid {@link Coordinate} on the Table
     */
    public boolean isValidPosition(Coordinate coordinate) {
        /*
        The supplied coordinate is valid, if it lies within the x,y coordinates
         of the bottomLeftCoordinate and  topRightCoordinate
         */

        return ((coordinate.getX() <= topRightCoordinate.getX())
                && (coordinate.getX() >= bottomLeftCoordinate.getX())
                && (coordinate.getY() <= topRightCoordinate.getY())
                && (coordinate.getY() >= bottomLeftCoordinate.getY()));
    }

    public Coordinate getBottomLeftCoordinate() {
        return bottomLeftCoordinate;
    }

    public Coordinate getTopRightCoordinate() {
        return topRightCoordinate;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Table : ");
        sb.append("(" + getBottomLeftCoordinate().getX() + "," + getBottomLeftCoordinate().getY() + ")");
        sb.append(" : ");
        sb.append("(" + getTopRightCoordinate().getX() + "," + getTopRightCoordinate().getY() + ")");

        return sb.toString();

    }
}
