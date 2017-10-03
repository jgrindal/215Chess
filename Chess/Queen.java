package Chess;

import java.util.ArrayList;

public class Queen extends Piece
{
    /**
     * Constructor
     *
     * @param color PieceColor of set color
     */
    public Queen(PieceColor color)
    {
        super(color, PieceType.QUEEN);
    }

    @Override
    public ArrayList<Square> getPossibleMoves()
    {
        return null;
    }

    @Override
    public ArrayList<Square> generatePossibleMoves()
    {
        for (int i = 1; i < 8; i++)
        {
            try
            {
                Square candidate = square.neighbor(1 * i, 1 * i);
                if (candidate.isEmpty())
                {
                    possibleMoves.add(candidate);
                } else if (candidate.getPiece().getColor() != getColor())
                {
                    possibleMoves.add(candidate);
                    break;
                } else
                {
                    break;
                }
            } catch (NullSquareException e)
            {
                System.out.println(e);
                break;
            }
        }

        for (int i = 1; i < 8; i++)
        {
            try
            {
                Square candidate = square.neighbor(1 * i, -1 * i);
                if (candidate.isEmpty())
                {
                    possibleMoves.add(candidate);
                } else if (candidate.getPiece().getColor() != getColor())
                {
                    possibleMoves.add(candidate);
                    break;
                } else
                {
                    break;
                }
            } catch (NullSquareException e)
            {
                System.out.println(e);
                break;
            }
        }

        for (int i = 1; i < 8; i++)
        {
            try
            {
                Square candidate = square.neighbor(-1 * i, 1 * i);
                if (candidate.isEmpty())
                {
                    possibleMoves.add(candidate);
                } else if (candidate.getPiece().getColor() != getColor())
                {
                    possibleMoves.add(candidate);
                    break;
                } else
                {
                    break;
                }
            } catch (NullSquareException e)
            {
                System.out.println(e);
                break;
            }
        }

        for (int i = 1; i < 8; i++)
        {
            try
            {
                Square candidate = square.neighbor(-1 * i, -1 * i);
                if (candidate.isEmpty())
                {
                    possibleMoves.add(candidate);
                } else if (candidate.getPiece().getColor() != getColor())
                {
                    possibleMoves.add(candidate);
                    break;
                } else
                {
                    break;
                }
            } catch (NullSquareException e)
            {
                System.out.println(e);
                break;
            }
        }

        for (int i = 1; i < 8; i++)
        {
            try
            {
                Square candidate = square.neighbor(1 * i, 0);
                if (candidate.isEmpty())
                {
                    possibleMoves.add(candidate);
                } else if (candidate.getPiece().getColor() != getColor())
                {
                    possibleMoves.add(candidate);
                    break;
                } else
                {
                    break;
                }
            } catch (NullSquareException e)
            {
                System.out.println(e);
                break;
            }
        }

        for (int i = 1; i < 8; i++)
        {
            try
            {
                Square candidate = square.neighbor(-1 * i, 0);
                if (candidate.isEmpty())
                {
                    possibleMoves.add(candidate);
                } else if (candidate.getPiece().getColor() != getColor())
                {
                    possibleMoves.add(candidate);
                    break;
                } else
                {
                    break;
                }
            } catch (NullSquareException e)
            {
                System.out.println(e);
                break;
            }
        }

        for (int i = 1; i < 8; i++)
        {
            try
            {
                Square candidate = square.neighbor(0, 1 * i);
                if (candidate.isEmpty())
                {
                    possibleMoves.add(candidate);
                } else if (candidate.getPiece().getColor() != getColor())
                {
                    possibleMoves.add(candidate);
                    break;
                } else
                {
                    break;
                }
            } catch (NullSquareException e)
            {
                System.out.println(e);
                break;
            }
        }

        for (int i = 1; i < 8; i++)
        {
            try
            {
                Square candidate = square.neighbor(0, -1 * i);
                if (candidate.isEmpty())
                {
                    possibleMoves.add(candidate);
                } else if (candidate.getPiece().getColor() != getColor())
                {
                    possibleMoves.add(candidate);
                    break;
                } else
                {
                    break;
                }
            } catch (NullSquareException e)
            {
                System.out.println(e);
                break;
            }
        }
        return possibleMoves;
    }
}
