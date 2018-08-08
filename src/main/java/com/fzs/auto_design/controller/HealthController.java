package com.fzs.auto_design.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HealthController {

    @RequestMapping("/")
    public String main() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        return "/front/index";
    }
}
