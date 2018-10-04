package au.com.farnellj.robot.entity;

/**
 * The robot, it has an id and {@link Orientation}
 */
public class Robot {

    private String id;
    private Orientation orientation;

    public Robot(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int getPositionX() {
        return orientation.getCoordinate().getX();
    }

    public int getPositionY() {
        return orientation.getCoordinate().getY();
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Direction getDirection() {
        return orientation.getDirection();
    }

    public Coordinate getCoordinate() {
        return orientation.getCoordinate();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Robot " + this.id + System.getProperty("line.separator"));
        if (orientation != null) {
            sb.append(orientation.getCoordinate() + " " + orientation.getDirection());
        }

        return sb.toString();

    }
}
