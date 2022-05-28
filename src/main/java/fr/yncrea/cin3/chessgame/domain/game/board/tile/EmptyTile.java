package fr.yncrea.cin3.chessgame.domain.game.board.tile;

import fr.yncrea.cin3.chessgame.domain.game.piece.Piece;

public final class EmptyTile extends Tile {

    private Piece currentPiece;

    private boolean state;


    public EmptyTile(final int coordinate){
        super(coordinate);
    }

    @Override
    public String toString(){
        return "-";
    }

    @Override
    public boolean isTileOccupied() {
        return this.state;
    }

    @Override
    public Piece getPiece() {
        return this.currentPiece;
    }

    @Override
    public void changeState(Piece piece, boolean state) {
        this.currentPiece = piece;
        this.state = state;
    }

}
