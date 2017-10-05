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
        //move forward -- no obstructions
        for (int i = 1; i <= 7; i++) {
            if (neighbor(0, i).isEmpty() == true) {
                possibleMoves.add(neighbor(0, i));
            }
        }

        //move backward -- no obstructions
        for (int i = -1; i >= -7; i--) {
            if (neighbor(0, i).isEmpty() == true) {
                possibleMoves.add(neighbor(0, i));
            }
        }

        //move left -- no obstructions
        for (int i = -1; i >= -7; i--) {
            if (neighbor(i, 0).isEmpty() == true) {
                possibleMoves.add(neighbor(i, 0));
            }
        }

        //move right -- no obstructions
        for (int i = 1; i <= 7; i++) {
            if (neighbor(i, 0).isEmpty() == true) {
                possibleMoves.add(neighbor(i, 0));
            }
        }

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
