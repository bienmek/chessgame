package fr.yncrea.cin3.chessgame.domain.game.piece;

import fr.yncrea.cin3.chessgame.domain.game.Alliance;
import fr.yncrea.cin3.chessgame.domain.game.board.Board;
import fr.yncrea.cin3.chessgame.domain.game.board.move.Move;

import java.util.Collection;
import java.util.List;

public abstract class Piece {

    protected int piecePosition;
    protected final Alliance pieceAlliance;
    protected final boolean isFirstMove;

    public Piece(final int piecePosition, final Alliance pieceAlliance) {
        this.piecePosition = piecePosition;
        this.pieceAlliance = pieceAlliance;
        this.isFirstMove = false;
    }

    public int getPiecePosition(){
        return this.piecePosition;
    }

    public void setPiecePosition(int piecePosition){
        this.piecePosition = piecePosition;
    }

    public Alliance getPieceAlliance(){
        return this.pieceAlliance;
    }
    public abstract Collection<Move> calcLegalMoves(final Board board);

    public abstract List<Move> getLegalMoves();

    protected boolean isFirstMove() {
        return this.isFirstMove;
    }

}
