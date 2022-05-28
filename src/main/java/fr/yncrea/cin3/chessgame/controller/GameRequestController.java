package fr.yncrea.cin3.chessgame.controller;

import fr.yncrea.cin3.chessgame.domain.game.board.Board;
import fr.yncrea.cin3.chessgame.domain.game.board.Builder;
import fr.yncrea.cin3.chessgame.domain.game.board.move.Move;
import fr.yncrea.cin3.chessgame.domain.game.board.tile.Tile;
import fr.yncrea.cin3.chessgame.domain.game.piece.Piece;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rq")
public class GameRequestController {

    private final Builder builder = Board.createStandardBoard();

    private final Board board = builder.build();

    private Piece piece;

    private List<Move> moves;

    private int origin;

    private final List<Integer> destcoord = new ArrayList<>();

    @GetMapping("/init")
    public void init(@RequestParam String piecesCoord){

        String[] single = piecesCoord.split("\\.");
        for(String s: single)
            board.getTile(Integer.parseInt(s)).changeState(board.getTile(Integer.parseInt(s)).getPiece(), true);
    }

    @GetMapping("/plm")
    public String getPieceLM(@RequestParam int origin) {

        this.origin = origin;
        piece = builder.getBoardConfig().get(this.origin);
        System.out.println(board.getTile(this.origin).isTileOccupied());


        piece.calcLegalMoves(board);

        if(moves != null)
            moves.clear();

        destcoord.clear();

        moves = piece.getLegalMoves();

        for(Move m: moves)
            destcoord.add(m.getDestCoord());

        StringBuilder message = new StringBuilder();

        for (Integer integer : destcoord){
            message.append(integer).append(".");
        }

        message.append("/").append(origin);

        return message.toString();
    }

    @GetMapping("/mvt")
    public void setPiecePosition(@RequestParam int dest){
        if(piece != null){
            builder.removePiece(piece);
            piece.setPiecePosition(dest);
            builder.setPiece(piece);
            board.getTile(origin).changeState(null, false);
            board.getTile(dest).changeState(piece, true);
        }
    }
}
