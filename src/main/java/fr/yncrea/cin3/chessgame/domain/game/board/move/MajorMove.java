package fr.yncrea.cin3.chessgame.domain.game.board.move;

import fr.yncrea.cin3.chessgame.domain.game.board.Board;
import fr.yncrea.cin3.chessgame.domain.game.piece.Piece;

public final class MajorMove extends Move{
    public MajorMove(Board board, Piece movedPiece, int destCoord) {
        super(board, movedPiece, destCoord);
    }
}
