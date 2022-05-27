package fr.yncrea.cin3.chessgame;

import fr.yncrea.cin3.chessgame.domain.game.board.Board;
import fr.yncrea.cin3.chessgame.domain.game.board.Builder;
import fr.yncrea.cin3.chessgame.domain.game.board.move.MajorMove;
import fr.yncrea.cin3.chessgame.domain.game.board.move.Move;
import fr.yncrea.cin3.chessgame.domain.game.piece.Piece;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class ChessgameApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChessgameApplication.class, args);
	}

}
