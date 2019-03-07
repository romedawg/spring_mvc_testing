package com.romedawg.rome.controller;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.romedawg.rome.Domain.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

// Page for Todo, shedule, shopping list, etc..

@Controller
public class PersonalController {

    @RequestMapping("/rome")
    public String todo(Model model){
        List<Task> my_list = new ArrayList<Task>();

        my_list.add(new Task(1, "Task1", "First task in the list", Task.Status.CREATED, 10));

        Gson gson = new Gson();
        Type type = new TypeToken<List<Task>>() {}.getType();
        String json = gson.toJson(my_list, type);
        JsonParser json_parser = new JsonParser();
        JsonElement json_element = json_parser.parse(json).getAsJsonObject();
        JsonArray tt = json_element.getAsJsonArray();


//        String id;
//        String summary = "";
//        String descrption = "";
//        for (JsonElement je : tt){
//            JsonObject jo = je.getAsJsonObject();
//            id = je.get("Id").getAsString();
//            summary = je.get("summary").getAsString();
//        }


        List<Task> fromJson = gson.fromJson(json, type);
        for (Task task : fromJson) {
            System.out.println(task);
            System.out.println(tt.getClass().getName());
        }

        model.addAttribute("tasks", tt.toString());
        return "todo/todo";}

}
