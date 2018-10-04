package au.com.farnellj.robot.entity;

import au.com.farnellj.robot.config.TableConfigurationProperties;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TableTest {
    private Table target;
    private TableConfigurationProperties tableConfigurationProperties;

    @Before
    public void setUp() {
        tableConfigurationProperties = mock(TableConfigurationProperties.class);
        when(tableConfigurationProperties.getBottomLeftX()).thenReturn(4);
        when(tableConfigurationProperties.getBottomLeftY()).thenReturn(2);
        when(tableConfigurationProperties.getTopRightX()).thenReturn(6);
        when(tableConfigurationProperties.getTopRightY()).thenReturn(8);
        target = new Table(tableConfigurationProperties);
    }

    @Test
    public void shouldHaveCorrectCoordinates() {
        assertEquals(4, target.getBottomLeftCoordinate().getX());
        assertEquals(2, target.getBottomLeftCoordinate().getY());
        assertEquals(6, target.getTopRightCoordinate().getX());
        assertEquals(8, target.getTopRightCoordinate().getY());
    }

    @Test
    public void shouldAllowPositionOnBottomLeftBoundary() {
        Coordinate coordinate =
                new Coordinate(target.getBottomLeftCoordinate().getX(), target.getBottomLeftCoordinate().getY());
        assertTrue(target.isValidPosition(coordinate));
    }

    @Test
    public void shouldAllowPositionOnTopRightBoundary() {
        Coordinate coordinate =
                new Coordinate(target.getTopRightCoordinate().getX(), target.getTopRightCoordinate().getY());
        assertTrue(target.isValidPosition(coordinate));
    }

    @Test
    public void shouldAllowPositionWithinTheTable() {
        Coordinate coordinate =
                new Coordinate(5, 7);
        assertTrue(target.isValidPosition(coordinate));
    }

    @Test
    public void shouldFailWhenXOutsideTheTableGT() {
        Coordinate coordinate =
                new Coordinate(9, 7);
        assertFalse(target.isValidPosition(coordinate));
    }

    @Test
    public void shouldFailWhenXOutsideTheTableLT() {
        Coordinate coordinate =
                new Coordinate(1, 7);
        assertFalse(target.isValidPosition(coordinate));
    }

    @Test
    public void shouldFailWhenYOutsideTheTableGT() {
        Coordinate coordinate =
                new Coordinate(5, 9);
        assertFalse(target.isValidPosition(coordinate));
    }

    @Test
    public void shouldFailWhenYOutsideTheTableLT() {
        Coordinate coordinate =
                new Coordinate(5, 1);
        assertFalse(target.isValidPosition(coordinate));
    }
}
