package fr.yncrea.cin3.chessgame.controller;

import fr.yncrea.cin3.chessgame.domain.game.board.Board;
import fr.yncrea.cin3.chessgame.domain.game.board.Builder;
import fr.yncrea.cin3.chessgame.domain.game.board.move.Move;
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

    @GetMapping("/game")
    public String PieceSelection(@RequestParam int origin) {

        Builder builder = Board.createStandardBoard();

        Piece piece = builder.getBoardConfig().get(origin);
        piece.calcLegalMoves(builder.build());

        List<Move> moves= piece.getLegalMoves();
        List<Integer> destcoord = new ArrayList<>();

        for(Move m: moves)
            destcoord.add(m.getDestCoord());

        StringBuilder message = new StringBuilder();

        for (Integer integer : destcoord) {
            message.append(integer).append(".");
        }

        message.append("/").append(origin);
        return message.toString();
    }
}
