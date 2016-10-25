import java.util.Hashtable;
import java.util.Stack;

/**
 * @author id14sap, 2015-04-23
 */
public class MemoryRobot extends Robot {

    private Stack<Position> pathStack;
    private Hashtable<Position, Boolean> markedPositions;

    /**
     * Creates a memory robot. Sets the current position to the start
     * position of the maze.
     *
     * @param maze - The maze that the robot should run in.
     */
    public MemoryRobot(Maze maze) {
        super(maze);
        pathStack = new Stack<>();
        markedPositions = new Hashtable<>();
    }

    /**
     * The move method for this robot. Marks the current position and then
     * checks if the robot can move either to the south, west, east or north -
     * with the isMovable() method. If it can't move, it will go back to
     * where it was via the stack until it can move again.
     * @see MemoryRobot#validMove(Position)
     */
    @Override
    public void move() {

        Position South = getCurrentPosition().getPosToSouth();
        Position West = getCurrentPosition().getPosToWest();
        Position East = getCurrentPosition().getPosToEast();
        Position North = getCurrentPosition().getPosToNorth();

        markPosition();

        if (validMove(South)) {
            setCurrentPosition(South);
        } else if (validMove(West)) {
            setCurrentPosition(West);
        } else if (validMove(East)) {
            setCurrentPosition(East);
        } else if (validMove(North)) {
            setCurrentPosition(North);
        }
        // If the robot can't move, move back one position, and check if it
        // has to pop. The only time it should pop is when there is no way to
        // go. An example is a four way intersection, then the robot should
        // not pop, because it can go another way.
        else {
            setCurrentPosition(pathStack.peek());

            // Check the new surroundings of current position
            if(robotIsStuck(getCurrentPosition()))
                pathStack.pop();
        }
    }

    /**
     * Checks if a position is valid to move to. Checks in the hash table if
     * the position is "marked".
     *
     * @param p - The position to check
     * @return True if the given position is not marked.
     */
    private boolean validMove(Position p) {
        return !markedPositions.containsKey(p) && maze.isMovable(p);
    }

    /**
     * Marks the current position in the hash table and also puts the current
     * position in the stack, only if the current position isn't already marked.
     */
    private void markPosition() {
        if(!markedPositions.containsKey(getCurrentPosition())) {
            markedPositions.put(getCurrentPosition(), true);
            pathStack.push(getCurrentPosition());
        }
    }

    /**
     * Helper function to look around the robot is stuck.
     * @param p - a position to check
     * @return True if the robot is stuck and can't move nowhere
     */
    private Boolean robotIsStuck(Position p) {
        return !validMove(getCurrentPosition().getPosToSouth()) &&
                !validMove(getCurrentPosition().getPosToWest()) &&
                !validMove(getCurrentPosition().getPosToNorth()) &&
                !validMove(getCurrentPosition().getPosToEast());
    }
}