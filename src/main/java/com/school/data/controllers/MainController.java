package com.school.data.controllers;

import org.springframework.ui.Model;

//@Controller
//@RequestMapping("/")
public class MainController {

//    @RequestMapping(method = RequestMethod.GET)
    public String start(Model model){
        return "index";
    }
}
