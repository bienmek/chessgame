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

public class Knight extends Piece{

    private final static int[] POSSIBLE_MOVES = {-17, -15, -10, -6, 6, 10, 15, 17};

    public Knight(final int piecePosition, final Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public Collection<Move> calcLegalMoves(final Board board) {

        int destCoord;
        List<Move> legalMoves = new ArrayList<>();

        for(final int current: POSSIBLE_MOVES){

            destCoord = this.piecePosition + current;

            if(BoardUtils.isValidTileCoord(destCoord)){

                if(isFirstColumnExclusion(this.piecePosition, current) ||
                        isSecondColumnExclusion(this.piecePosition, current) ||
                        isSeventhColumnExclusion(this.piecePosition, current) ||
                        isEighthColumnExclusion(this.piecePosition, current)) continue;

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
        return BoardUtils.FIRST_COLUMN[currentPos] && (offset == -17 || offset == -10 ||
                offset == 6 || offset == 15);
    }

    private static boolean isSecondColumnExclusion(final int currentPos, final int offset){
        return BoardUtils.SECOND_COLUMN[currentPos] && (offset == -10 || offset == 6);
    }

    private static boolean isSeventhColumnExclusion(final int currentPos, final int offset){
        return BoardUtils.SEVENTH_COLUMN[currentPos] && (offset == -6 || offset == 10);
    }

    private static boolean isEighthColumnExclusion(final int currentPos, final int offset){
        return BoardUtils.EIGHTH_COLUMN[currentPos] && (offset == -15 || offset == -6 ||
                offset == 10 || offset == 17);
    }
    }
