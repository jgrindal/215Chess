package Chess;

import java.util.ArrayList;

public class Bishop extends Piece {

    /**
     * Constructor
     *
     * @param color PieceColor of set color
     */
    public Bishop(PieceColor color) {
        super(color, PieceType.BISHOP);
    }

    @Override
    public ArrayList<Square> getPossibleMoves() {
        return null;
    }

    @Override
    public ArrayList<Square> generatePossibleMoves() {
        //move diagonally -- no obstructions
        for (int i = 0; i < 7; i++) {
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

        }

        return null;
    }
}
