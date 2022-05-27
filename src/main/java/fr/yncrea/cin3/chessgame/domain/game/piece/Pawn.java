package fr.yncrea.cin3.chessgame.domain.game.piece;

import com.google.common.collect.ImmutableList;
import fr.yncrea.cin3.chessgame.domain.game.Alliance;
import fr.yncrea.cin3.chessgame.domain.game.PieceType;
import fr.yncrea.cin3.chessgame.domain.game.board.Board;
import fr.yncrea.cin3.chessgame.domain.game.board.BoardUtils;
import fr.yncrea.cin3.chessgame.domain.game.board.move.MajorMove;
import fr.yncrea.cin3.chessgame.domain.game.board.move.Move;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Pawn extends Piece{

    private final static int[] POSSIBLE_MOVES = {8, 16, 7, 9};

    private List<Move> legalMoves;


    public Pawn(final Alliance pieceAlliance, final int piecePosition) {
        super(piecePosition, pieceAlliance);
    }

    public List<Move> getLegalMoves(){
        return this.legalMoves;
    }

    @Override
    public Collection<Move> calcLegalMoves(final Board board) {

        legalMoves = new ArrayList<>();

        for(final int current: POSSIBLE_MOVES){

            int destCoord = this.piecePosition + (this.getPieceAlliance().getDirection() * current);

            if(!BoardUtils.isValidTileCoord(destCoord)) continue;

            if(current == 8 && !board.getTile(destCoord).isTileOccupied()){
                legalMoves.add(new MajorMove(board, this, destCoord));
            } else if(current == 16 && this.isFirstMove() &&
                    (BoardUtils.SECOND_ROW[this.piecePosition] && this.getPieceAlliance().isBlack())||
                    (BoardUtils.SEVENTH_ROW[this.piecePosition] && this.getPieceAlliance().isWhite())){
                final int behindDestcoord = this.piecePosition + (this.pieceAlliance.getDirection()*8);
                if(!board.getTile(behindDestcoord).isTileOccupied() &&
                        !board.getTile(destCoord).isTileOccupied()){
                    legalMoves.add(new MajorMove(board, this, destCoord));
                }
            } else if(current == 7 &&
                    !((BoardUtils.EIGHTH_COLUMN[this.piecePosition] && this.pieceAlliance.isWhite()) ||
                    (BoardUtils.FIRST_COLUMN[this.piecePosition] && this.pieceAlliance.isBlack()))){
                if(board.getTile(destCoord).isTileOccupied()){
                    final Piece pieceOn = board.getTile(destCoord).getPiece();
                    if(this.pieceAlliance != pieceOn.getPieceAlliance()){
                        legalMoves.add(new MajorMove(board, this, destCoord));
                    }
                }
            }else if(current == 9 &&
                    !((BoardUtils.FIRST_COLUMN[this.piecePosition] && this.pieceAlliance.isWhite()) ||
                     (BoardUtils.EIGHTH_COLUMN[this.piecePosition] && this.pieceAlliance.isBlack()))){
                if(board.getTile(destCoord).isTileOccupied()){
                    final Piece pieceOn = board.getTile(destCoord).getPiece();
                    if(this.pieceAlliance != pieceOn.getPieceAlliance()){
                        legalMoves.add(new MajorMove(board, this, destCoord));
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }

    @Override
    public String toString(){
        return PieceType.PAWN.toString();
    }
}
