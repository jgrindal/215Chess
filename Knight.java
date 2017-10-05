package Chess;

import java.util.ArrayList;

public class Knight extends Piece {

    /**
     * Constructor
     *
     * @param color PieceColor of set color
     */
    public Knight(PieceColor color) {
        super(color, PieceType.KNIGHT);
    }

    @Override
    public ArrayList<Square> getPossibleMoves() {
        return null;
    }

    @Override
    public ArrayList<Square> generatePossibleMoves() {
        //move forward - right
        if (neighbor(1, 2).isEmpty() == true) {
            possibleMoves.add(neighbor(1, 2));
        }

        //move forward - left
        if (neighbor(-1, 2).isEmpty() == true) {
            possibleMoves.add(neighbor(-1, 2));
        }

        //move backward - right
        if (neighbor(1, -2).isEmpty() == true) {
            possibleMoves.add(neighbor(1, -2));
        }

        //move backward - left
        if (neighbor(-1, -2).isEmpty() == true) {
            possibleMoves.add(neighbor(-1, -2));
        }

        //move left - up
        if (neighbor(-2, 1).isEmpty() == true) {
            possibleMoves.add(neighbor(-2, 1));
        }

        //move left - down
        if (neighbor(-2, -1).isEmpty() == true) {
            possibleMoves.add(neighbor(-2, -1));
        }

        //move right - up
        if (neighbor(2, 1).isEmpty() == true) {
            possibleMoves.add(neighbor(2, 1));
        }

        //move right - down
        if (neighbor(2, -1).isEmpty() == true) {
            possibleMoves.add(neighbor(2, -1));
        }

        return null;
    }
}
