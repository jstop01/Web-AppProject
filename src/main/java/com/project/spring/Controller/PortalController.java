package com.project.spring.Controller;

import com.project.spring.VO.RegisterVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PortalController {

    @GetMapping("/login")
    public String loginMove(Model model) {
        model.addAttribute("test","테스트입니다");
        return "login";
    }

    @GetMapping("/")
    public String indexPage(Model model) {
        return "main";
    }

    @GetMapping("/register")
    public String signUpMove(Model model) {
        model.addAttribute("registerVO", new RegisterVO());
        return "register";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUserInfo(Model model, RequestParam param) {

        return "jsonview";
    }


}
