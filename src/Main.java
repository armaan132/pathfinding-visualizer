
public class Main {
    public static void main(String[] args) {
        //First line - test
        System.out.println("Welcome to proj");
        Grid grid = new Grid(10, 10);


        //Sets 0, 0 to start, 9, 9 to goal, allows user input later integrations
        grid.getCell(0, 0).setStart(true);
        grid.getCell(9, 9).setGoal(true);

        //Set some obstacles for now - later I want to create random obstacles using system clock
        //I want to use try - catch construct to generate maze that works - error message No path possible!
        grid.getCell(3, 3).setObstacle(true);
        grid.getCell(3, 4).setObstacle(true);
        grid.getCell(3, 5).setObstacle(true);
        grid.getCell(4, 5).setObstacle(true);
        grid.getCell(5, 5).setObstacle(true);
        grid.getCell(6, 5).setObstacle(true);




        //displays the grid initially
        grid.printGrid();

        System.out.println("\n\nRunning BFS algorithm!!\n\n");

        PathfindingAlgorithms.bfs(grid, grid.getStartCell(), grid.getGoalCell());

        //PUSHHHHHHHHHHH TIOOO GITTTTT
    }
}