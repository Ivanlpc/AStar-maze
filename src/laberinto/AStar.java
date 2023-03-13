/**

 This class represents an implementation of the A* algorithm for finding the shortest path
 from a start node to an end node in a given maze.
 The algorithm uses a priority queue to store the open set, and a hash set to store the closed set.
 The heuristic function used is the Manhattan distance between two nodes.
 The find() method performs the A* search and returns the maze with the shortest path marked.
 The heuristic() method calculates the Manhattan distance between a node and the end node.
 The getNeighbors() method returns a list of the neighboring nodes of a given node.
 The write_path() method traces back the shortest path from the end node to the start node and
 marks the nodes on the path in the maze.
 @author Ivanlpc
 */

package laberinto;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class AStar {
    private final Maze maze;
    private final Set<Node> closedSet = new HashSet<>();
    private final PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(node -> node.getH() + node.getG()));

    private final char pathChar;
    /**
     * Constructs an AStar object with a given maze
     *
     * @param maze the maze in which the shortest path is to be found
     * @param pathChar char symbol of the path
     */
    public AStar(Maze maze, char pathChar) {
        this.pathChar = pathChar;
        this.maze = maze;
    }

    /**
     * Performs the A* search and returns the maze with the shortest path marked.
     *
     * @return the maze with the shortest path marked, or null if no path is found
     */
    public Maze find() {
        int starting_g = 0;
        maze.getStart().setG(starting_g);
        maze.getStart().setH(0);
        openSet.add(maze.getStart());
        while (!openSet.isEmpty()) {
            Node current = openSet.peek();
            if (current.equals(maze.getEnd())) {
               return write_path(current);
            } else {
                openSet.remove(current);
                closedSet.add(current);
                for (Node neighbor : getNeighbors(current)) {
                    int tentative_g = current.getG() + 1;
                    if (closedSet.contains(neighbor)) {
                        continue;
                    }
                    if (!openSet.contains(neighbor) || tentative_g < neighbor.getG()) {
                        neighbor.setG(tentative_g);
                        neighbor.setParent(current);
                        neighbor.setH(heuristic(neighbor));
                        if (!openSet.contains(neighbor)) {
                            openSet.add(neighbor);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * Calculate the heuristic function of the given node.
     * @param n Node to calculate the heuristic value
     * @return the manhattan distance between the given Node and the Final Node
     */
    private int heuristic(Node n) {
        return Math.abs(maze.getEnd().getX() - n.getX()) + Math.abs(maze.getEnd().getY() - n.getY());
    }

    /**
     Returns a list of neighboring nodes that are not obstructed by obstacles or the maze border.
     @param node the node to find the neighbors of
     @return a list of neighboring nodes
     */
    private List<Node> getNeighbors(Node node) {
        ArrayList<Node> neighbors = new ArrayList<>();
        if (!maze.isObs(node.getX() + 1, node.getY())) {
            Node n = new Node(node.getX() + 1, node.getY());
            neighbors.add(n);
        }

        if (!maze.isObs(node.getX(), node.getY() + 1)) {
            Node n = new Node(node.getX(), node.getY() + 1);
            neighbors.add(n);
        }

        if (!maze.isObs(node.getX() - 1, node.getY())) {
            Node n = new Node(node.getX() - 1, node.getY());
            neighbors.add(n);
        }

        if (!maze.isObs(node.getX(), node.getY() - 1)) {
            Node n = new Node(node.getX(), node.getY() - 1);
            neighbors.add(n);
        }
        return neighbors;
    }

    /**

     Writes a path from a given node to the starting node in the maze.
     @param n the node to start writing the path from
     @return the updated Maze object with the path written on it
     */
    private Maze write_path(Node n) {
        Node parent = n.getParent();
        while (!parent.equals(maze.getStart())) {
            maze.setPath(parent, pathChar);
            parent = parent.getParent();
        }
        return this.maze;
    }
}
