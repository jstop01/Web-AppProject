package com.project.spring.Controller;

import com.project.spring.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @GetMapping("/login")
    public String testPage(Model model) {
        model.addAttribute("test","테스트입니다");
        return "login";
    }

}
