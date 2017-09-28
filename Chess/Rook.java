package Chess;

import java.util.ArrayList;

public class Rook extends Piece
{
    /**
     * Constructor
     *
     * @param color PieceColor of set color
     */
    public Rook(PieceColor color)
    {
        super(color, PieceType.ROOK);
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
