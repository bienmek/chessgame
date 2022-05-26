package fr.yncrea.cin3.chessgame.domain.game.piece;

import com.google.common.collect.ImmutableList;
import fr.yncrea.cin3.chessgame.domain.game.Alliance;
import fr.yncrea.cin3.chessgame.domain.game.board.Board;
import fr.yncrea.cin3.chessgame.domain.game.board.BoardUtils;
import fr.yncrea.cin3.chessgame.domain.game.board.move.AttackMove;
import fr.yncrea.cin3.chessgame.domain.game.board.move.MajorMove;
import fr.yncrea.cin3.chessgame.domain.game.board.move.Move;
import fr.yncrea.cin3.chessgame.domain.game.board.tile.Tile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class King  extends Piece{

    private final static int[] POSSIBLE_MOVES = {-9, -8, -7, -1, 1, 7, 8, 9};

    public King(int piecePosition, Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public Collection<Move> calcLegalMoves(Board board) {

        final List<Move> legalMoves = new ArrayList<>();

        for(final int current: POSSIBLE_MOVES){
            final int destCoord = this.piecePosition + current;

            if(isFirstColumnExclusion(this.piecePosition, current) || isEighthColumnExclusion(this.piecePosition, current)){
                continue;
            }

            if(BoardUtils.isValidTileCoord(destCoord)){
                final Tile destTile = board.getTile(destCoord);
                if(!destTile.isTileOccupied()){
                    legalMoves.add(new MajorMove(board, this, destCoord));
                } else {
                    final Piece pieceAtDest = destTile.getPiece();
                    final Alliance pieceAlliance = pieceAtDest.getPieceAlliance();

                    if(this.pieceAlliance != pieceAlliance){
                        legalMoves.add(new AttackMove(board, this, destCoord, pieceAtDest));
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }

    private static boolean isFirstColumnExclusion(final int currentPos, final int offset){
        return BoardUtils.FIRST_COLUMN[currentPos] && (offset == -9 || offset == -1 || offset == 7);
    }
    private static boolean isEighthColumnExclusion(final int currentPos, final int offset){
        return BoardUtils.EIGHTH_COLUMN[currentPos] && (offset == -7 || offset == 1 || offset == 9);
    }
}
