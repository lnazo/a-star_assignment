package com.mca.astar;

import com.mca.astar.interfaces.PathFinder;

/**
 * Implementation of A* Algorithm
 * @author Lubabalo Nazo
 */
public class AStarMethod implements PathFinder
{
    // the map that will be searched
    private MapBuilder map;

    // set of tiles in the map
    private AStarNode[][] AStarNodes;

    // the max distance to consider
    private int maxSearchDistance;

    // make sure we don't exceed search depth
    private int maxDepth = 0;

    // heuristic that will calculate cost of tiles
    private ManhattanH heuristic;

    // methods for open and closed lists
    private ListHandler lists = new ListHandler();

    /**
     * Create a path finder with the default heuristic - closest to target.
     *
     * @param map The map to be searched
     * @param maxSearchDistance The maximum depth we'll search before giving up
     */
    public AStarMethod(MapBuilder map, int maxSearchDistance)
    {
        this(map, maxSearchDistance, new ManhattanH());
    }

    /**
     * Initialises the map
     * @param map Map that contains the path
     * @param maxSearchDistance The max distance to consider
     * @param heuristic The heuristic used to determine search pattern
     */
    public AStarMethod(MapBuilder map, int maxSearchDistance, ManhattanH heuristic)
    {
        this.heuristic = heuristic;
        this.map = map;
        this.maxSearchDistance = maxSearchDistance;

        AStarNodes = new AStarNode[map.getBreadthOfTiles()][map.getHeightOfTiles()];
        for (int x = 0; x < map.getBreadthOfTiles(); x++)
        {
            for (int y = 0; y < map.getHeightOfTiles(); y++)
            {
                AStarNodes[x][y] = new AStarNode(x, y);
            }
        }
    }

    // determines the path
    @Override
    public Path findPath(int startX, int startY, int goalX, int goalY)
    {
        if (map.isBlocked(goalX, goalY))
        {
            // path not found if destination is blocked
            return null;
        }

        // initial state for A*
        AStarNodes[startX][startY].setCost(0);
        AStarNodes[startX][startY].setDepth(0);
        lists.getClosedList().clear();
        lists.getOpenList().clear();
        // start node added to open list; closed list empty
        lists.addToOpenList(AStarNodes[startX][startY]);

        // parent of target location set to null (route not found yet)
        AStarNodes[goalX][goalY].setParent(null);

        // while max depth hasn't been exceeded
        while ((lists.getOpenListSize() != 0) && (maxDepth < maxSearchDistance))
        {
            // check the first node in the open list
            AStarNode current = lists.getFirstInOpenList();
            if (current == AStarNodes[goalX][goalY])
            {
                break;
            }

            // considered node is removed from open list and added
            // to closed list
            lists.removeFromOpenList(current);
            lists.addToClosedList(current);

            // check the neighbours of the current node
            for (int x = 0; x < 2; x++)
            {
                for (int y = 0; y < 2; y++)
                {
                    // don't consider the current location
                    if (x == 0 && y == 0)
                        continue;

                    // find a neighbouring tile and check it
                    int xp = x + current.getX();
                    int yp = y + current.getY();

                    if (validLocation(startX, startY, xp, yp))
                    {
                        // the current cost = cost of progress + cost of movement
                        float nextStepCost = current.getCost() + map.getCost(current.getX(), current.getY(), xp, yp);
                        AStarNode neighbour = AStarNodes[xp][yp];
                        map.pathFinderVisited(xp, yp);

                        // check the cost of the current tile
                        if (nextStepCost < neighbour.getCost())
                        {
                            if (lists.checkInOpenList(neighbour))
                                lists.removeFromOpenList(neighbour);
                            if (lists.checkInClosedList(neighbour))
                                lists.removeFromClosedList(neighbour);
                        }

                        // consider following tile as next possible step
                        if (!lists.checkInOpenList(neighbour) && !lists.checkInClosedList(neighbour))
                        {
                            neighbour.setCost(nextStepCost);
                            maxDepth = Math.max(maxDepth, neighbour.setParentDepth(current));
                            neighbour.setHeuristic(heuristic.getCost(xp, yp, goalX, goalY));
                            lists.addToOpenList(neighbour);
                        }
                    }
                }
            }
        }

        // if the search is complete and no path has been found
        if (AStarNodes[goalX][goalY].getParent() == null)
        {
            // if no path is found
            return null;
        }

        // find the path from the target location to the start location
        Path path = new Path();
        AStarNode target = AStarNodes[goalX][goalY];

        while (target != AStarNodes[startX][startY])
        {
            path.addStepToStart(target.getX(), target.getY());
            target = target.getParent();
        }

        path.addStepToStart(startX, startY);

        // path found
        return path;
    }

    /**
     * Check if the given location is valid
     * @param startX The start x coordinate
     * @param startY The start y coordinate
     * @param locX The x coordinate of the location to check
     * @param locY The y coordinate of the location to check
     * @return True if the location is valid
     */
    public boolean validLocation(int startX, int startY, int locX, int locY)
    {
        boolean invalid = (locX < 0) || (locY < 0) || (locX >= map.getBreadthOfTiles()) || (locY >= map.getHeightOfTiles());

        if ((!invalid) && (startX != locX) || (startY != locY))
        {
            invalid = map.isBlocked(locX, locY);
        }

        return !invalid;
    }
}