package site.getmytodoapp.TodoApp.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tasks;
    private boolean isCompleted;
    private LocalDateTime whenCompleted;

    public Tasks(String tasks) {
        this.tasks = tasks;
        this.isCompleted = false;
    }

    public Tasks(int id,String tasks) {
        this.id = id;
        this.tasks = tasks;
        this.isCompleted = false;
    }
}
