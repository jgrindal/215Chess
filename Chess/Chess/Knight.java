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
        //move forward 2 squares --> move perpendicular direction
        //move backward 2 squares --> move perpendicular direction
        //move left 2 squares --> perpendicular
        //move right 2 squares --> perpendicular

        return null;
    }
}
