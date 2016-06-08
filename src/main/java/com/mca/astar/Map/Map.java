package com.mca.astar.Map;

import com.mca.astar.AStar.AStarMethod;
import com.mca.astar.Path.Path;

/**
 * Driver class
 * @author Lubabalo Nazo
 */
public class Map
{
    // the map to build
    MapBuilder mapBuilder = new MapBuilder();
    static String[][] tiledMap;

    // the path to find
    static AStarMethod pathFinder;
    public static Path path;

    public static void main(String[] args)
    {
        // builds up the map based on text file input
        Map obj = new Map();

        try
        {
            if (args.length == 0)
                obj.mapBuilder.getFile("small_map.txt");
            else
                obj.mapBuilder.getFile(args[0]);

            tiledMap = obj.mapBuilder.getTiledMap();

            // finds the path based on start and goal position
            obj.pathFinder = new AStarMethod(obj.mapBuilder, 100);
            obj.path = obj.pathFinder.findPath(0, 0, tiledMap.length - 1, tiledMap.length - 1);

            originalMap();

            for (int i = 0; i < obj.path.getLength(); i++)
            {
                tiledMap[obj.path.getX(i)][obj.path.getY(i)] = "#";
            }

            System.out.println();
            routeTaken();
        }

        catch (Exception e)
        {
            System.out.println("Let's try that again, shall we?");
        }
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