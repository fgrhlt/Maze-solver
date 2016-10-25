import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author id14sap on 2015-04-20.
 */
public class Maze {

    private char[][] mazeData;
    private Position startPosition;

    /**
     * Creates a maze from a reader and makes it into
     * a character matrix - mazeData, if and only if the file contains a
     * start and end position. When it finds the startPosition it will set
     * that position to the attribute startPosition.
     *
     * To access the coordinates in the maze, it has to be done through
     * mazeData[y][x] - since the maze is represented as a character matrix,
     * which index it's values as row, column.
     *
     * @param reader - a file reader with a maze .txt-file
     * @throws Error - If the maze file did not have a start and end
     * character.
     */
    public Maze(java.io.Reader reader) {

        String inputString;
        String mazeString = "";
        boolean startChar = false;
        boolean endChar = false;

        try {
            BufferedReader input = new BufferedReader(reader);
            // Make a string representation of the input stream
            while((inputString = input.readLine()) != null) {
                mazeString += inputString + "\n";
            }

            // Break up the input string into lines of text.
            String[] textLine = mazeString.split("[\r]?\n");

            // Create matrix from the length of the text string.
            mazeData = new char[textLine.length][textLine[0].length()];

            // Check if start and end character exists in the file
            for (int row = 0; row < mazeData.length; row++) {
                for (int col = 0; col < mazeData[0].length; col++) {
                    if(textLine[row].charAt(col) == 'S') {
                        startPosition = new Position(col, row);
                        startChar = true;
                    }
                    if(textLine[row].charAt(col) == 'G') {
                        endChar = true;
                    }
                }
            }

            // Fill maze if start- and end character exists
            if(startChar && endChar) {
                for (int row = 0; row < mazeData.length; row++) {
                    for (int col = 0; col < mazeData[0].length; col++) {
                        mazeData[row][col] = textLine[row].charAt(col);
                    }
                }
            }
            else {
                throw new Error("The maze did not contain a start " +
                        "and/or end character. Check file \n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if a given position is a movable position (i.e " " in the maze).
     * The position has to be greater than -1 on x and y and be in the
     * interval of the matrix.
     * @param p - the position to check
     * @return true if the position is anything but an asterisk and inside
     * the interval of the matrix.
     */
    public boolean isMovable(Position p) {
        int x = p.getX();
        int y = p.getY();

        // return true only if the position is in the interval
        if(x > -1 && y > -1 && x < mazeData[0].length && y < mazeData.length)
            return mazeData[y][x] != '*';
        else return false;
    }

    /**
     * Checks if the given position is a goal position (i.e "G" in the maze).
     * @param p - the position to check
     * @return true if the position is 'G'.
     */
    public boolean isGoal(Position p) {
        return mazeData[p.getY()][p.getX()] == 'G';
    }

    /**
     * Gets the start position of the maze.
     * @return the attribute startPosition.
     */
    public Position getStartPosition() {
        return startPosition;
    }
}