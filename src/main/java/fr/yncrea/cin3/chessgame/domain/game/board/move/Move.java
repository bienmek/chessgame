package fr.yncrea.cin3.chessgame.domain.game.board.move;

import fr.yncrea.cin3.chessgame.domain.game.board.Board;
import fr.yncrea.cin3.chessgame.domain.game.piece.Piece;

public abstract class Move {


    private final Board board;
    private final Piece movedPiece;
    private final int destCoord;

    public Move(Board board, Piece movedPiece, int destCoord) {
        this.board = board;
        this.movedPiece = movedPiece;
        this.destCoord = destCoord;
    }

    public int getDestCoord(){
        return this.destCoord;
    }


}
