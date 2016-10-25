import java.io.*;

/**
 * @author id14sap, 2015-04-21
 */
public class MazeRun {

    /**
     * Runs the two robots in the maze and calculates their time and total
     * steps in the maze from start fo finish.
     * @param args
     */
    public static void main(String[] args) {

        try {
            // Create maze
            FileReader input = new FileReader(args[0]);
            Maze myMaze = new Maze(input);
            input.close();

            // Create robots
            Robot memoryRobot = new MemoryRobot(myMaze);
            Robot rightHandRobot = new RightHandRuleRobot(myMaze);
            int memRobotCount = 0;
            int rightHandCount = 0;

            // Start tests
            long start1 = System.nanoTime();
            while(!memoryRobot.hasReachedGoal()) {
                memoryRobot.move();
                memRobotCount++;
            }
            double elapsedTime1 = (System.nanoTime() - start1) / 1e9;

            long start2 = System.nanoTime();
            while (!rightHandRobot.hasReachedGoal()) {
                rightHandRobot.move();
                rightHandCount++;
            }
            double elapsedTime = (System.nanoTime() - start2) / 1e9;

            System.out.printf("Memory robot time: %.4f sec \n", elapsedTime1);
            System.out.printf("Right hand rule time: %.4f sec\n\n", elapsedTime);

            System.out.println("Memory robot steps: " + memRobotCount);
            System.out.println("Right hand robot steps: " + rightHandCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
