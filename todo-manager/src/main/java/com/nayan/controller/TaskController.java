package com.nayan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nayan.entity.Task;
import com.nayan.model.Status;
import com.nayan.repository.TaskRepository;
import com.nayan.service.TaskService;

import jakarta.validation.Valid;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;
	
	@Autowired
	private TaskService taskService;

    TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
	
	@PostMapping
	public Task createTask(@Valid @RequestBody Task task) {
		return taskService.createTask(task);
	}
	
//	@GetMapping
//	public List<Task> getAllTasks() {
//		return taskService.getAllTasks();
//	}
	
	@GetMapping
	public Page<Task> getAllTasks(Pageable pageable){
		return taskRepository.findAll(pageable);
	}
	
	@GetMapping("/{id}")
	public Task getTaskById(@PathVariable Long id) {
		return taskService.getTaskById(id);
	}
	
	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task task){
	    return taskService.updateTask(id, task);
	}
	

	@DeleteMapping("/{id}")
	public String deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
		return "Task deleted...";
	}
	
	@GetMapping("/status/{status}")
	public List<Task> getByStatus(@PathVariable Status status) {
		return taskService.getTasksByStatus(status);
	}
	
}
