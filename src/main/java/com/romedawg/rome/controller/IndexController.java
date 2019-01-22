package com.romedawg.rome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URL;

@Controller
public class IndexController {

    @RequestMapping("/t")
    public String home(Model model){

        String test_Data = "THIS IS AN EXAMPLE";
        model.addAttribute("test", test_Data );
        return "home";
    }
}
