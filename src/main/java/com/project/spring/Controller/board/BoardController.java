package com.project.spring.Controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {



    @GetMapping("/board")
    public String indexPage(Model model) {
        System.out.println("test");
        return "board/imageBoard";
    }



}
