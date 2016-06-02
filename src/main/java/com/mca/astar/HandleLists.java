package com.mca.astar;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Methods to handle open and closed lists
 * @author Lubabalo Nazo
 */
public class HandleLists
{
    // open list that keeps track of tiles to be processed
    private ArrayList open = new ArrayList();

    // closed list that has tiles already processed
    private ArrayList closed = new ArrayList();

    public HandleLists()
    {
        // nothing to construct
    }

    /**
     * Get the open list
     * @return The open list
     */
    public ArrayList getOpenList()
    {
        return open;
    }

    /**
     * Get the closed list
     * @return The closed list
     */
    public ArrayList getClosedList()
    {
        return closed;
    }

    /**
     * Get the first tile in the open list
     * @return The first tile
     */
    public Node getFirstInOpenList()
    {
        return (Node)open.get(0);
    }

    /**
     * Add a new tile to the open list
     * @param node The new tile
     */
    public void addToOpenList(Node node)
    {
        open.add(node);
        Collections.sort(open);
    }

    /**
     * Add an evaluated tile to the closed list
     * @param node The evaluated tile
     */
    public void addToClosedList(Node node)
    {
        closed.add(node);
        Collections.sort(closed);
    }

    /**
     * Check if a tile exists in the open list
     * @param node The tile under consideration
     */
    public boolean checkInOpenList(Node node)
    {
        return open.contains(node);
    }

    /**
     * Check if a tile exists in the closed list
     * @param node The tile under consideration
     */
    public boolean checkInClosedList(Node node)
    {
        return closed.contains(node);
    }

    /**
     * Remove a tile in the open list
     * @param node The tile under consideration
     */
    public void removeFromOpenList(Node node)
    {
        open.remove(node);
    }

    /**
     * Remove a tile in the closed list
     * @param node The tile under consideration
     */
    public void removeFromClosedList(Node node)
    {
        closed.remove(node);
    }

    /**
     * Get the size of the open list
     * @return The size of the open list
     */
    public int getOpenListSize()
    {
        return open.size();
    }

    /**
     * Get the size of the closed list
     * @return The size of the closed list
     */
    public int getClosedListSize()
    {
        return closed.size();
    }
}
