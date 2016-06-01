package com.mca.astar.interfaces;

/**
 * @author Lubabalo Nazo
 */
public interface TileBasedMap
{
    /**
     * Get the breadth of the map
     * @return The number of tiles horizontally
     */
    public int getBreadthOfTiles();

    /**
     * Get the length of the map
     * @return The number of tiles vertically
     */
    public int getHeightOfTiles();

    /**
     * Check if the considered tile is blocked
     * @param x The x coordinate of the tile
     * @param y The y coordinate of the tile
     * @return true if the considered tile is blocked
     */
    public boolean blocked(String object, int x, int y);

    /**
     * Check if the considered tile is blocked
     * @param object The object that is moving
     * @param startX The x coordinate of the start tile
     * @param startY The y coordinate of the start tile
     * @param goalX The x coordinate of the goal tile
     * @param goalY The y coordinate of the goal tile
     * @return The cost of moving to a given tile
     */
    public float getCost(String object, int startX, int startY, int goalX, int goalY);

    /**
     * Notify the path finder that a tile has been checked
     * @param x The x coordinate of the tile visited
     * @param y The y coordinate of the tile visited
     */
    public void pathFinderVisited(int x, int y);
}