package com.test.hplus.controller;


import com.test.hplus.bean.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class UserProfileController {

    @PostMapping("/userprofile")
    public String getUserprofile(@SessionAttribute("login")Login login, Model model)
    {
        System.out.println("in userprofile controller");
        System.out.println("username in sesseion: " + login.getUsername());
        model.addAttribute("username",login.getUsername());
        return "profile";
    }
}
