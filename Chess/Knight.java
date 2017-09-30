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
        return null;
    }

    @Override
    public ArrayList<Square> generatePossibleMoves()
    {
        return null;
    }
}
