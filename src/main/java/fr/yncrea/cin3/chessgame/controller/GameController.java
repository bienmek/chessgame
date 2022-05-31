package fr.yncrea.cin3.chessgame.controller;

import fr.yncrea.cin3.chessgame.domain.game.board.Board;
import fr.yncrea.cin3.chessgame.domain.game.board.Builder;
import fr.yncrea.cin3.chessgame.domain.game.board.move.Move;
import fr.yncrea.cin3.chessgame.domain.game.piece.Piece;
import fr.yncrea.cin3.chessgame.form.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class GameController {

    @GetMapping("/play")
    public String play(Model model){
        model.addAttribute("form", new UserForm());
        return "play";
    }
}
