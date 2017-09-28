/*
 * PieceType.java
 * Development time: 2 minutes
 * version 0.1
 */

/**
 * Defines piece types
 *
 * @author JGrindal
 */
public enum PieceType {
    PAWN(0),
    ROOK(1),
    KNIGHT(2),
    BISHOP(3),
    QUEEN(4),
    KING(5);

    private final int type;

    PieceType(int type) {
        this.type = type;
    }

    public int getTypeNumber() {
        return this.type;
    }
}
