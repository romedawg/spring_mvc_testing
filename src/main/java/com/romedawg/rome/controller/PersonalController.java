package com.romedawg.rome.controller;

import com.romedawg.rome.Domain.Owner;
import com.romedawg.rome.Domain.Task;
import com.romedawg.rome.Repositories.Metra.OwnerRepository;
import com.romedawg.rome.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

// Page for Todo, shedule, shopping list, etc..

@Controller
public class PersonalController {

    @Autowired
    private TaskRepository taskRepository;
    private OwnerRepository ownerRepository;

    @RequestMapping("/rome")
    public String todo(Model model){
        List<Task> my_list = new ArrayList<Task>();

//        my_list.add(new Task(2,"Task1", "First task in the list", 10, ownerRepository.findById(1)));
//        my_list.add(new Task(3, "first task", "just getting started,", 5));

        Task task1 = new Task(3, "first task", "just getting started,", 5);

        taskRepository.save(task1);

        Owner owner = new Owner("igby");
        ownerRepository.save(owner);
//        System.out.printf("%s", bb.indexOf(0));


        List bb = taskRepository.findTaskById(1);
        System.out.printf("%s", bb.indexOf(0));

        model.addAttribute("tasks", bb.toString());
        return "todo/todo";}

}
