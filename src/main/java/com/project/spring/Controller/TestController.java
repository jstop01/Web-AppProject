package com.project.spring.Controller;

import com.project.spring.VO.TestVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    @GetMapping("/dataSendPage")
    public String dataSendPage(HttpServletRequest param, Model model) {
        model.addAttribute("form", new TestVO());


        return "dataSendTest";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String dataSendTest(Model model, @ModelAttribute("form") TestVO testVO) {
        System.out.println(testVO.getName());

        return "dataSendTest";
    }
}
