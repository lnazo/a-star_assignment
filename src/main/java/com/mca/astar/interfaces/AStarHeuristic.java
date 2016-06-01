package com.mca.astar.interfaces;

/**
 * A* Heuristic (calculates cost of tiles)
 * @author Lubabalo Nazo
 */
public interface AStarHeuristic
{
    /**
     * Calculate the estimate of a tile for the overall path
     * @param map Map that contains the path
     * @param object The object that is moving
     * @param x The x coordinate of the current tile
     * @param y The y coordinate of the current tile
     * @param goalX The x coordinate of the goal tile
     * @param goalY The y coordinate of the goal tile
     * @return The cost of the given tile
     */
    public float getCost(TileBasedMap map, String object, int x, int y, int goalX, int goalY);
}
