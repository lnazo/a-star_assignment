package com.mca.astar.heuristic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Lubabalo Nazo
 */
public class ManhattanHTest
{
    private ManhattanH heuristic;
    private float cost;

    @Before
    public void setUp() throws Exception
    {
        heuristic = new ManhattanH();
    }

    @Test
    public void testCost()
    {
        cost = heuristic.getCost(0, 0, 4, 4);
        assertNotNull((double) cost);
    }
}