package com.marshad.hellospring.repository;

import com.marshad.hellospring.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {


}
