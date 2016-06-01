package com.mca.astar;

import com.mca.astar.interfaces.AStarHeuristic;
import com.mca.astar.interfaces.TileBasedMap;

import java.util.ArrayList;

/**
 * Implementation of A* Algorithm
 * @author Lubabalo Nazo
 */
public class AStar
{
    // open list that keeps track of tiles to be processed
    private ArrayList open = new ArrayList();

    // closed list that has tiles already processed
    private ArrayList closed = new ArrayList(); //remember to sort

    // the map that will be searched
    private TileBasedMap map;

    // set of tiles in the map
    private Node[][] nodes;

    // the max distance to consider
    private int maxSearchDistance;

    // heuristic that will calculate cost of tiles
    private AStarHeuristic heuristic;

    /**
     * Initialises the map
     * @param map Map that contains the path
     * @param maxSearchDistance The max distance to consider
     * @param heuristic The heuristic used to determine search pattern
     */
    public AStar(TileBasedMap map, int maxSearchDistance, AStarHeuristic heuristic)
    {
        this.heuristic = heuristic;
        this.map = map;
        this.maxSearchDistance = maxSearchDistance;

        nodes = new Node[map.getBreadthOfTiles()][map.getHeightOfTiles()];
        for (int x = 0; x < map.getBreadthOfTiles(); x++)
        {
            for (int y = 0; y < map.getHeightOfTiles(); y++)
            {
                nodes[x][y] = new Node(x, y);
            }
        }
    }

    public Path findPath(String object, int startX, int startY, int goalX, int goalY)
    {
        // to be added
        return null;
    }
}
