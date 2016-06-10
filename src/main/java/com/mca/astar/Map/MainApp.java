package com.mca.astar.Map;

import com.mca.astar.AStar.AStarMethod;
import com.mca.astar.Path.Path;
import org.apache.log4j.Logger;

/**
 * Driver class
 * @author Lubabalo Nazo
 */
public class MainApp
{
    // the map to build
    private MapBuilder mapBuilder = new MapBuilder();
    private static String[][] tiledMap;

    // the path to find
    static AStarMethod pathFinder;
    public static Path path;

    // for debugging
    //private static final Logger LOG = Logger.getLogger(MainApp.class);

    public static void main(String[] args)
    {
        // builds up the map based on text file input
        MainApp obj = new MainApp();

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
            //LOG.debug("The following error occurred : " + e);
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