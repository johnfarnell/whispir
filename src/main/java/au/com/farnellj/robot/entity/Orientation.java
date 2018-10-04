package au.com.farnellj.robot.entity;

/**
 * Holds the combination of coordinate and direction that defines where the robot is and which direction it is facing
 */
public class Orientation {
    private final Direction direction;

    private final Coordinate coordinate;

    public Orientation(Coordinate coordinate, Direction direction) {
        this.direction = direction;
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Direction getDirection() {
        return direction;
    }


}
