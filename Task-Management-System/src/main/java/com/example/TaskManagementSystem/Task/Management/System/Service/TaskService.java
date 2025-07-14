package com.example.TaskManagementSystem.Task.Management.System.Service;

import com.example.TaskManagementSystem.Task.Management.System.Entity.TaskEntity;
import com.example.TaskManagementSystem.Task.Management.System.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createTask(TaskEntity task) {
        taskRepository.save(task);
    }

    public void deleteTaskById(int id) {
        taskRepository.deleteById(id);
    }

    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }

    public void markCompleted(int id) {
        TaskEntity task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setCompleted(true);
            taskRepository.save(task);
        }
    }
}
