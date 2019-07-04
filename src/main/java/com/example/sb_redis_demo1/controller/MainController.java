package com.example.sb_redis_demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @RequestMapping("/index")
    public String index(ModelMap mp){
        mp.addAttribute("name","keane");
        return "index";
    }
}
