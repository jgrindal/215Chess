/*
 * Piece.java
 * Development time: 2 minutes
 * version 0.1
 */

import java.util.ArrayList;
import java.util.Collection;

public abstract class Piece
{
    private final PieceType pieceType;
    private final PieceColor pieceColor;
    private Square square;
    private boolean moved;  // Begins as false, can only be set to true using setMoved().

    /**
     * Constructor
     *
     * @param color PieceColor of set color
     * @param type PieceType of what kind of piece
     */
    public Piece(PieceColor color, PieceType type) {
        pieceColor = color;
        pieceType = type;
        moved = false;
    }

    /**
     * Getter for color
     * @return color of Piece
     */
    public PieceColor getPieceColor() {
        return pieceColor;
    }

    /**
     * Setter for moved
     */
    public void setMoved() {
        this.moved = true;
    }

    /**
     * Returns true if piece has moved, otherwise false
     * @return moved
     */
    public boolean hasMoved() {
        return moved;
    }

    /**
     * Returns the type in integer form
     * @return type
     */
    public int getTypeNumber()
    {
        return pieceType.getTypeNumber();
    }

    /**
     * Getter for color
     * @return color
     */
    public java.awt.Color getColor() {
        return pieceColor.getColor();
    }

    /**
     * Getter for square piece is occupying
     * @return Square piece is occupying
     */
    public Square getSquare() {
        return square;
    }

    public abstract ArrayList<Square> getPossibleMoves();

    public abstract ArrayList<Square> generatePossibleMoves();
}
