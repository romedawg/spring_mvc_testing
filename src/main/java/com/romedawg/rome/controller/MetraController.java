package com.romedawg.rome.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.romedawg.rome.Domain.Metra.*;
import com.romedawg.rome.Repositories.Metra.RoutesRepository;
import com.romedawg.rome.Repositories.Metra.StopRepository;
import com.romedawg.rome.Repositories.TripRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.id.UUIDGenerator;
import org.hibernate.type.UUIDCharType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Controller
@Component
public class MetraController {
    @Value("${METRA_URL_USERNAME}")
    private String metraUrlUsername;
    @Value("${METRAL_URL_PASSWORD}")
    private String metraUrlPassword;

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @RequestMapping("/metra")
    public String metra(Model model) throws IOException {

        model.addAttribute("divy_data", "data.toString()");
        return "metra/metra";
    }
}
