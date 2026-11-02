package site.getmytodoapp.TodoApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.getmytodoapp.TodoApp.service.TaskService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo/edit")
public class TaskControllerEdit {
    private final TaskService service;

    @PostMapping("/")

}
