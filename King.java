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
        //move forward -- 1 square, unoccupied by own team piece, no check
        if (neighbor(0, 1).isEmpty() == true) {
            possibleMoves.add(neighbor(0, 1));
        }

        //move backward -- 1 square, unoccupied by own team piece, no check
        if (neighbor(0, -1).isEmpty() == true) {
            possibleMoves.add(neighbor(0, -1));
        }

        //move left -- 1 square, unoccupied by own team piece, no check
        if (neighbor(-1, 0).isEmpty() == true) {
            possibleMoves.add(neighbor(-1, 0));
        }

        //move right -- 1 square, unoccupied by own team piece, no check
        if (neighbor(1, 0).isEmpty() == true) {
            possibleMoves.add(neighbor(1, 0));
        }

        //move diagonally -- 1 square, unoccupied by own team piece, no check
        //forward
        if (neighbor(1, 1).isEmpty() == true) {
            possibleMoves.add(neighbor(1, 1));
        }
        if (neighbor(-1, 1).isEmpty() == true) {
            possibleMoves.add(neighbor(1, 1));
        }
        //backward
        if (neighbor(1, -1).isEmpty() == true) {
            possibleMoves.add(neighbor(-1, -1));
        }
        if (neighbor(-1, -1).isEmpty() == true) {
            possibleMoves.add(neighbor(-1, -1));
        }
        //"castling": exchange place with rook -- up to 3 squares
        return null;
    }
}
