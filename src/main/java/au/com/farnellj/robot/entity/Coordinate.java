package au.com.farnellj.robot.entity;

/**
 * x,y coordinate
 */
public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("(" + x + "," + y + ")");

        return sb.toString();

    }
}
