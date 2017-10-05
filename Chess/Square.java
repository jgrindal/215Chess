/*
 * Piece.java
 * Development time: 47 minutes
 * version 0.1
 */
package Chess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Square class acts as a container for a Piece and makes up a Board
 */
public class Square extends JButton
{
    public final int ROW;
    public final int COL;
    private Piece piece;
    private final Board board;
    private boolean selected;

    /**
     * Constructor
     *
     * @param row   Row of the Square
     * @param col   Column of the Square
     * @param board Board to which the Square belongs
     */
    public Square(int row, int col, Board board)
    {
        this.board = board;
        ROW = row;
        COL = col;
        selected = false;
        setFocusPainted(false);
        setBackground(getColor());
        setPreferredSize(new Dimension(80, 80));
        // Describe action about clicking here
        addActionListener((ActionEvent e) ->
        {
            Square curr = board.getSelected();
            if (curr != null && curr != this && !curr.isEmpty() && curr.getPiece().getPossibleMoves().contains(this))
                movePiece(curr.getPiece());
            if (this.selected)
                this.deselect();
            else
                this.select();
        });
    }

    /**
     * Getter for the default color of a Square
     *
     * @return Color of the Square
     */
    public Color getColor()
    {
        if ((ROW + COL) % 2 == 0)
            return Color.DARK_GRAY;
        else
            return Color.LIGHT_GRAY;
    }

    /**
     * Select a Square
     */
    private void select()
    {
        if (piece != null)
        {
            if ((piece.getColor() == PieceColor.WHITE && !board.getTurn()) || (piece.getColor() == PieceColor.BLACK && board.getTurn()))
            {
                board.deselect();
                board.setSelected(this);
                this.selected = true;
                setBackground(Color.GREEN);
                piece.printPossibleMoves();
            }
        }

        // TODO: Incomplete
    }

    /**
     * Deselect the Square
     */
    public void deselect()
    {
        setBackground(getColor());
        if (!this.isEmpty())
        {
            for (Square s : this.getPiece().getPossibleMoves())
            {
                s.setBackground(s.getColor());
            }
        }
        selected = false;
    }

    /**
     * Returns a Square an offset from this Square
     *
     * @param row how many rows (to the right) offset
     * @param col how many columns (to the left) offset
     * @return
     */
    public Square neighbor(int row, int col) throws NullSquareException
    {
        Square toRet = board.getSquare(ROW + row, COL + col);
        if (toRet == null)
            throw new NullSquareException(String.valueOf(ROW + row) + ", " + String.valueOf(COL + col));
        return board.getSquare(ROW + row, COL + col);
    }

    /**
     * Sets a piece to occupy the Square
     *
     * @param piece Piece to occupy the Square
     */
    public void setPiece(Piece piece)
    {
        this.piece = piece;
        piece.setSquare(this);
        setIcon(this.piece.getIcon());
    }

    /**
     * Moves the Piece onto this Square
     *
     * @param piece Piece to move onto this Square
     */
    public void movePiece(Piece piece)
    {
        Square curr = board.getSelected();
        curr.deselect();
        if (!isEmpty())
        {
            removePiece();
        }
        setPiece(piece);
        curr.removePiece();
        board.swapTurn();
        piece.setMoved();
        board.isCheck();
    }

    /**
     * Removes the piece from the Square (note: does not remove it from the GAME)
     */
    public void removePiece()
    {
        // TODO: Interact with board to remove piece from ArrayLists
        piece = null;
        setIcon(null);
    }

    /**
     * Getter for Piece on the square
     *
     * @return Piece on this Square
     */
    public Piece getPiece()
    {
        return piece;
    }

    /**
     * Returns true if Square is empty, false if there is a Piece occupying it
     *
     * @return if the Square is empty
     */
    public boolean isEmpty()
    {
        return piece == null;
    }

    @Override
    public boolean isSelected()
    {
        return selected;
    }
}
