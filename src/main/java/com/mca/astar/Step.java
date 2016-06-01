package com.mca.astar;

/**
 * A step in the path
 * @author Lubabalo Nazo
 */
public class Step
{
    // x and y coordinates of given step
    private int x;
    private int y;

    /**
     * Create a new step
     * @param x The new x coordinate
     * @param y The new y coordinate
     */
    public Step(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x coordinate of the step at a given location
     * @return The x coordinate of the step
     */
    public int getX()
    {
        return x;
    }

    /**
     * Get the x coordinate of the step at a given location
     * @return The y coordinate of the step
     */
    public int getY()
    {
        return y;
    }

    /**
     * Returns hash code of an object
     * @return The product coordinate of the coordinates
     */
    @Override
    public int hashCode()
    {
        return x * y;
    }

    /**
     * Returns comparison of two objects
     * @return True if the steps are equal
     */
    @Override
    public boolean equals(Object object)
    {
        if (object instanceof Step)
        {
            Step newObject = (Step) object;

            if (newObject.x == x && newObject.y == y)
                return true;
        }
        return false;
    }
}