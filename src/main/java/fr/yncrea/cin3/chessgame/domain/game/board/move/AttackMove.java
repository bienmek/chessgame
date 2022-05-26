package fr.yncrea.cin3.chessgame.domain.game.board.move;

import fr.yncrea.cin3.chessgame.domain.game.board.Board;
import fr.yncrea.cin3.chessgame.domain.game.piece.Piece;

public final class AttackMove extends Move{

    final Piece attackedPiece;

    public AttackMove(final Board board, final Piece movedPiece, final int destCoord, final Piece attackedPiece) {
        super(board, movedPiece, destCoord);
        this.attackedPiece = attackedPiece;
    }
}
