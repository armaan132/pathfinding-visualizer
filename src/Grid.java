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
                    System.out.println(" G ");
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

}

