/**
 * @author id14sap, 2015-04-15
 */
public class Position {

    private int x;
    private int y;

    /**
     * The x and y-values works as coordinates in the maze. The maze is made
     * of a two-dimensional character array, and therefore, to move north,
     * the y-axis has to be -1, and to go south the y-axis has to be +1 (to
     * work with the indices of the matrix).
     * @param x - the x-value that corresponds to the columns in the maze
     * @param y - the y-value that corresponds to the rows in the maze
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x-value of this position
     * @return The x-value as an integer
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y-value of this position
     * @return The y-value as an integer
     */
    public int getY() {
        return y;
    }

    /**
     * Move this position one step south (+1 on the rows of the matrix).
     * @return A new updated position
     */
    public Position getPosToSouth() {
        return new Position(x, y+1);
    }

    /**
     * Move this position one step north (-1 on the rows of the matrix).
     * @return A new updated position
     */
    public Position getPosToNorth() {
        return new Position(x, y-1);
    }

    /**
     * Move this position one step west (-1 on the x-axis).
     * @return A new updated position
     */
    public Position getPosToWest() {
        return new Position(x-1, y);
    }

    /**
     * Move this position one step east (+1 on the x-axis).
     * @return A new updated position.
     */
    public Position getPosToEast() {
        return new Position(x+1, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        return x == position.x && y == position.y;
    }
    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
