import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * Position Tester.
 *
 * @author id14sap
 * @version 1.0
 * @since <pre>apr 16, 2015</pre>
 */
public class PositionTest {

    Position myPosition;

    @Before
    public void before() throws Exception {
        // Make new position at every test
        myPosition = new Position(0,0);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Test constructor of Position. Expects to be not null.
     */
    @Test
    public void testPositionNotNull() {
        assertNotNull("Position class is null \n", myPosition);
    }

    /**
     * Tests the accessor getX() of Position. Expects to get 0.
     * Method: getX()
     */
    @Test
    public void testGetX() throws Exception {
        int val = myPosition.getX();
        assertEquals("X value was not right \n", 0, val);
    }

    /**
     * Tests the accessor getY() of Position. Expects to get 0.
     * Method: getY()
     */
    @Test
    public void testGetY() throws Exception {
        int val = myPosition.getY();
        assertEquals("Y value was not right \n", 0, val);
    }

    /**
     * Tests to move the position down. Expects to get -1 on y-axis.
     * Method: getPosToSouth()
     */
    @Test
    public void testGetPosToSouth() throws Exception {
        Position newPosition = myPosition.getPosToSouth();
        int val = newPosition.getY();
        assertEquals("Position was not moved south \n", 1, val);
    }

    /**
     * Tests to move the position up. Expects to get 1 on y-axis.
     * Method: getPosToNorth()
     */
    @Test
    public void testGetPosToNorth() throws Exception {
        Position newPosition = myPosition.getPosToNorth();
        int val = newPosition.getY();
        assertEquals("Position was not moved north \n", -1, val);
    }

    /**
     * Tests to move the position left. Expects to get -1 on x-axis.
     * Method: getPosToWest()
     */
    @Test
    public void testGetPosToWest() throws Exception {
        Position newPosition = myPosition.getPosToWest();
        int val = newPosition.getX();
        assertEquals("Position was not moved west\n", -1, val);
    }

    /**
     * Tests to move the position right. Expects to get 1 on x-axis.
     * Method: getPosToEast()
     */
    @Test
    public void testGetPosToEast() throws Exception {
        Position newPosition = myPosition.getPosToEast();
        int val = newPosition.getX();
        assertEquals("Position was not moved east\n", 1, val);
    }

    /**
     * Method: equals(Object o)
     */
    @Test
    public void testEquals() throws Exception {
    }

    /**
     * Method: hashCode()
     */
    @Test
    public void testHashCode() throws Exception {
    }


} 
