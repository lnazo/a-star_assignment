package com.mca.astar;

/**
 * Driver class that contains the map
 * @author Lubabalo Nazo
 */
public class Map
{
    private BuildMap buildMap = new BuildMap();
    private static String[][] tiledMap;
    private static int breadth;
    private static int height;

    public static void main(String[] args)
    {
        Map obj = new Map();
        obj.buildMap.getFile("small_map.txt");
        tiledMap = obj.buildMap.getTiledMap();

        //System.out.println(tiledMap[1][0]);
    }
}
