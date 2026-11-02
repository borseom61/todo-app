package site.getmytodoapp.TodoApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.getmytodoapp.TodoApp.globalException.TaskNotFoundException;
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

    public boolean updateTask(Tasks task) {
        if (tasksRepository.existsById(task.getId())) {
            tasksRepository.save(task);
            return true;
        }
        throw new TaskNotFoundException("No Task Found!");
    }

    public boolean deleteTask(int task_id) {
        if (tasksRepository.existsById(task_id)) {
            tasksRepository.deleteById(task_id);
            return true;
        }
        throw new TaskNotFoundException("No Task Found!");
    }


}