package com.mca.astar;

/**
 * Node class
 * @author Lubabalo Nazo
 */
public class Node implements Comparable
{
    // x and y coordinates of a given tile
    private int x;
    private int y;

    // depth to search
    private int depth;

    // cost of search
    private float cost;

    // heuristic used
    private float heuristic;

    // tile under consideration
    private Node parent;

    /**
     * Create a new tile
     * @param x The new x coordinate
     * @param y The new y coordinate
     */
    public Node(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x coordinate of the tile
     * @return The x coordinate of the tile
     */
    public int getX()
    {
        return x;
    }

    /**
     * Get the y coordinate of the tile
     * @return The y coordinate of the tile
     */
    public int getY()
    {
        return y;
    }

    /**
     * Get the cost incurred
     * @return The cost incurred
     */
    public float getCost()
    {
        return cost;
    }

    /**
     * Get the heuristic used
     * @return The heuristic used
     */
    public float getHeuristic()
    {
        return heuristic;
    }

    /**
     * Get the depth
     * @return The depth
     */
    public int getDepth()
    {
        return depth;
    }

    /**
     * Get the tile under consideration
     * @return The tile under consideration
     */
    public Node getParent()
    {
        return parent;
    }

    /**
     * Set the new cost
     * @param newCost The new cost
     */
    public void setCost(float newCost)
    {
        cost = newCost;
    }

    /**
     * Set the new heuristic
     * @param newHeuristic The new heuristic
     */
    public void setHeuristic(float newHeuristic)
    {
        heuristic = newHeuristic;
    }

    /**
     * Set the new depth
     * @param newDepth The new depth
     */
    public void setDepth(int newDepth)
    {
        depth = newDepth;
    }

    /**
     * Set the new tile under consideration
     * @param newParent The new tile
     */
    public void setParent(Node newParent)
    {
        parent = newParent;
    }

    /**
     * Set the depth of the new tile
     * @param parent The depth of the new tile
     */
    public int setParentDepth(Node parent)
    {
        depth = parent.depth + 1;
        this.parent = parent;

        return depth;
    }

    /**
     * Returns comparison of two objects
     * @return True if the tiles are equal
     */
    public int compareTo(Object object)
    {
        Node newObject = (Node) object;

        float f = heuristic + cost;
        float newF = newObject.heuristic + newObject.cost;

        if (f < newF)
            return -1;

        else if (f > newF)
            return 1;

        else
            return 0;

    }
}
