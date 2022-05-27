package fr.yncrea.cin3.chessgame.domain.game.board;

import fr.yncrea.cin3.chessgame.domain.game.Alliance;
import fr.yncrea.cin3.chessgame.domain.game.piece.Piece;

import java.util.HashMap;
import java.util.Map;

public class Builder {

    Map<Integer, Piece> boardConfig;
    Alliance nextMoveMaker;

    public Builder(){
        this.boardConfig = new HashMap<>();
    }

    public Builder setPiece(final Piece piece){
        this.boardConfig.put(piece.getPiecePosition(), piece);
        return this;
    }

    public Map<Integer, Piece> getBoardConfig(){
        return this.boardConfig;
    }

    public void setMoveMaker(final Alliance nextMoveMaker){
        this.nextMoveMaker = nextMoveMaker;
    }

    public Board build(){
        return new Board(this);
    }
}

