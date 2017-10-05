package Chess;

import java.util.ArrayList;

public class Rook extends Piece {

    /**
     * Constructor
     *
     * @param color PieceColor of set color
     */
    public Rook(PieceColor color) {
        super(color, PieceType.ROOK);
    }

    @Override
    public ArrayList<Square> getPossibleMoves() {
        return null;
    }

    @Override
    public ArrayList<Square> generatePossibleMoves() {
        //move forward -- up to 7 squares, no obstructions
        for (int i = 1; i <= 7; i++) {
            if (neighbor(0, i).isEmpty() == true) {
                possibleMoves.add(neighbor(0, i));
            }
        }

        //move backward -- up to 7 squares, no obstructions
        for (int i = -1; i >= -7; i--) {
            if (neighbor(0, i).isEmpty() == true) {
                possibleMoves.add(neighbor(0, i));
            }
        }

        //move left -- up to 7 squares, no obstructions
        for (int i = -1; i >= -7; i--) {
            if (neighbor(i, 0).isEmpty() == true) {
                possibleMoves.add(neighbor(i, 0));
            }
        }

        //move right -- up to 7 squares, no obstructions
        for (int i = 1; i <= 7; i++) {
            if (neighbor(i, 0).isEmpty() == true) {
                possibleMoves.add(neighbor(i, 0));
            }
        }

        return null;
    }
}
