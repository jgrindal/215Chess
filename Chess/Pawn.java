/*
 * Pawn.java
 * Development time: 20 minutes
 * version 0.2
 */
package Chess;

import java.util.ArrayList;

public class Pawn extends Piece
{
    /**
     * Constructor
     *
     * @param color PieceColor of set color
     */
    public Pawn(PieceColor color)
    {
        super(color, PieceType.PAWN);
    }

    @Override
    public ArrayList<Square> getPossibleMoves()
    {
        return possibleMoves;
    }

    @Override
    public ArrayList<Square> generatePossibleMoves()
    {
        possibleMoves.clear();
        // Directional modifier based on whether piece is black or white.
        int dirModifier;
        if (this.getColor() == PieceColor.BLACK)
            dirModifier = 1;
        else
            dirModifier = -1;

        Piece contestant;

        try
        {
            //move forward one square
            if (square.neighbor(dirModifier * 1, 0).isEmpty())
            {
                possibleMoves.add(square.neighbor(dirModifier * 1, 0));
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
        }

        try
        {
            //move two squares foward -- first move only
            if (!hasMoved())
            {
                if (square.neighbor(dirModifier * 1, 0).isEmpty() && square.neighbor(dirModifier * 2, 0).isEmpty())
                {
                    possibleMoves.add(square.neighbor(dirModifier * 2, 0));
                }
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
        }

        try
        {
            //move diagonally forward -- capture opponent's piece
            if (!square.neighbor(dirModifier * 1, 1).isEmpty())
            {
                contestant = square.neighbor(dirModifier * 1, 1).getPiece();
                if (contestant.getPieceColor() != this.getPieceColor())
                {
                    possibleMoves.add(square.neighbor(dirModifier * 1, 1));
                }
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
        }

        try
        {
            if (!square.neighbor(dirModifier * 1, -1).isEmpty())
            {
                contestant = square.neighbor(dirModifier * 1, -1).getPiece();
                if (contestant.getPieceColor() != this.getPieceColor())
                {
                    possibleMoves.add(square.neighbor(dirModifier * 1, -1));
                }
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
        }
        return possibleMoves;
    }
}
