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

public class Bishop extends Piece{

    private final static int[] POSSIBLE_MOVES_VECTOR = {-9, -7, 7, 9};

    public Bishop(Alliance pieceAlliance, int piecePosition) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public Collection<Move> calcLegalMoves(final Board board) {

        final List<Move> legalMoves = new ArrayList<>();

        for(final int current: POSSIBLE_MOVES_VECTOR){
            int destCoord = this.piecePosition;

            while(BoardUtils.isValidTileCoord(destCoord)){

                if(isFirstColumnExclusion(destCoord, current) ||
                isEighthColumnExclusion(destCoord, current)) break;

                destCoord+=current;

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
                        break;
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }

    private static boolean isFirstColumnExclusion(final int currentPos, final int offset){
        return BoardUtils.FIRST_COLUMN[currentPos] && (offset == -9 || offset == 7);
    }

    private static boolean isEighthColumnExclusion(final int currentPos, final int offset){
        return BoardUtils.EIGHTH_COLUMN[currentPos] && (offset == 7 || offset == 9);
    }
}
