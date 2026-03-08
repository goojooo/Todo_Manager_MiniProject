package com.nayan.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nayan.entity.Task;
import com.nayan.model.Status;
import com.nayan.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;
	
	public Task createTask(Task task) {
		task.setCreatedDate(LocalDateTime.now());
		task.setStatus(Status.PENDING);
		return taskRepository.save(task);
	}
	
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}
	
	public Task getTaskById(Long id) {
		return taskRepository.findById(id).orElse(null);
	}
	
	public Task updateTask(Long id, Task updatedTask) {

	    Task existingTask = taskRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Task not found"));

	    existingTask.setTitle(updatedTask.getTitle());
	    existingTask.setDescription(updatedTask.getDescription());
	    existingTask.setStatus(updatedTask.getStatus());

	    return taskRepository.save(existingTask);
	}
	
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}
	
	public List<Task> getTasksByStatus(Status status) {
		return taskRepository.findByStatus(status);
	}
	
}
