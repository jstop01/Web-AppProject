package com.project.spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PortalController {



    @GetMapping("/portal")
    public String indexPage(Model model) {
        return "main";
    }

    @GetMapping("/")
    public String partalPage(Model model) {
        return "main";
    }


}
