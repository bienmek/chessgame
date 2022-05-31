package fr.yncrea.cin3.chessgame.controller;

import fr.yncrea.cin3.chessgame.domain.user.User;
import fr.yncrea.cin3.chessgame.form.UserForm;
import fr.yncrea.cin3.chessgame.repositories.UserRepository;
import fr.yncrea.cin3.chessgame.service.DbUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private DbUserDetailsService userService;

    @GetMapping("/login")
    public String register(Model model) {
        model.addAttribute("user", userService.createForm(null));
        return "login";
    }

    @PostMapping("/add/login")
    public String addUser(@Valid @ModelAttribute("user") UserForm form, BindingResult result, Model model) {
        System.out.println("salut 3");
        if (result.hasErrors()) {
            System.out.println("salut 4");
            model.addAttribute("user", form);
            return "login";
        }
        System.out.println("salut 5");
        userService.save(form);

        return "redirect:/play";
    }
}
