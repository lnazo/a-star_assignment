package com.mca.astar.AStar;

import com.mca.astar.AStar.AStarMethod;
import com.mca.astar.Map.MapBuilder;
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
        aStar = new AStarMethod(map, 100);
    }

    @Test
    public void testAStarImpl()
    {
        assertNotNull(aStar.findPath(0, 0, 4, 4));
    }
}