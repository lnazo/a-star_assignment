package com.mca.astar.Heuristic;

/**
 * Manhattan Heuristic implementation
 * @author Lubabalo Nazo
 */
public class ManhattanH implements AStarHeuristic
{
    // calculates cost using Manhattan Heuristic
    public float getCost(int x, int y, int goalX, int goalY)
    {
        float dx = Math.abs(x - goalX);
        float dy = Math.abs(y - goalY);

        return dx + dy;
    }
}