/**
 * Moves the robot so it walks along the wall of it's right hand. The goal
 * has to be connected to the start in the maze, otherwise this robot will
 * not work.
 * @author id14sap, 2015-04-25
 */
public class RightHandRuleRobot extends Robot {

    private String currentDirection = "North";
    private String[] directionList = new String[4];

    public RightHandRuleRobot(Maze maze) {
        super(maze);
    }

    /**
     * Keeps track of where the robot is facing and then checks if it can go
     * right, forward, left or backwards (depending on where it's facing).
     * The directions to move to is saved in a list which changes depending
     * on where the robot is facing. The robot only moves one step at a time.
     */
    @Override
    public void move() {

        updateDirections();

        // Loop through the directionList
        for(int i=0; i<4; i++) {

            String moveTo = directionList[i];
            // Get the direction to check from the directionsList
            Position p = getDirection(moveTo);

            // Check if the direction is movable, then move there and update
            // the direction.
            if(maze.isMovable(p)) {
                setCurrentPosition(p);
                currentDirection = moveTo;
                return;
            }
        }
    }

    /**
     * Returns the right position to use for the robot, depending on how
     * directionsList is ordered.
     * @param direction - A value from directionsList.
     * @return The right position to be used.
     * @throws IllegalArgumentException, if "direction" was wrong
     */
    private Position getDirection(String direction) {
        switch(direction) {
            case "North":
                return getCurrentPosition().getPosToNorth();
            case "South":
                return getCurrentPosition().getPosToSouth();
            case "West":
                return getCurrentPosition().getPosToWest();
            case "East":
                return getCurrentPosition().getPosToEast();
            default: throw new IllegalArgumentException("Direction can not be" +
                    " found \n");
        }
    }

    /**
     * This method changes the order in directionsList, depending on where
     * the robot is facing.
     * @throws Error - if currentDirection for some reason did not contain a
     * valid value.
     */
    private void updateDirections() {
        switch(currentDirection) {
            case "North":
                directionList[0] = "East";
                directionList[1] = "North";
                directionList[2] = "West";
                directionList[3] = "South";
                break;

            case "East":
                directionList[0] = "South";
                directionList[1] = "East";
                directionList[2] = "North";
                directionList[3] = "West";
                break;

            case "South":
                directionList[0] = "West";
                directionList[1] = "South";
                directionList[2] = "East";
                directionList[3] = "North";
                break;

            case "West":
                directionList[0] = "North";
                directionList[1] = "West";
                directionList[2] = "South";
                directionList[3] = "East";
                break;

            default:
                throw new Error("Something went wrong! \n");
        }
    }
}