package au.com.farnellj.robot.instruction;

import au.com.farnellj.robot.entity.*;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 */
public class TurnRightTest {

    @Test
    public void shouldNowFaceEastWhenTurningRightFromNorth() {
        TurnRight target = new TurnRight();

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
        //gone from NORTH to EAST when turning right
        assertEquals(Direction.EAST, orientationCapture.getValue().getDirection());
    }

    @Test
    public void shouldNowFaceNorthWhenTurningRightFromWest() {
        TurnRight target = new TurnRight();

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
        //gone from WEST to NORTH when turning right
        assertEquals(Direction.NORTH, orientationCapture.getValue().getDirection());
    }

    @Test
    public void shouldNowFaceWestWhenTurningRightFromSouth() {
        TurnRight target = new TurnRight();

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
        //gone from SOUTH to WEST when turning right
        assertEquals(Direction.WEST, orientationCapture.getValue().getDirection());
    }

    @Test
    public void shouldNowFaceSouthWhenTurningRightFromEast() {
        TurnRight target = new TurnRight();

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
        //gone from EAST to SOUTH when turning right
        assertEquals(Direction.SOUTH, orientationCapture.getValue().getDirection());
    }
}
