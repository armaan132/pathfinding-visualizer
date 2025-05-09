import java.util.ArrayList;
import java.util.List;

public class Grid {
    private int rows;
    private int columns;
    private Cell[][] cells;

    //Constructer for num columns and rows
    public Grid(int setrows, int setcolumns) {
        rows = setrows;
        columns =  setcolumns;
        cells = new Cell[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }

    }

    public void printGrid() {
        //Tracks the rows and columns defined in grid class and creates a grid of that size
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //Creates pointer that references the specific cell to update to either S, G, or #
                Cell cell = cells[i][j];

                if (cell.isStart()) {
                    System.out.print(" S ");
                } else if (cell.isGoal()) {
                    System.out.print(" G ");
                } else if (cell.isPath()) {
                    System.out.print(" X ");
                } else if (cell.isVisited()) {
                    System.out.print(" o ");
                }else if (cell.isObstacle()) {
                    System.out.print(" # ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }

    public Cell getCell(int row, int column) {
        return cells[row][column];
    }

    public List<Cell> getNeighbors(Cell cell) {
        List<Cell> neighbors = new ArrayList<>();
        if (cell.getRow() > 0) {
            neighbors.add(cells[cell.getRow() - 1][cell.getColumn()]);
        }

        if (cell.getRow() < rows - 1) {
            neighbors.add(cells[cell.getRow() + 1][cell.getColumn()]);
        }

        if (cell.getColumn() > 0) {
            neighbors.add(cells[cell.getRow()][cell.getColumn() - 1]);
        }

        if (cell.getColumn() < columns - 1) {
            neighbors.add(cells[cell.getRow()][cell.getColumn() + 1]);
        }

        return neighbors;
    }

    //way to access the Start tile from the Grid class
    public Cell getStartCell() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (cells[i][j].isStart()) {
                    return cells[i][j];
                }
            }
        }
        return null;
    }

    //way to access the Goal tile from the Grid class
    public Cell getGoalCell() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (cells[i][j].isGoal()) {
                    return cells[i][j];
                }
            }
        }
        return null;
    }

    //reset grid - does not reset S, G, and Obstacles
    public void resetGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Cell cell = cells[i][j];
                cell.setVisited(false);
                cell.setPath(false);
            }
        }
    }

    //full reset grid - resets everything to original state of the grid
    public void fullResetGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Cell cell = cells[i][j];
                cell.setVisited(false);
                cell.setPath(false);
                cell.setStart(false);
                cell.setGoal(false);
                cell.setObstacle(false);
            }
        }
    }
}

