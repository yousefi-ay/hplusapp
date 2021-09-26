package com.test.hplus.controller;


import com.test.hplus.bean.Login;
import com.test.hplus.bean.User;
import com.test.hplus.exeptions.ApplicationExeptions;
import com.test.hplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("login")
public class LoginController {


    @Autowired
    UserRepository userRepository;
    @PostMapping("/login")
    public String login(@ModelAttribute("login")Login login)
    {
        User user = userRepository.serachByName(login.getUsername());

        if (user==null)
        {
            throw new ApplicationExeptions("user not find");
        }
        return "forward:/userprofile";
    }



    /*@ExceptionHandler(ApplicationExeptions.class)
    public String handleExeption()
    {
        System.out.println("in exeption handler of Login");
        return "error";
    }

     */
}
