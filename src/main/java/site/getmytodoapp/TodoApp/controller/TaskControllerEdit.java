package site.getmytodoapp.TodoApp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.getmytodoapp.TodoApp.module.Tasks;
import site.getmytodoapp.TodoApp.service.TaskService;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo/edit")
public class TaskControllerEdit {
    private final TaskService service;

    @PostMapping("/")
    public ResponseEntity<String> addTask(@RequestBody @Valid Tasks task) {
        service.addTaskInList(task);
        LocalDateTime latestTime = LocalDateTime.now();
        return new ResponseEntity<>("Task Added at "+latestTime, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<String> updateTask(@RequestBody @Valid Tasks task) {
        if (service.updateTask(task)) {
            LocalDateTime latestTime = LocalDateTime.now();
            return new ResponseEntity<>("Task Updated at "+latestTime, HttpStatus.OK);
        }
        return new ResponseEntity<>("Task Not Updated!",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> deleteTask(@RequestHeader int id) {
        if (service.deleteTask(id)) {
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Task Not Deleted!",HttpStatus.BAD_REQUEST);
    }

}
