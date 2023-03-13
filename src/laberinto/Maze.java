/**
 * The Maze class represents a maze with obstacles and a starting and ending node.
 * The maze is created randomly based on the specified number of rows, columns,
 * and probability of obstacles. The maze can be displayed and a path can be set
 * on it.
 *
 * @author Ivanlpc
 */
package laberinto;

import java.util.Random;

public class Maze {
    private final char[][] maze;
    private final int rows;
    private final int columns;
    private final char obsChar;
    private final Node startNode;
    private final Node endNode;

    /**
     * Constructs a Maze Object
     *
     * @param rows number of rows
     * @param columns number of columns
     * @param obs percentage of obstacles
     * @param obsChar char symbol of the obstacle
     */
    public Maze(int rows, int columns, double obs, char obsChar) {
        maze = new char[rows][columns];
        this.rows = rows;
        this.columns = columns;
        this.obsChar = obsChar;

        Random numRandom = new Random();

        int posX = numRandom.nextInt(rows);
        int posY = numRandom.nextInt(columns);
        maze[posX][posY] = 'I';
        startNode = new Node(posX, posY);
        do {
            posX = numRandom.nextInt(rows);
            posY = numRandom.nextInt(columns);
        } while (maze[posX][posY] == 'I');

        maze[posX][posY] = 'G';
        endNode = new Node(posX, posY);

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'I' || maze[i][j] == 'G') {
                    continue;
                }
                if (numRandom.nextDouble() <= obs) {
                    maze[i][j] = obsChar;
                } else {
                    maze[i][j] = ' ';
                }
            }
        }
    }

    /**
     * Determines whether the specified coordinates correspond to an obstacle or maze border.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return true if the specified coordinates correspond to an obstacle or maze border,
     *         false otherwise
     */
    public boolean isObs(int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < columns) {
            return maze[x][y] == obsChar;
        }
        return true;
    }

    /**
     * Returns the starting node of the maze.
     *
     * @return the starting node of the maze
     */
    public Node getStart() {
        return startNode;
    }

    /**
     * Returns the ending node of the maze.
     *
     * @return the ending node of the maze
     */
    public Node getEnd() {
        return endNode;
    }


    /**
     * Displays the maze with a border.
     */
    public void show() {
        for(int i = 0 ; i < columns + 2; i++) {
            System.out.print("_");
        }
        System.out.println();
        for (char[] f : maze) {
            System.out.print("|");
            for (char c : f) {
                System.out.print(c);
            }
            System.out.print("|");
            System.out.println();
        }
        for(int i = 0 ; i < columns + 2; i++) {
            System.out.print("͞");
        }
        System.out.println();
    }

    /**
     * Sets the specified path on the maze.
     *
     * @param node
     */
    public void setPath(Node node, char pathChar) {
        maze[node.getX()][node.getY()] = pathChar;
    }
}
