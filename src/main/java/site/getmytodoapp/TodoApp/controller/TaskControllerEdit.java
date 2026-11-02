package site.getmytodoapp.TodoApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.getmytodoapp.TodoApp.module.Tasks;
import site.getmytodoapp.TodoApp.service.TaskService;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo/edit")
public class TaskControllerEdit {
    private final TaskService service;

    @PostMapping("/")
    public ResponseEntity<String> addTask(Tasks task) {
        service.addTaskInList(task);
        LocalDateTime latestTime = LocalDateTime.now();
        return new ResponseEntity<>("Task Added at "+latestTime, HttpStatus.OK);
    }

}
