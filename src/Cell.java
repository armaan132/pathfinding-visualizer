public class Cell {
    private int row;
    private int column;

    //set to false naturally, assuming grid and 2 positions for goal and start, added obstacles
    private boolean isStart = false;
    private boolean isGoal = false;
    private boolean isObstacle = false;

    public Cell(int setrow, int setcolumn) {
        row = setrow;
        column = setcolumn;
    }

    //a get row method to allow access for the row if needed. allows to track important info about the cell
    public int getRow() {
        return row;
    }

    //a get column method to allow access for column if needed. also tracks important info about cell
    public int getColumn() {
        return column;
    }

    //toString for debugging and cell info
    public String toString() {
        return "(" + row + ", " + column + ")";
    }

    //set status for current cell - if is start
    public void setStart(boolean start) {
        isStart = start;
    }

    //set current status for current cell - if is goal
    public void setGoal(boolean goal) {
        isGoal = goal;
    }

    //set current status for current cell if is a obstacle
    public void setObstacle(boolean obstacle) {
        isObstacle = obstacle;
    }

    //"getter" for current status of cell if it is start
    public boolean isStart() {
        return isStart;
    }

    //"getter" for current status of a cell if it is goal
    public boolean isGoal() {
        return isGoal;
    }

    //"getter" for current status of a cell if it is a obstacle
    public boolean isObstacle() {
        return isObstacle;
    }
}