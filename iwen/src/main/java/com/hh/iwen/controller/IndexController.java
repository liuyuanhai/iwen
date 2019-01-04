package com.hh.iwen.controller;

import com.hh.iwen.bean.BaseUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("toRegister")
    public String toRegister(){
        System.out.println("=============================");
        String a="aaa";
        String s=a;
        return "/register" ;
    }



}
