/**
 The Main class to run the AStar algorithm on a randomly generated maze.
 The class generates a random maze with a specified percentage of obstacles,
 and then runs the AStar algorithm to find a path from the start to the end of the maze.
 If a path is found, it displays the maze with the path marked using a specified path character.
 If no path is found, it displays the original maze and prints a message indicating that no path was found.
 Author: Ivanlpc
 */
package laberinto;

public class Main {
    private static final double OBS_PERCENTAGE = 0.3;
    private static final int ROWS = 60;
    private static final int COLUMNS = 80;
    private static final char OBS_CHAR = '█';
    private static final char PATH_CHAR = '+';

    /**
     * The main method that generates a maze, runs the AStar algorithm, and displays the resulting maze.
     *
     * @param args an array of command-line arguments that are not used in this program
     */
    public static void main(String[] args) {
        Maze maze = new Maze(ROWS, COLUMNS, OBS_PERCENTAGE, OBS_CHAR);
        AStar path = new AStar(maze, PATH_CHAR);
        Maze ans = path.find();
        if(ans == null) {
            maze.show();
            System.out.println("There is no path for this Maze");
        } else {
            ans.show();
        }
    }
}
