package site.getmytodoapp.TodoApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.getmytodoapp.TodoApp.module.Tasks;
import site.getmytodoapp.TodoApp.repository.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository tasksRepository;

    public void addTaskInList(Tasks task) {
        tasksRepository.save(task);
    }
}