import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


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

        //handling of no possible path - exits function
        if (!path.containsKey(goal)) {
            System.out.println("No path found BFS");
            return;
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

    public static void dfs(Grid grid, Cell start, Cell goal) {
        //dfs uses stack, map parent child relationship
        Stack<Cell> frontier = new Stack<>();
        Map<Cell, Cell> path = new HashMap<>();

        //set conditions for starting
        frontier.push(start);
        start.setVisited(true);
        path.put(start, null);

        //dfs implementation
        while(!frontier.isEmpty()) {
            Cell current = frontier.pop();

            //finds goal - code breaks
            if (current == goal) {
                break;
            }

            List<Cell> neighbors = grid.getNeighbors(current);
            for (int i = 0; i < neighbors.size(); i++) {
                if (!neighbors.get(i).isObstacle() && !neighbors.get(i).isVisited()) {
                    neighbors.get(i).setVisited(true);
                    frontier.push(neighbors.get(i));
                    path.put(neighbors.get(i), current);
                }
            }
        }

        //handling of no possible path - exits function
        if (!path.containsKey(goal)) {
            System.out.println("No path found DFS");
            return;
        }

        //reconstruct path when goal is found
        List<Cell> dfsPath = reconstructPath(path, start, goal);
        for (int i = 0; i < dfsPath.size(); i++) {
            Cell cell = dfsPath.get(i);
            if (!cell.isStart() && !cell.isGoal()) {
                cell.setPath(true);
            }
        }
        
        grid.printGrid();
    }

    public static void aStar(Grid grid, Cell start, Cell goal) {
        
    }

    //travels backwards and consructs the path from goal to cell
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