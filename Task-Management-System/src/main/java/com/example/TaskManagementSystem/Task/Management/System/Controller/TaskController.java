package com.example.TaskManagementSystem.Task.Management.System.Controller;

import com.example.TaskManagementSystem.Task.Management.System.Entity.TaskEntity;
import com.example.TaskManagementSystem.Task.Management.System.Service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task_entity")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/get")
    public String home(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("newTask", new TaskEntity());
        return "index";  // NOT index.html — just "index"
    }


    @PostMapping("/add")
    public String addTask(@ModelAttribute TaskEntity newTask) {
        taskService.createTask(newTask);
        return "redirect:/task_entity/get";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.deleteTaskById(id);
        return "redirect:/task_entity/get";
    }

    @GetMapping("/deleteAll")
    public String deleteAllTasks() {
        taskService.deleteAllTasks();
        return "redirect:/task_entity/get";
    }

    @GetMapping("/complete/{id}")
    public String markAsCompleted(@PathVariable int id) {
        taskService.markCompleted(id);
        return "redirect:/task_entity/get";
    }
}
