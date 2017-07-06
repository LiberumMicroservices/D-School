package com.school.data.controllers;

import org.springframework.ui.Model;

//@Controller
//@RequestMapping("/login")
public class LoginController {

//    @RequestMapping(method = RequestMethod.GET)
    public String loginPage(Model model){
        return "login";
    }
}
