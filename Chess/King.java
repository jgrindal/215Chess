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
        return null;
    }

    @Override
    public ArrayList<Square> generatePossibleMoves()
    {
        return null;
    }
}
