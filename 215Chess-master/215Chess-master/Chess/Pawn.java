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
        return null;
    }

    @Override
    public ArrayList<Square> generatePossibleMoves()
    {
        return null;
    }
}
