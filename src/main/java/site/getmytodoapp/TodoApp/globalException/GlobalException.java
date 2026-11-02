package site.getmytodoapp.TodoApp.globalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handler(MethodArgumentNotValidException e) {
        return new ResponseEntity<>("Wrong Input Task Not Added!", HttpStatus.BAD_GATEWAY);
    }

}
