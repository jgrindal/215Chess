/*
 * PieceColor.java
 * Development time: 3 minutes
 * version 0.1
 */
package Chess;

import java.awt.Color;

/**
 * Defines white and black
 *
 * @author JGrindal
 */
public enum PieceColor
{

    BLACK(Color.BLACK), WHITE(Color.WHITE);

    private final Color color;

    PieceColor(Color color)
    {
        this.color = color;
    }

    public Color getColor()
    {
        return this.color;
    }
}