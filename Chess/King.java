package Chess;

import java.util.ArrayList;

public class King extends Piece
{
    /**
     * Constructor
     *
     * @param color PieceColor of set color
     */
    public King(PieceColor color)
    {
        super(color, PieceType.KING);
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
        //move forward -- 1 square, unoccupied by own team piece, no check
        try
        {
            if (square.neighbor(0, 1).isEmpty())
            {
                possibleMoves.add(square.neighbor(0, 1));
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
            ;
        }

        //move backward -- 1 square, unoccupied by own team piece, no check
        try
        {
            if (square.neighbor(0, -1).isEmpty())
            {
                possibleMoves.add(square.neighbor(0, -1));
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
            ;
        }

        //move left -- 1 square, unoccupied by own team piece, no check
        try
        {
            if (square.neighbor(-1, 0).isEmpty())
            {
                possibleMoves.add(square.neighbor(-1, 0));
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
            ;
        }

        //move right -- 1 square, unoccupied by own team piece, no check
        try
        {
            if (square.neighbor(1, 0).isEmpty())
            {
                possibleMoves.add(square.neighbor(1, 0));
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
            ;
        }

        //move diagonally -- 1 square, unoccupied by own team piece, no check
        //forward
        try
        {
            if (square.neighbor(1, 1).isEmpty())
            {
                possibleMoves.add(square.neighbor(1, 1));
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
            ;
        }
        try
        {
            if (square.neighbor(-1, 1).isEmpty())
            {
                possibleMoves.add(square.neighbor(1, 1));
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
            ;
        }
        //backward
        try
        {
            if (square.neighbor(1, -1).isEmpty())
            {
                possibleMoves.add(square.neighbor(-1, -1));
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
            ;
        }
        try
        {
            if (square.neighbor(-1, -1).isEmpty())
            {
                possibleMoves.add(square.neighbor(-1, -1));
            }
        } catch (NullSquareException e)
        {
            System.out.println(e);
            ;
        }
        //"castling": exchange place with rook -- up to 3 squares
        return null;
    }
}
