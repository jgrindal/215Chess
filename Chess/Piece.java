/*
 * Piece.java
 * Development time: 2 minutes
 * version 0.1
 */
package Chess;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Piece
{
    private final PieceType pieceType;
    private final PieceColor pieceColor;
    private Square square;
    private boolean moved;  // Begins as false, can only be set to true using setMoved().
    private ArrayList<Square> possibleMoves;

    /**
     * Constructor
     *
     * @param color PieceColor of set color
     * @param type  PieceType of what kind of piece
     */
    public Piece(PieceColor color, PieceType type)
    {
        pieceColor = color;
        pieceType = type;
        moved = false;
    }

    /**
     * Getter for color
     *
     * @return color of Piece
     */
    public PieceColor getPieceColor()
    {
        return pieceColor;
    }

    /**
     * Setter for moved
     */
    public void setMoved()
    {
        this.moved = true;
    }

    /**
     * Returns true if piece has moved, otherwise false
     *
     * @return moved
     */
    public boolean hasMoved()
    {
        return moved;
    }

    /**
     * Returns the type in integer form
     *
     * @return type
     */
    public int getTypeNumber()
    {
        return pieceType.getTypeNumber();
    }

    /**
     * Getter for color
     *
     * @return color
     */
    public PieceColor getColor()
    {
        return pieceColor;
    }

    /**
     * Getter for square piece is occupying
     *
     * @return Square piece is occupying
     */
    public Square getSquare()
    {
        return square;
    }

    /**
     * Setter for square that the piece is occupying
     *
     * @param square New Square the piece is occupying
     */
    public void setSquare(Square square)
    {
        this.square = square;
    }

    /**
     * Gets icon for display on the board
     *
     * @return ImageIcon displaying piece's representation
     */
    public Icon getIcon()
    {
        String path = "/icons/" + this.pieceColor + this.pieceType + ".png";
        //        String path = "/icons/" + "piece.png";
        return new ImageIcon(getClass().getResource(path));
    }

    public void printPossibleMoves()
    {
        generatePossibleMoves();
        for (Square s : possibleMoves)
        {
            if (s.getPiece().getColor() != this.getColor())
                s.setBackground(Color.RED);
            else
                s.setBackground(Color.GREEN);
        }
    }

    public abstract ArrayList<Square> getPossibleMoves();

    public abstract ArrayList<Square> generatePossibleMoves();
}
