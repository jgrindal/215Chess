package Chess;

import java.util.ArrayList;

public class Bishop extends Piece
{
    /**
     * Constructor
     *
     * @param color PieceColor of set color
     */
    public Bishop(PieceColor color)
    {
        super(color, PieceType.BISHOP);
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
