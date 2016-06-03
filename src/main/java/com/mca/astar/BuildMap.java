package com.mca.astar;

import com.mca.astar.interfaces.AStarHeuristic;
import com.mca.astar.interfaces.TileBasedMap;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Builds the map based on input
 * @author Lubabalo Nazo
 */
public class BuildMap implements TileBasedMap
{
    // the map to build up
    private String[][] tiledMap;
    private int[][] terrain;
    private boolean[][] visited;

    // terrain costs
    private static final int WATER = 0;
    private static final int FLAT_LANDS = 1;
    private static final int FOREST = 2;
    private static final int MOUNTAIN = 3;

    // the size of the map
    private int countRow = 0;
    private int countCol = 0;

    public BuildMap()
    {
        getFile("small_map.txt");
    }

    /**
     * Fill the map with terrain
     */
    public void fillTerrain()
    {
        for (int i = 0; i < terrain.length; i++)
        {
            for (int j = 0; j < terrain.length; j++)
            {
                if (tiledMap[j][i].equals("~"))
                    terrain[j][i] = WATER;
                else if (tiledMap[j][i].equals(".") || tiledMap[j][i].equals("@") || tiledMap[j][i].equals("X"))
                    terrain[j][i] = FLAT_LANDS;
                if (tiledMap[j][i].equals("*"))
                    terrain[j][i] = FOREST;
                if (tiledMap[j][i].equals("^"))
                    terrain[j][i] = MOUNTAIN;
            }
        }
    }

    /**
     * Clear the map of marked tiles
     */
    public void clearVisitedTiles()
    {
        for (int i = 0; i < getBreadthOfTiles(); i++)
        {
            for (int j = 0; j < getHeightOfTiles(); j++)
            {
                visited[i][j] = false;
            }
        }
    }

    /**
     * Get the position of the visited tile
     * @param x The x coordinate of the visited tile
     * @param x The y coordinate of the visited tile
     * @return The position of the visited tile
     */
    public boolean visited(int x, int y)
    {
        return visited[x][y];
    }

    /**
     * Get the position of the terrain at a tile
     * @param x The x coordinate of the visited tile
     * @param x The y coordinate of the visited tile
     * @return The position of the visited tile
     */
    public int getTerrain(int x, int y)
    {
        System.out.println("x = " + x + " - y = " + y);
        return terrain[x][y];
    }

    // check if the considered tile is blocked
    public boolean blocked(String object, int x, int y)
    {
        //return getTerrain(x, y) != WATER;
        if (getTerrain(x, y) != 0)
            return false;

        return true;
    }

    // get the cost of moving to a given tile
    public float getCost(String object, int startX, int startY, int goalX, int goalY)
    {
        return 1.0f;
    }

    // get the breadth of the map
    public int getBreadthOfTiles()
    {
        return countRow;
    }

    // get the height of the map
    public int getHeightOfTiles()
    {
        return countRow;
    }

    // notify the PathFinder that a tile has been checked
    public void pathFinderVisited(int x, int y)
    {
        visited[x][y] = true;
    }

    /**
     * Get the text file with the map
     * @return The filled map
     */
    public String[][] getTiledMap()
    {
        return tiledMap;
    }

    /**
     * Get the text file with the map
     * @return The filled map
     */
    public int[][] getTerrain()
    {
        return terrain;
    }

    /**
     * Get the text file with the map
     * @param fileName The name of the file
     * @return The map
     */
    public void getFile(String fileName)
    {
        String result = "";

        // get the location of the file
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try
        {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                result += line + "\n";
            }
            scanner.close();
            String[] newString = result.split("\n");

            // set the size of the map
            for (int row = 0; row < newString.length; row++)
            {
                for (int col = 0; col < newString.length; col++)
                {
                    countCol++;
                }
                countRow++;
            }

            tiledMap = new String[countRow][countCol];
            terrain = new int[countRow][countCol];
            visited = new boolean[countRow][countCol];

            // fill the map
            for (int row = 0; row < newString.length; row++)
            {
                for (int col = 0; col < newString.length; col++)
                {
                    tiledMap[col][row] = String.valueOf(newString[row].charAt(col));
                }
            }

            fillTerrain();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
