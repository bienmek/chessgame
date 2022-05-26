package fr.yncrea.cin3.chessgame.domain.game.board.tile;

import fr.yncrea.cin3.chessgame.domain.game.piece.Piece;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

    protected final int tileCoord;
    private static final Map<Integer, EmptyTile> EMPTY_TILES = createEmptyTile();

    public static Tile createTile(final int tileCoord, final Piece piece){
        return piece !=null ? new OccupiedTile(tileCoord, piece): EMPTY_TILES.get(tileCoord);
    }
    Tile(int tileCoord) {
        this.tileCoord = tileCoord;
    }
    private static Map<Integer, EmptyTile> createEmptyTile() {
        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

        for(int i=0;i<64;++i){
            emptyTileMap.put(i, new EmptyTile(i));
        }
        return Collections.unmodifiableMap(emptyTileMap);
    }
    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

}
