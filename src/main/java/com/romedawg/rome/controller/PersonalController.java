package com.romedawg.rome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Page for Todo, shedule, shopping list, etc..

@Controller
public class PersonalController {

    @RequestMapping("/todo")
    public String todo(){return "todo/todo";}

}
