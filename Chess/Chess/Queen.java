package Chess;

import java.util.ArrayList;

public class Queen extends Piece {

    /**
     * Constructor
     *
     * @param color PieceColor of set color
     */
    public Queen(PieceColor color) {
        super(color, PieceType.QUEEN);
    }

    @Override
    public ArrayList<Square> getPossibleMoves() {
        return null;
    }

    @Override
    public ArrayList<Square> generatePossibleMoves() {
        //move up -- no obstructions
        //move down -- no obstructions
        //move left -- no obstructions
        //move right -- no obstructions
        //move diagonally -- no obstructions
        //capture opponent piece
        return null;
    }
}
