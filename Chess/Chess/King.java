package Chess;

import java.util.ArrayList;

public class King extends Piece {

    /**
     * Constructor
     *
     * @param color PieceColor of set color
     */
    public King(PieceColor color) {
        super(color, PieceType.KING);
    }

    @Override
    public ArrayList<Square> getPossibleMoves() {
        return null;
    }

    @Override
    public ArrayList<Square> generatePossibleMoves() {
        //move up -- 1 square, unoccupied by own team piece, no check
        //move down -- 1 square, unoccupied by own team piece, no check
        //move left -- 1 square, unoccupied by own team piece, no check
        //move right -- 1 square, unoccupied by own team piece, no check
        //move diagonally -- 1 square, unoccupied by own team piece, no check

        //"castling": exchange place with rook -- up to 3 squares
        return null;
    }
}
