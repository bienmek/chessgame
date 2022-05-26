package fr.yncrea.cin3.chessgame.domain.game.board;

import com.google.common.collect.ImmutableList;
import fr.yncrea.cin3.chessgame.domain.game.board.tile.Tile;

import java.util.Collections;
import java.util.List;

public class Board {

    private final List<Tile> gameBoard;

    public Board(Builder builder){
        this.gameBoard = createGameBoard(builder);
    }

    public Tile getTile(final int tileCoord) {
        return null;
    }

    private static List<Tile> createGameBoard(final Builder builder){
        final Tile[] tiles = new Tile[BoardUtils.NUM_TILES];
        for(int i=0;i<BoardUtils.NUM_TILES;++i){
            tiles[i] = Tile.createTile(i, builder.boardConfig.get(i));
        }
        return ImmutableList.copyOf(tiles);
    }

}
