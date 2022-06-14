package com.project.spring.Controller.member;

import com.project.spring.VO.MemberVO;
import com.project.spring.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MemberController {

    @Autowired
    RegisterService registerService;

    private static Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

    @GetMapping("/login")
    public String loginMove(Model model) {
        return "login";
    }

    @PostMapping(value = "/loginAction")
    public String login(@ModelAttribute MemberVO memberVO) {
        //로그인 로직 구현
        return "";
    }

    @GetMapping("/register")
    public String signUpMove(Model model) {
        model.addAttribute("memberVO", new MemberVO());
        return "register";
    }

    @PostMapping(value = "/saveUser")
    public String saveUserInfo(@Validated @ModelAttribute MemberVO memberVO , BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        addUserValidation(memberVO, bindingResult);
        if (bindingResult.hasErrors()){
            LOGGER.info("errors={}", bindingResult);
            return "register";
        }

        Date today = new Date();
        memberVO.setRegDate(sdf.format(today));
        registerService.userRegister(memberVO);
        return "login";

    }


    public void addUserValidation(MemberVO memberVO, BindingResult bindingResult) {
        //사용자 이름 검증
        if(!StringUtils.hasText(memberVO.getUserName())) {
            /*bindingResult.addError(new FieldError("memberVO","userName",memberVO.getUserName(),false,new String[]{"required.memberVO.userName"},null,null));*/
            bindingResult.rejectValue("userName","required");
        }
        //사용자 아이디 검증
        if(!StringUtils.hasText(memberVO.getUserId())) {
            /*bindingResult.addError(new FieldError("memberVO","userId",memberVO.getUserId(),false,new String[]{"required.memberVO.userId"},null,null));*/
            bindingResult.rejectValue("userId","required");
        }
        int idCount = registerService.idOverlapCheck(memberVO);
        if(idCount>0) {
            bindingResult.addError(new FieldError("memberVO","userId","아이디 중복입니다."));
        }
        //사용자 비밀번호 검증
        if(!StringUtils.hasText(memberVO.getUserPw())) {
            /*bindingResult.addError(new FieldError("memberVO","userPw",memberVO.getUserPw(),false,new String[]{"required.memberVO.userPw"},null,null));*/
            bindingResult.rejectValue("userPw","required");
        }
        //사용자 이름 검증
        if(!StringUtils.hasText(memberVO.getUserPwConf())) {
            /*bindingResult.addError(new FieldError("memberVO","userPwConf",memberVO.getRegPwConf(),false,new String[]{"required.memberVO.regPwConf"},null,null));*/
            bindingResult.rejectValue("userPwConf","required");
        }
        if(!StringUtils.hasText(memberVO.getUserPw())) {
            /*bindingResult.addError(new FieldError("memberVO","userEmail",memberVO.getUserEmail(),false,new String[]{"required.memberVO.userEmail"},null,null));*/
            bindingResult.rejectValue("userEmail","required");
        }
    }




}
