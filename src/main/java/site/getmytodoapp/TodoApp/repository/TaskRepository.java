package site.getmytodoapp.TodoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.getmytodoapp.TodoApp.module.Tasks;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Tasks,Integer> {
    List<Tasks> findByTasksContaining(String keyword);
}
