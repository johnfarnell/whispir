package au.com.farnellj.robot.instruction;

import au.com.farnellj.robot.entity.*;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 */
public class TurnLeftTest {

    @Test
    public void shouldNowFaceWestWhenTurningLeftFromNorth() {
        TurnLeft target = new TurnLeft();

        Table table = mock(Table.class);
        Robot robot = mock(Robot.class);
        Coordinate coordinate = mock(Coordinate.class);
        Orientation orientation = mock(Orientation.class);
        //Mock robot behaviour
        when(robot.getOrientation()).thenReturn(orientation);
        when(robot.getDirection()).thenReturn(Direction.NORTH);
        when(coordinate.getX()).thenReturn(4);
        when(coordinate.getY()).thenReturn(5);
        when(robot.getCoordinate()).thenReturn(coordinate);

        target.execute(table, robot);

        ArgumentCaptor<Orientation> orientationCapture = ArgumentCaptor.forClass(Orientation.class);
        verify(robot).setOrientation(orientationCapture.capture());
        assertEquals(4, orientationCapture.getValue().getCoordinate().getX());
        assertEquals(5, orientationCapture.getValue().getCoordinate().getY());
        //gone from NORTH to WEST when turning left
        assertEquals(Direction.WEST, orientationCapture.getValue().getDirection());
    }

    @Test
    public void shouldNowFaceSouthWhenTurningLeftFromWest() {
        TurnLeft target = new TurnLeft();

        Table table = mock(Table.class);
        Robot robot = mock(Robot.class);
        Coordinate coordinate = mock(Coordinate.class);
        Orientation orientation = mock(Orientation.class);
        //Mock robot behaviour
        when(robot.getOrientation()).thenReturn(orientation);
        when(robot.getDirection()).thenReturn(Direction.WEST);
        when(coordinate.getX()).thenReturn(4);
        when(coordinate.getY()).thenReturn(5);
        when(robot.getCoordinate()).thenReturn(coordinate);

        target.execute(table, robot);

        ArgumentCaptor<Orientation> orientationCapture = ArgumentCaptor.forClass(Orientation.class);
        verify(robot).setOrientation(orientationCapture.capture());
        assertEquals(4, orientationCapture.getValue().getCoordinate().getX());
        assertEquals(5, orientationCapture.getValue().getCoordinate().getY());
        //gone from WEST to SOUTH when turning left
        assertEquals(Direction.SOUTH, orientationCapture.getValue().getDirection());
    }

    @Test
    public void shouldNowFaceEastWhenTurningLeftFromSouth() {
        TurnLeft target = new TurnLeft();

        Table table = mock(Table.class);
        Robot robot = mock(Robot.class);
        Coordinate coordinate = mock(Coordinate.class);
        Orientation orientation = mock(Orientation.class);
        //Mock robot behaviour
        when(robot.getOrientation()).thenReturn(orientation);
        when(robot.getDirection()).thenReturn(Direction.SOUTH);
        when(coordinate.getX()).thenReturn(4);
        when(coordinate.getY()).thenReturn(5);
        when(robot.getCoordinate()).thenReturn(coordinate);

        target.execute(table, robot);

        ArgumentCaptor<Orientation> orientationCapture = ArgumentCaptor.forClass(Orientation.class);
        verify(robot).setOrientation(orientationCapture.capture());
        assertEquals(4, orientationCapture.getValue().getCoordinate().getX());
        assertEquals(5, orientationCapture.getValue().getCoordinate().getY());
        //gone from SOUTH to EAST when turning left
        assertEquals(Direction.EAST, orientationCapture.getValue().getDirection());
    }

    @Test
    public void shouldNowFaceNorthWhenTurningLeftFromEast() {
        TurnLeft target = new TurnLeft();

        Table table = mock(Table.class);
        Robot robot = mock(Robot.class);
        Coordinate coordinate = mock(Coordinate.class);
        Orientation orientation = mock(Orientation.class);
        //Mock robot behaviour
        when(robot.getOrientation()).thenReturn(orientation);
        when(robot.getDirection()).thenReturn(Direction.EAST);
        when(coordinate.getX()).thenReturn(4);
        when(coordinate.getY()).thenReturn(5);
        when(robot.getCoordinate()).thenReturn(coordinate);

        target.execute(table, robot);

        ArgumentCaptor<Orientation> orientationCapture = ArgumentCaptor.forClass(Orientation.class);
        verify(robot).setOrientation(orientationCapture.capture());
        assertEquals(4, orientationCapture.getValue().getCoordinate().getX());
        assertEquals(5, orientationCapture.getValue().getCoordinate().getY());
        //gone from EAST to NORTH when turning left
        assertEquals(Direction.NORTH, orientationCapture.getValue().getDirection());
    }
}
