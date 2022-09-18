package com.example.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DayController {

    @GetMapping("day")
    public String day(Model model){
        model.addAttribute("data");
        return "Today ToDoList";
    }

}
