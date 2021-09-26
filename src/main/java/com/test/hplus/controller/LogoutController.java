package com.test.hplus.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {


    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        System.out.println(session.getAttribute("login"));
        System.out.println("Ending session");
        session.invalidate();
        return "login";
    }
}
