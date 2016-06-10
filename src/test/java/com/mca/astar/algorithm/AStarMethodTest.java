package com.mca.astar.algorithm;

import com.mca.astar.map.MapBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Lubabalo Nazo
 */
public class AStarMethodTest
{
    private AStarMethod aStar;
    private MapBuilder map;

    @Before
    public void setUp() throws Exception
    {
        map = new MapBuilder();
        map.getFile("small_map.txt");
        aStar = new AStarMethod(map, 100);
    }

    @Test
    public void testAStarImpl()
    {
        assertNotNull(aStar.findPath(0, 0, 4, 4));
    }
}