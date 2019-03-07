package com.romedawg.rome.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class AlbumController {

    @RequestMapping("/albums")
    public String albums(Model model){

        Date now = new Date();

        String html_message;
        JsonObject json = new JsonObject();
        json.addProperty("Timestamp", now.toString());
        JsonArray json_array = new JsonArray();
        JsonObject json_object = new JsonObject();
        json_object.addProperty("id", 1);
        json_object.addProperty("album", "Go Tell Fire to the Mountain");
        json_object.addProperty("artist", "Wu Lyf");

        JsonObject json_object2 = new JsonObject();
        json_object2.addProperty("id", 2);
        json_object2.addProperty("album", "Diary of a Madman");
        json_object2.addProperty("artist", "Ozzy Ozborne");

        json_array.add(json_object);
        json_array.add(json_object2);
        json.add("AlbumList", json_array);

        html_message = json.toString();


        String albums2 = "test";

        model.addAttribute("album", html_message.matches("Wu Lyf"));
        return "music/album";
    }
}
