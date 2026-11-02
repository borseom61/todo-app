package site.getmytodoapp.TodoApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.getmytodoapp.TodoApp.globalException.TaskNotFoundException;
import site.getmytodoapp.TodoApp.module.Tasks;
import site.getmytodoapp.TodoApp.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo/view")
public class TaskControllerView {
    private final TaskService service;

    @GetMapping()
    public ResponseEntity<List<Tasks>> viewAllTasks() {
        List<Tasks> viewTask = service.viewTasks();
        if (viewTask!=null) {
            return new ResponseEntity<>(viewTask, HttpStatus.OK);
        }
        throw new TaskNotFoundException("List is Empty");
    }

}
