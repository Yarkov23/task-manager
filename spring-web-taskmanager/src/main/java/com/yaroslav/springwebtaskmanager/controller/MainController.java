package com.yaroslav.springwebtaskmanager.controller;

import com.yaroslav.springwebtaskmanager.model.Task;
import com.yaroslav.springwebtaskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/tasks")
public class MainController {

    private final TaskService taskService;

    @Autowired
    public MainController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String main(Model model, @Param("keyword") String keyword) {
        List<Task> tasks = taskService.findAll(keyword);
        model.addAttribute("tasks", tasks);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String removeTask(@PathVariable("id") Long id) {
        taskService.deleteById(id);
        return "redirect:/tasks";
    }

    @GetMapping("/create")
    public String createTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "create";
    }

    @PostMapping("/create")
    public String createTask(Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/update/{id}")
    public String updateTaskForm(@PathVariable("id") Long id, Model model) {
        var task = taskService.findById(id);
        model.addAttribute("task", task);
        return "update";
    }

    @PostMapping("/update")
    public String updateTask(Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

}
