package site.getmytodoapp.TodoApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.getmytodoapp.TodoApp.globalException.TaskNotFoundException;
import site.getmytodoapp.TodoApp.module.Tasks;
import site.getmytodoapp.TodoApp.repository.TaskRepository;
import java.time.LocalDateTime;
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

    public List<Tasks> viewTasks() {
        List<Tasks> availableTasks = tasksRepository.findAll();
        if (!availableTasks.isEmpty()) {
            return availableTasks;
        }
        return null;
    }

    public List<Tasks> searchTasks(String keyword) {
        List<Tasks> availableTasks = tasksRepository.findByTasksContaining(keyword);
        if (!availableTasks.isEmpty()) {
            return availableTasks;
        }
        return null;
    }

    public boolean markasCompletedOrUnCompleted(int task_id) {
        Tasks tasks = tasksRepository.findById(task_id).orElse(null);
        if (tasks!=null) {
            if (!tasks.isCompleted()) {
                tasks.setCompleted(true);
                tasks.setWhenCompleted(LocalDateTime.now());
                tasksRepository.save(tasks);
                return true;
            }
            tasks.setCompleted(false);
            tasks.setWhenCompleted(null);
            tasksRepository.save(tasks);
            return false;
        }
        throw new TaskNotFoundException("Task Not Found!");
    }

}