# Todo Manager – Full Stack Spring Boot Application

## Overview

Todo Manager is a simple full-stack task management application built with **Spring Boot, MySQL, and JavaScript**.
It allows users to create, update, view, and delete tasks while tracking their progress using status values such as **PENDING, IN_PROGRESS, and COMPLETED**.

The project demonstrates a typical **layered backend architecture** used in enterprise Java applications.

---

## Features

* Create new tasks
* View all tasks
* Update task details and status
* Delete tasks
* Filter tasks by status
* Pagination support for large task lists
* Simple frontend interface using HTML, CSS, and JavaScript

---

## Tech Stack

### Backend

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL

### Frontend

* HTML
* CSS
* JavaScript
* Fetch API

### Tools

* Eclipse / Spring Tool Suite
* VS Code
* Postman
* Git & GitHub

---

## Project Architecture

```
Controller → Service → Repository → Database
```

* **Controller** – Handles REST API requests
* **Service** – Contains business logic
* **Repository** – Manages database interaction with JPA
* **Entity** – Represents database tables

---

## API Endpoints

| Method | Endpoint                 | Description            |
| ------ | ------------------------ | ---------------------- |
| POST   | `/tasks`                 | Create a new task      |
| GET    | `/tasks`                 | Retrieve all tasks     |
| GET    | `/tasks/{id}`            | Retrieve a task by ID  |
| PUT    | `/tasks/{id}`            | Update a task          |
| DELETE | `/tasks/{id}`            | Delete a task          |
| GET    | `/tasks/status/{status}` | Filter tasks by status |

Example statuses:

```
PENDING
IN_PROGRESS
COMPLETED
```

---

## How to Run the Project

### 1. Clone the Repository

```
git clone https://github.com/YOUR_USERNAME/todo-manager.git
```

### 2. Configure Database

Create a MySQL database:

```
CREATE DATABASE todo_db;
```

Update `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

### 3. Run Backend

Run the Spring Boot application from your IDE.

Server will start on:

```
http://localhost:8080
```

### 4. Run Frontend

Open `index.html` using a browser or Live Server in VS Code.

---

## Future Improvements

* Authentication with Spring Security
* User-based task management
* Responsive UI with Bootstrap or React
* Task reminders and notifications

---

## Author

Nayan Dahare
Java Backend Developer | Spring Boot | REST APIs
