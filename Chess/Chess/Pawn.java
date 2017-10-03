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
            movePiece();
        }

        //move two squares foward -- first move only
        if (hasMoved() == false) {
            if (neighbor(0, 1).isEmpty() == true
                    && neighbor(0, 2).isEmpty() == true) {
                movePiece();
            }
        }

        //move diagonally forward -- capture opponent's piece
        Piece contestant;
        if (neighbor(1, 1).isEmpty() == false) {
            contestant = neighbor(1, 1).getPiece();
            if (contestant.getPieceColor() != Pawn.getPieceColor()) {
                //remove contestant from game
            }
        }

        //trade -- other side of board, not king
        return null;
    }
}
