package com.mca.astar.Map;

import com.mca.astar.Map.MapBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Lubabalo Nazo
 */
public class MapBuilderTest
{
    private MapBuilder map;

    @Before
    public void setUp() throws Exception
    {
        map = new MapBuilder();
    }

    @Test
    public void testGetTerrain()
    {
        assertEquals(map.getTerrain(0, 0), 1);
    }

    @Test
    public void testIsBlocked()
    {
        assertEquals(map.isBlocked(0, 1), true);
    }

    @Test
    public void testGetTiledMap()
    {
        assertNotNull(map.getTiledMap());
    }
}