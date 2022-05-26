package fr.yncrea.cin3.chessgame.domain.game.piece;

import fr.yncrea.cin3.chessgame.domain.game.Alliance;
import fr.yncrea.cin3.chessgame.domain.game.board.Board;
import fr.yncrea.cin3.chessgame.domain.game.board.BoardUtils;
import fr.yncrea.cin3.chessgame.domain.game.board.move.MajorMove;
import fr.yncrea.cin3.chessgame.domain.game.board.move.Move;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pawn extends Piece{

    private final static int[] POSSIBLE_MOVES = {8, 16};


    public Pawn(final int piecePosition, final Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public Collection<Move> calcLegalMoves(final Board board) {

        final List<Move> legalMoves = new ArrayList<>();

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

            }



        }
        return null;
    }
}
