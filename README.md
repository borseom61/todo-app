# 📝 Todo App — Spring Boot REST API

A task management backend built with **Java, Spring Boot, and MySQL**. Create, view, update, delete, and search tasks through REST endpoints, with support for tracking completion status and completion time.

## ✨ Features

- **Create tasks** with non-null, non-empty task text.
- **View all tasks** stored in the database.
- **Search tasks** by a keyword contained in their text.
- **Update tasks** using their ID.
- **Delete tasks** using their ID.
- **Toggle completion status** between completed and incomplete.
- **Track completion time** automatically when a task is completed.
- **Persist data** in MySQL using Spring Data JPA.

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Programming language |
| Spring Boot 4.0.0 | Application framework |
| Spring Web MVC | REST endpoints |
| Spring Data JPA | Database access |
| MySQL | Persistent storage |
| Jakarta Validation | Request validation |
| Lombok | Reduce boilerplate code |
| Maven | Dependency management and build |

## 🏗️ Project Structure

```text
src/main/
├── java/site/getmytodoapp/TodoApp/
│   ├── controller/
│   │   ├── TaskControllerEdit.java
│   │   └── TaskControllerView.java
│   ├── globalException/
│   │   ├── GlobalException.java
│   │   └── TaskNotFoundException.java
│   ├── module/
│   │   └── Tasks.java
│   ├── repository/
│   │   └── TaskRepository.java
│   ├── service/
│   │   └── TaskService.java
│   └── TodoAppApplication.java
└── resources/
    └── application.properties
```

The application follows a layered structure:

**Controller → Service → Repository → MySQL**

## 🚀 Getting Started

### Prerequisites

- JDK 17
- MySQL running locally
- Git
- Maven, or the included Maven Wrapper

### 1. Clone the repository

```bash
git clone https://github.com/borseom61/todo-app.git
cd todo-app
```

### 2. Create the database

Run the following in MySQL:

```sql
CREATE DATABASE todo_app;
```

### 3. Configure the database connection

Update `src/main/resources/application.properties`:

```properties
spring.application.name=TodoApp

spring.datasource.url=jdbc:mysql://localhost:3306/todo_app
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Replace the username and password with your local MySQL credentials.

Hibernate creates or updates the entity tables during startup. The database itself must already exist.

### 4. Start the application

**Windows — PowerShell:**

```powershell
.\mvnw.cmd spring-boot:run
```

**macOS / Linux:**

```bash
chmod +x mvnw
./mvnw spring-boot:run
```

**With Maven installed:**

```bash
mvn spring-boot:run
```

The API runs at:

```text
http://localhost:8080
```

Use Postman, curl, or another HTTP client to interact with the endpoints.

## 📡 API Endpoints

| Method | Endpoint | Description | Input |
|---|---|---|---|
| POST | `/api/todo/edit/` | Create a task | JSON body |
| GET | `/api/todo/view` | Retrieve all tasks | — |
| GET | `/api/todo/view/{keyword}` | Search task text | Path variable |
| PUT | `/api/todo/edit/edit` | Update an existing task | JSON body containing `id` |
| DELETE | `/api/todo/edit/remove` | Delete a task | `id` request header |
| PUT | `/api/todo/view/isComplete?id={id}` | Toggle task completion | `id` query parameter |

### Create a task

**POST** `/api/todo/edit/`

Header:

```text
Content-Type: application/json
```

Request body:

```json
{
  "tasks": "Complete the Spring Boot project"
}
```

Example response:

```text
Task Added at 2026-11-04T10:30:00
```

### View all tasks

**GET** `/api/todo/view`

Returns the stored tasks as a JSON array.

### Search tasks

**GET** `/api/todo/view/Spring`

Returns tasks whose text contains the keyword `Spring`.

### Update a task

**PUT** `/api/todo/edit/edit`

Header:

```text
Content-Type: application/json
```

Request body:

```json
{
  "id": 1,
  "tasks": "Complete the project documentation"
}
```

Use the ID of an existing task.

> The update operation saves the submitted entity. Fields omitted from the request can be reset to their default values, including completion status and completion time.

### Delete a task

**DELETE** `/api/todo/edit/remove`

Pass the task ID as a **request header**:

```text
id: 1
```

Successful response:

```text
Deleted
```

### Toggle completion status

**PUT** `/api/todo/view/isComplete?id=1`

Each request switches the task's completion status:

- **Incomplete → Completed:** records the current completion time.
- **Completed → Incomplete:** clears the completion time.

Response when completed:

```text
Mark As Completed
```

Response when marked incomplete:

```text
Mark As UnCompleted
```

## 🗃️ Task Model

| Java Field | Type | Description |
|---|---|---|
| `id` | `int` | Auto-generated task ID |
| `tasks` | `String` | Task text; cannot be null or empty |
| `isCompleted` | `boolean` | Completion status |
| `whenCompleted` | `LocalDateTime` | Completion time; cleared when marked incomplete |

## 📌 Current Behavior

- This repository contains the backend API.
- Authentication and user-specific task lists are not implemented.
- Task text validation rejects null and empty strings; whitespace-only text is currently accepted.
- Validation failures currently return HTTP `502` with `Wrong Input Task Not Added!`.
- Updating a nonexistent task returns HTTP `400`.
- Empty task lists, searches without matches, and missing IDs during deletion or completion toggling raise `TaskNotFoundException`. A dedicated HTTP status handler for this exception is not currently implemented.

## 👨‍💻 Author

**Om Borse**

[GitHub](https://github.com/borseom61) · [Project Repository](https://github.com/borseom61/todo-app)
