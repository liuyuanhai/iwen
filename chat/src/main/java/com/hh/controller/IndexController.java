package com.hh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/login")
    public  String login(){
        return "login";
    }
    @RequestMapping("/websocket")
    public  String toIndex(String userName, Model model){

        System.out.println("================="+userName);
        model.addAttribute("username",userName);
        return "websocket";
    }

}
