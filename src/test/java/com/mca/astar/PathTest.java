package com.mca.astar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Lubabalo Nazo
 */
public class PathTest
{
    private Path path;

    @Before
    public void setUp() throws Exception
    {
        path = new Path();
    }

    @Test
    public void testGetStep()
    {
        path.addStep(2, 2);
        assertNotNull(path.getStep(0));
    }

    @Test
    public void testContains()
    {
        path.addStep(0, 0);
        assertTrue(path.contains(0, 0));
    }
}