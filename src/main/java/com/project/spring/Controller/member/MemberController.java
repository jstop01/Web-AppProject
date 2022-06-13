package com.project.spring.Controller.member;

import com.project.spring.VO.MemberVO;
import com.project.spring.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MemberController {

    @Autowired
    RegisterService registerService;

    @GetMapping("/login")
    public String loginMove(Model model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute MemberVO memberVO) {
        return "";
    }

    @GetMapping("/register")
    public String signUpMove(Model model) {
        model.addAttribute("memberVO", new MemberVO());
        return "register";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUserInfo(Model model, @Validated @ModelAttribute("memberVO") MemberVO memberVO , BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println(bindingResult.getFieldError());
        System.out.println(bindingResult.hasErrors());
        redirectAttributes.addAttribute("","");
        if (bindingResult.hasErrors()){
            return "redirect:/register";
        }

        Date today = new Date();
        memberVO.setRegDate(sdf.format(today));
        int result = registerService.userRegister(memberVO);
        if(result == 1) {
            return "login";
        } else {
            model.addAttribute("errorCheck","error");
            return "register";
        }
    }




}
