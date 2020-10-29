package com.romedawg.rome.controller;

import com.romedawg.rome.Domain.Metra.Stop;
import com.romedawg.rome.Repositories.Metra.StopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;


//@Component - this goes one down and is part of the the postConstruct
@Controller
public class MetraController {
    @Value("${METRA_URL_USERNAME}")
    private String metraUrlUsername;
    @Value("${METRAL_URL_PASSWORD}")
    private String metraUrlPassword;

    @Autowired
    StopRepository stopRepository;

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @RequestMapping("/metra")
    public String metra(Model model) {

        model.addAttribute("data", stopRepository.findHinsdaleStops());
//        model.addAttribute("data", stopRepository.findAll());


        return "metra/metra";
    }
}
