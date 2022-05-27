package fr.yncrea.cin3.chessgame.domain.game.board;

import fr.yncrea.cin3.chessgame.domain.game.Alliance;
import fr.yncrea.cin3.chessgame.domain.game.piece.Piece;

import java.util.Map;

public class Builder {

    Map<Integer, Piece> boardConfig;
    Alliance nextMoveMaker;

    public Builder(){

    }

    public Builder setPiece(final Piece piece){
        this.boardConfig.put(piece.getPiecePosition(), piece);
        return this;
    }

    public Map<Integer, Piece> getBoardConfig(){
        return this.boardConfig;
    }

    public Builder setMoveMaker(final Alliance nextMoveMaker){
        this.nextMoveMaker = nextMoveMaker;
        return this;
    }

    public Board build(){
        return new Board(this);
    }
}

