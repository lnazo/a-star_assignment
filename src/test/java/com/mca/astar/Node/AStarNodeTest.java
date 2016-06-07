package com.mca.astar.Node;

import com.mca.astar.Node.AStarNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author Lubabalo Nazo
 */
public class AStarNodeTest
{
    private AStarNode node;

    @Before
    public void setUp() throws Exception
    {
        node = new AStarNode(1, 1);
    }

    @Test
    public void testDepth()
    {
        node.setDepth(2);
        assertEquals(node.getDepth(), 2);
    }
}