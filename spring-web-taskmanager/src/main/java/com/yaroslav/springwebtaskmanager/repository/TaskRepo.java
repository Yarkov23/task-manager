package com.yaroslav.springwebtaskmanager.repository;

import com.yaroslav.springwebtaskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

    List<Task> findTaskByHeader(String header);

}
