package site.getmytodoapp.TodoApp.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Valid
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotEmpty
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
