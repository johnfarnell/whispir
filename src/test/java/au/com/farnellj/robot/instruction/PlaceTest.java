package au.com.farnellj.robot.instruction;

import au.com.farnellj.robot.entity.*;
import au.com.farnellj.robot.exception.InstructionException;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PlaceTest {

    @Test
    public void shouldPlaceTheRobotAtCoordinateWithDirectionWhenInValidPosition() {
        Coordinate coordinate = mock(Coordinate.class);
        when(coordinate.getX()).thenReturn(4);
        when(coordinate.getY()).thenReturn(5);
        Direction direction = Direction.NORTH;
        Place target = new Place(coordinate, direction);

        Table table = mock(Table.class);
        Robot robot = mock(Robot.class);
        //Mock behaviour
        when(table.isValidPosition(any())).thenReturn(Boolean.TRUE);

        target.execute(table, robot);

        ArgumentCaptor<Coordinate> coordinateCapture = ArgumentCaptor.forClass(Coordinate.class);
        verify(table).isValidPosition(coordinateCapture.capture());
        assertEquals(4, coordinateCapture.getValue().getX());
        assertEquals(5, coordinateCapture.getValue().getY());

        ArgumentCaptor<Orientation> orientationCapture = ArgumentCaptor.forClass(Orientation.class);
        verify(robot).setOrientation(orientationCapture.capture());

        assertEquals(4, orientationCapture.getValue().getCoordinate().getX());
        assertEquals(5, orientationCapture.getValue().getCoordinate().getY());
        assertEquals(Direction.NORTH, orientationCapture.getValue().getDirection());
    }

    @Test(expected = InstructionException.class)
    public void shouldThrowExceptionWhenPlacedInAPositionNotOnTable() {
        Coordinate coordinate = mock(Coordinate.class);
        when(coordinate.getX()).thenReturn(4);
        when(coordinate.getY()).thenReturn(5);
        Direction direction = Direction.NORTH;
        Place target = new Place(coordinate, direction);

        Table table = mock(Table.class);
        Robot robot = mock(Robot.class);
        //Mock robot behaviour
        when(table.isValidPosition(any())).thenReturn(Boolean.FALSE);

        target.execute(table, robot);
    }

}
