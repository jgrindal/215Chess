package Chess;

import java.util.ArrayList;

public class Pawn extends Piece {

    /**
     * Constructor
     *
     * @param color PieceColor of set color
     */
    public Pawn(PieceColor color) {
        super(color, PieceType.PAWN);
    }

    @Override
    public ArrayList<Square> getPossibleMoves() {
        return null;
    }

    @Override
    public ArrayList<Square> generatePossibleMoves() {
        //move forward one square
        if (neighbor(0, 1).isEmpty() == true) {
            possibleMoves.add(neighbor(0, 1));
        }

        //move two squares foward -- first move only
        if (hasMoved() == false) {
            if (neighbor(0, 1).isEmpty() == true
                    && neighbor(0, 2).isEmpty() == true) {
                possibleMoves.add(neighbor(0, 1));
                possibleMoves.add(neighbor(0, 2));
            }
        }

        //move diagonally forward -- capture opponent's piece
        Piece contestant;

        if (neighbor(1, 1).isEmpty() == false) {
            contestant = neighbor(1, 1).getPiece();
            if (contestant.getPieceColor() != Pawn.getPieceColor()) {
                possibleMoves.add(neighbor(1, 1));
            }
        }

        if (neighbor(-1, 1).isEmpty() == false) {
            contestant = neighbor(-1, 1).getPiece();
            if (contestant.getPieceColor() != Pawn.getPieceColor()) {
                possibleMoves.add(neighbor(-1, 1));
            }
        }

        //trade -- other side of board
        for (int i = 0; i < 7; i++) {
            if (neighbor(0, 1) == board.getSquare(i, 7)) {
                possibleMoves.add(neighbor(0, 1));
            }
        }

        return null;
    }
}
