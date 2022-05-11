package com.project.spring.Controller;

import com.project.spring.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test/test")
    List<Map<String, Object>> getBoard () {

        return testService.getBoard();
    }

}
