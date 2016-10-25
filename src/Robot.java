/**
 * @author id14sap, 2015-04-22
 */
public abstract class Robot {

    private Position position;
    protected Maze maze;

    /**
     * Creates a robot object. Sets the robot's position to the start
     * position of the maze.
     * @param maze - A maze for the robot to run in.
     */
    public Robot(Maze maze) {
        this.maze = maze;
        position = maze.getStartPosition();
    }

    /**
     * Override move method in subclasses.
     */
    public abstract void move();

    /**
     * Gets the current position of the robot.
     */
    public Position getCurrentPosition() {
        return position;
    }

    /**
     * Sets the position for this robot to the given position. Assumes that
     * the position is a movable position.
     * @param p - The position to be set
     */
    protected void setCurrentPosition(Position p) {
        position = p;
    }

    /**
     * Checks if the robot has reached the goal. Uses the class Maze to
     * determine if the given position is a goal position with the method
     * isGoal()
     * @return True if the robot has reached the goal
     * @see Maze#isGoal(Position)
     */
    public boolean hasReachedGoal() {
        return maze.isGoal(position);
    }
}
