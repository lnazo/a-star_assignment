package com.mca.astar;

/**
 * Driver class
 * @author Lubabalo Nazo
 */
public class Map
{
    // the map to build
    private BuildMap buildMap = new BuildMap();
    private static String[][] tiledMap;

    // the path to find
    private AStar pathFinder;
    private Path path;

    public static void main(String[] args)
    {
        // builds up the map based on text file input
        Map obj = new Map();
        tiledMap = obj.buildMap.getTiledMap();

        // finds the path based on start and goal position
        obj.pathFinder = new AStar(obj.buildMap, 100);
        obj.path = obj.pathFinder.findPath(null, 0, 0, 4, 4);

        originalMap();

        for (int i = 0; i < obj.path.getLength(); i++)
        {
            tiledMap[obj.path.getX(i)][obj.path.getY(i)] = "#";
        }

        System.out.println();
        routeTaken();
    }

    /**
     * Print out the original tiled map
     */
    public static void originalMap()
    {
        System.out.println("Initial map");
        for (int i = 0; i < tiledMap.length; i++)
        {
            for (int j = 0; j < tiledMap.length; j++)
            {
                System.out.print(tiledMap[j][i]);
            }
            System.out.println();
        }
    }

    /**
     * Print out the tiled map after traversal
     */
    public static void routeTaken()
    {
        System.out.println("Traversed map");
        for (int i = 0; i < tiledMap.length; i++)
        {
            for (int j = 0; j < tiledMap.length; j++)
            {
                System.out.print(tiledMap[j][i]);
            }
            System.out.println();
        }
    }
}