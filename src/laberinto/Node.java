/**

 This class represents a node in a tree, with an x and y position, a parent node, and g and heuristic values used in pathfinding algorithms.
 Author: Ivanlpc
 */
package laberinto;
import java.util.Objects;

public class Node {
    private final int x;
    private final int y;
    private int g = 0, h = 0;
    private Node parent;

    /**
     * Creates a new node with the specified x and y coordinates.
     *
     * @param x the x coordinate of the node
     * @param y the y coordinate of the node
     */
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the g value of this node.
     *
     * @param g the new g value
     */
    public void setG(int g) {
        this.g = g;
    }

    /**
     * Sets the heuristic value of this node.
     *
     * @param h the new heuristic value
     */
    public void setH(int h) {
        this.h = h;
    }

    /**
     * Sets the parent node of this node.
     *
     * @param parent the new parent node
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * Gets the g value of this node.
     *
     * @return the g value of this node
     */
    public int getG() {
        return g;
    }

    /**
     * Gets the heuristic value of this node.
     *
     * @return the heuristic value of this node
     */
    public int getH() {
        return h;
    }

    /**
     * Gets the parent node of this node.
     *
     * @return the parent node of this node
     */
    public Node getParent() {
        return parent;
    }

    /**
     * Gets the x coordinate of this node.
     *
     * @return the x coordinate of this node
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y coordinate of this node.
     *
     * @return the y coordinate of this node
     */
    public int getY() {
        return y;
    }

    /**
     * Calculates the hash code for this node based on its x and y coordinates.
     *
     * @return the hash code for this node
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Checks if this node is equal to another node.
     *
     * @param obj the object to compare to this node
     * @return true if the nodes has the same coordinates, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        return x == other.x && y == other.y;
    }

    /**
     * Returns a string representation of this node.
     *
     * @return a string representation of this node
     */
    @Override
    public String toString() {
        return "Node[X: " + this.x + " Y: " + this.y + "]";
    }
}
