import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;

import static org.junit.Assert.*;

/**
 * Maze Tester.
 *
 * @author id14sap
 * @version 1.0
 * @since <pre>apr 21, 2015</pre>
 */
public class MazeTest {

    Maze testMaze;

    @Before
    public void before() {

        try {
            FileReader input = new FileReader("maze.txt");
            testMaze = new Maze(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @After
    public void after() throws Exception {
    }

    /**
     * A test to assure that the maze is not empty.
     */
    @Test
    public void testMazeNotNull() {
        assertNotNull(testMaze);
    }

    /**
     * Tests to create a maze with no start point. This should throw an
     * Error, and this test expects an error.
     */
    @Test(expected=Error.class)
    public void testMazeException() {
        FileReader badInput = null;
        try {
            badInput = new FileReader("badmaze.txt");
            Maze badMaze = new Maze(badInput);
            badInput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests if the given position (0,0) of the maze (maze1.txt) is movable.
     * Should return false.
     * Method: isMovable(Position p)
     */
    @Test
    public void testIsMovable() {
        Position p = new Position(11,1);
        Boolean b = testMaze.isMovable(p);
        assertFalse("The given position was movable, should be a * \n", b);
    }

    /**
     * Tests what happens when a position is out of bounds in the maze.
     * Should return false when the position is -1,-1.
     */
    @Test
    public void testOutOfBounds() {
        Position p = new Position(-1,-1);
        Boolean b = testMaze.isMovable(p);
        assertFalse("The given position was movable, should return false \n", b);
    }

    /**
     * Tests if the given position is a goal position. Should pass since the
     * goal position is at x=8, y=6 in "maze.txt".
     * Method: isGoal()
     */
    @Test
    public void testIsGoal() {
        Position p = new Position(8, 6);
        Boolean b = testMaze.isGoal(p);
        assertTrue("The given position is not a goal \n", b);
    }

    /**
     * Tests if a given position is a start position. Should pass since the
     * position in "maze.txt" is at x=1 y=0.
     * Method: getStartPosition()
     */
    @Test
    public void testGetStartPosition() {
        Position start = testMaze.getStartPosition();
        Position p = new Position(1, 0);

        Assert.assertEquals("The position was not a start position", p, start);
    }
}
