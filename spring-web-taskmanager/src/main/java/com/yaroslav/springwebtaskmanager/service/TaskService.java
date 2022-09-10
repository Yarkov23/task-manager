package com.yaroslav.springwebtaskmanager.service;

import com.yaroslav.springwebtaskmanager.model.Task;
import com.yaroslav.springwebtaskmanager.repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public Optional<Task> findById(Long id) {
        return taskRepo.findById(id);
    }

    public List<Task> findAll(String keyword) {
        if (keyword == null) {
            return taskRepo.findAll();
        }
        return taskRepo.findTaskByHeader(keyword);
    }

    public Task saveTask(Task task) {
        task.setCreationDate(LocalDate.now());
        return taskRepo.save(task);
    }

    public void deleteById(Long id) {
        taskRepo.deleteById(id);
    }
}
