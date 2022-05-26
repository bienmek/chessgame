package fr.yncrea.cin3.chessgame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @GetMapping("/")
    public String home(@RequestParam(defaultValue = "World") String name, ModelMap modelMap){
        modelMap.put("name", name);
        return "index";
    }
}
