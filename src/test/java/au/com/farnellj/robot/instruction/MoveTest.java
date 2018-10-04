package au.com.farnellj.robot.instruction;

import au.com.farnellj.robot.entity.*;
import au.com.farnellj.robot.exception.InstructionException;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 */
public class MoveTest {

    @Test
    public void shouldIncrementYWhenMovingNorth() {
        Move target = new Move();

        Table table = mock(Table.class);
        Robot robot = mock(Robot.class);
        //Mock robot behaviour
        Orientation orientation = mock(Orientation.class);
        when(robot.getOrientation()).thenReturn(orientation);
        when(robot.getPositionX()).thenReturn(4);
        when(robot.getPositionY()).thenReturn(5);
        when(robot.getDirection()).thenReturn(Direction.NORTH);
        when(table.isValidPosition(any())).thenReturn(Boolean.TRUE);

        target.execute(table, robot);

        ArgumentCaptor<Coordinate> coordinateCapture = ArgumentCaptor.forClass(Coordinate.class);
        verify(table).isValidPosition(coordinateCapture.capture());
        assertEquals(4, coordinateCapture.getValue().getX());
        assertEquals(6, coordinateCapture.getValue().getY());

        ArgumentCaptor<Orientation> orientationCapture = ArgumentCaptor.forClass(Orientation.class);
        verify(robot).setOrientation(orientationCapture.capture());

        assertEquals(4, orientationCapture.getValue().getCoordinate().getX());
        //gone from 5 to 6 when moving NORTH
        assertEquals(6, orientationCapture.getValue().getCoordinate().getY());
        assertEquals(Direction.NORTH, orientationCapture.getValue().getDirection());
    }

    @Test
    public void shouldDecrementYWhenMovingSouth() {
        Move target = new Move();

        Table table = mock(Table.class);
        Robot robot = mock(Robot.class);
        //Mock robot behaviour
        Orientation orientation = mock(Orientation.class);
        when(robot.getOrientation()).thenReturn(orientation);
        when(robot.getPositionX()).thenReturn(4);
        when(robot.getPositionY()).thenReturn(5);
        when(robot.getDirection()).thenReturn(Direction.SOUTH);
        when(table.isValidPosition(any())).thenReturn(Boolean.TRUE);

        target.execute(table, robot);

        ArgumentCaptor<Coordinate> coordinateCapture = ArgumentCaptor.forClass(Coordinate.class);
        verify(table).isValidPosition(coordinateCapture.capture());
        assertEquals(4, coordinateCapture.getValue().getX());
        assertEquals(4, coordinateCapture.getValue().getY());

        ArgumentCaptor<Orientation> orientationCapture = ArgumentCaptor.forClass(Orientation.class);
        verify(robot).setOrientation(orientationCapture.capture());
        assertEquals(4, orientationCapture.getValue().getCoordinate().getX());
        //gone from 5 to 4 when moving SOUTH
        assertEquals(4, orientationCapture.getValue().getCoordinate().getY());
        assertEquals(Direction.SOUTH, orientationCapture.getValue().getDirection());
    }

    @Test
    public void shouldIncrementXWhenMovingEast() {
        Move target = new Move();

        Table table = mock(Table.class);
        Robot robot = mock(Robot.class);
        //Mock robot behaviour
        Orientation orientation = mock(Orientation.class);
        when(robot.getOrientation()).thenReturn(orientation);
        when(robot.getPositionX()).thenReturn(4);
        when(robot.getPositionY()).thenReturn(5);
        when(robot.getDirection()).thenReturn(Direction.EAST);
        when(table.isValidPosition(any())).thenReturn(Boolean.TRUE);

        target.execute(table, robot);

        ArgumentCaptor<Coordinate> coordinateCapture = ArgumentCaptor.forClass(Coordinate.class);
        verify(table).isValidPosition(coordinateCapture.capture());
        assertEquals(5, coordinateCapture.getValue().getX());
        assertEquals(5, coordinateCapture.getValue().getY());

        ArgumentCaptor<Orientation> orientationCapture = ArgumentCaptor.forClass(Orientation.class);
        verify(robot).setOrientation(orientationCapture.capture());
        //gone from 4 to 5 when moving EAST
        assertEquals(5, orientationCapture.getValue().getCoordinate().getX());
        assertEquals(5, orientationCapture.getValue().getCoordinate().getY());
        assertEquals(Direction.EAST, orientationCapture.getValue().getDirection());
    }

    @Test
    public void shouldDecrementXWhenMovingWest() {
        Move target = new Move();

        Table table = mock(Table.class);
        Robot robot = mock(Robot.class);
        //Mock robot behaviour
        Orientation orientation = mock(Orientation.class);
        when(robot.getOrientation()).thenReturn(orientation);
        when(robot.getPositionX()).thenReturn(4);
        when(robot.getPositionY()).thenReturn(5);
        when(robot.getDirection()).thenReturn(Direction.WEST);
        when(table.isValidPosition(any())).thenReturn(Boolean.TRUE);

        target.execute(table, robot);

        ArgumentCaptor<Coordinate> coordinateCapture = ArgumentCaptor.forClass(Coordinate.class);
        verify(table).isValidPosition(coordinateCapture.capture());
        assertEquals(3, coordinateCapture.getValue().getX());
        assertEquals(5, coordinateCapture.getValue().getY());

        ArgumentCaptor<Orientation> orientationCapture = ArgumentCaptor.forClass(Orientation.class);
        verify(robot).setOrientation(orientationCapture.capture());
        //gone from 4 to 3 when moving WEST
        assertEquals(3, orientationCapture.getValue().getCoordinate().getX());
        assertEquals(5, orientationCapture.getValue().getCoordinate().getY());
        assertEquals(Direction.WEST, orientationCapture.getValue().getDirection());
    }

    @Test(expected = InstructionException.class)
    public void shouldThrowExceptionWhenRobotNotOnTable() {
        Move target = new Move();

        Table table = mock(Table.class);
        Robot robot = mock(Robot.class);
        //Mock robot behaviour
        when(robot.getOrientation()).thenReturn(null);

        target.execute(table, robot);

    }

    @Test(expected = InstructionException.class)
    public void shouldThrowExceptionWhenMovingToAPositionNotOnTable() {
        Move target = new Move();

        Table table = mock(Table.class);
        Robot robot = mock(Robot.class);
        //Mock robot behaviour
        Orientation orientation = mock(Orientation.class);
        when(robot.getOrientation()).thenReturn(orientation);
        when(robot.getPositionX()).thenReturn(4);
        when(robot.getPositionY()).thenReturn(5);
        when(robot.getDirection()).thenReturn(Direction.WEST);
        when(table.isValidPosition(any())).thenReturn(Boolean.FALSE);

        target.execute(table, robot);
    }
}
