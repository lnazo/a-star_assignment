package com.mca.astar;

/**
 * Driver class that contains the map
 * @author Lubabalo Nazo
 */
public class Map
{
    private BuildMap buildMap = new BuildMap();
    private static String[][] tiledMap;
    private static int[][] terrain;

    private AStar pathFinder;
    private Path path;

    public static void main(String[] args)
    {
        Map obj = new Map();
        tiledMap = obj.buildMap.getTiledMap();
        terrain = obj.buildMap.getTerrain();

        obj.pathFinder = new AStar(obj.buildMap, 4);
        obj.path = obj.pathFinder.findPath(null, 0, 0, 4, 4);

        System.out.println("Path: " + obj.path);
        //System.out.println(obj.path.getLength());
    }
}