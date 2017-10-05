package Chess;

import java.util.ArrayList;

public class Knight extends Piece
{
    /**
     * Constructor
     *
     * @param color PieceColor of set color
     */
    public Knight(PieceColor color)
    {
        super(color, PieceType.KNIGHT);
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
        //move forward - right
        try
        {
            if (square.neighbor(1, 2).isEmpty() || square.neighbor(1, 2).getPiece().getColor() != getColor())
            {
                possibleMoves.add(square.neighbor(1, 2));
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
        }

        //move forward - left
        try
        {
            if (square.neighbor(-1, 2).isEmpty() || square.neighbor(-1, 2).getPiece().getColor() != getColor())
            {
                possibleMoves.add(square.neighbor(-1, 2));
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
        }

        //move backward - right
        try
        {
            if (square.neighbor(1, -2).isEmpty() || square.neighbor(1, -2).getPiece().getColor() != getColor())
            {
                possibleMoves.add(square.neighbor(1, -2));
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
        }

        //move backward - left
        try
        {
            if (square.neighbor(-1, -2).isEmpty() || square.neighbor(-1, -2).getPiece().getColor() != getColor())
            {
                possibleMoves.add(square.neighbor(-1, -2));
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
        }

        //move left - up
        try
        {
            if (square.neighbor(-2, 1).isEmpty() || square.neighbor(-2, 1).getPiece().getColor() != getColor())
            {
                possibleMoves.add(square.neighbor(-2, 1));
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
        }

        //move left - down
        try
        {
            if (square.neighbor(-2, -1).isEmpty() || square.neighbor(-2, -1).getPiece().getColor() != getColor())
            {
                possibleMoves.add(square.neighbor(-2, -1));
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
        }

        //move right - up
        try
        {
            if (square.neighbor(2, 1).isEmpty() || square.neighbor(2, 1).getPiece().getColor() != getColor())
            {
                possibleMoves.add(square.neighbor(2, 1));
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
        }

        //move right - down
        try
        {
            if (square.neighbor(2, -1).isEmpty() || square.neighbor(2, -1).getPiece().getColor() != getColor())
            {
                possibleMoves.add(square.neighbor(2, -1));
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
        }
        return possibleMoves;
    }
}
