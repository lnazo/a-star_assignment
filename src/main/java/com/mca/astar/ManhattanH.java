package com.mca.astar;

import com.mca.astar.interfaces.AStarHeuristic;
import com.mca.astar.interfaces.TileBasedMap;

/**
 * Manhattan Heuristic implementation
 * @author Lubabalo Nazo
 */
public class ManhattanH implements AStarHeuristic
{
    private int cost;

    /**
     * Determine the heuristic cost
     * @param newCost The cost at a tile
     */
/*    public ManhattanH(int newCost)
    {
        this.cost = newCost;
    }*/

    // calculates cost using Manhattan Heuristic
    public float getCost(TileBasedMap map, String object, int x, int y, int goalX, int goalY)
    {
        cost = cost * (Math.abs(x - goalX) + Math.abs(y - goalY));
        return cost;
    }
}
