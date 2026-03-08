package com.nayan.entity;

import java.time.LocalDateTime;

import com.nayan.model.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Title cannnot be empty")
	private String title;
	
	@NotBlank(message = "Description cannnot be empty")
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private LocalDateTime createdDate;
	
	public Task() {}

	public Task(Long id, String title, String description, Status status, LocalDateTime createdDate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	
	
}
