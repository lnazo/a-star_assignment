package com.mca.astar.interfaces;

import com.mca.astar.Path;

/**
 * @author Lubabalo Nazo
 */
public interface PathFinder
{
    /**
     * Get the route from start to finish
     * @param object The object that is moving
     * @param startX The x coordinate of the start tile
     * @param startY The y coordinate of the start tile
     * @param goalX The x coordinate of the goal tile
     * @param goalY The y coordinate of the goal tile
     * @return The route from start to finish
     */
    public Path findPath(String object, int startX, int startY, int goalX, int goalY);
}