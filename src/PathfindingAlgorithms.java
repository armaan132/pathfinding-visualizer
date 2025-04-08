import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class PathfindingAlgorithms {

    //bfs - breadth first search method to use
    public static void bfs(Grid grid, Cell start, Cell goal) {
        //create queue to track visited cells, prevent repeats, and map cell to cell for parent to child relationship
        Queue<Cell> frontier = new LinkedList<>();
        Map<Cell, Cell> path = new HashMap<>();

        //set conditions for starting - add first wave for bfs, and start off setting visited cells and hashmap
        frontier.add(start);
        start.setVisited(true);
        path.put(start, null);

        //BFS implementation, adding neighbors and marking parent child relationships in hashmap
        //once goal is found the loop breaks
        while (!frontier.isEmpty()) {
            Cell current = frontier.poll();
            if (current == goal) {
                break;
            }

            List<Cell> neighbors = grid.getNeighbors(current);
            for (int i = 0; i < neighbors.size(); i++) {
                Cell currentneighbor = neighbors.get(i);

                if (!currentneighbor.isVisited() && !currentneighbor.isObstacle()) {
                    currentneighbor.setVisited(true);
                    frontier.add(currentneighbor);
                    path.put(currentneighbor, current);
                }
            }

        }

        //reconstruct original path after goal is reached
        List<Cell> bfsPath = reconstructPath(path, start, goal);
        for (int i = 0; i < bfsPath.size(); i++) {
            Cell cell = bfsPath.get(i);
            if (!cell.isStart() && !cell.isGoal()) {
                cell.setPath(true);
            }
        }
        //and display the shortest path
        grid.printGrid();
    }

    //travels backwards and consructs the BFS "shortest" path from goal to cell
    public static List<Cell> reconstructPath(Map<Cell, Cell> path, Cell start, Cell goal) {
        List<Cell> shortestPath = new ArrayList<>();
        Cell currentcell = goal;

        while(currentcell != null) {
            //traverse through hashmap acting like LinkedList and adding to list in reverse to create ordered path
            shortestPath.add(0, currentcell);
            currentcell = path.get(currentcell);
        }

        return shortestPath;
    } 
}