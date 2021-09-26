package com.test.hplus.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectionController {

    @GetMapping("/redirectTolinkedin")
    public String redirectOut()
    {
        System.out.println("in redirect controller");
        return "redirect:https://www.linkedin.com";
    }
}
