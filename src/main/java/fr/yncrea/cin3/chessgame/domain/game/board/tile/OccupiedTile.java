package fr.yncrea.cin3.chessgame.domain.game.board.tile;

import fr.yncrea.cin3.chessgame.domain.game.piece.Piece;

public final class OccupiedTile extends Tile {

    private final Piece pieceOnTile;

    OccupiedTile(int tileCoordinate, Piece pieceOnTile){
        super(tileCoordinate);
        this.pieceOnTile = pieceOnTile;
    }

    @Override
    public boolean isTileOccupied() {
        return true;
    }

    @Override
    public Piece getPiece() {
        return null;
    }
}
