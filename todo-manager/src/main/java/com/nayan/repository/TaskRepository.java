package com.nayan.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nayan.entity.Task;
import com.nayan.model.Status;

public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findByStatus(Status status);
	Page<Task> findAll(Pageable pageable);
}
