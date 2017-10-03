/*
 * NullSquareException.java
 * Development time: 2 minutes
 * version 0.1
 */

package Chess;

/**
 * Helper exception class when a null square is retreived
 */
public class NullSquareException extends Exception
{
    public NullSquareException(String s)
    {
        super(s);
    }
}
