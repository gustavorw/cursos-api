package com.grw.cursos.exceptions;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorDTO>> handleValidationError(MethodArgumentNotValidException exception) {
        List<ValidationErrorDTO> errors = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(err -> {
            ValidationErrorDTO error = new ValidationErrorDTO(err.getField(), err.getDefaultMessage());
            errors.add(error);
        });

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<MessageDTO> handleUserAlreadyExists(UserAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageDTO(ex.getMessage()));
    }

    @ExceptionHandler(NotFoundCourseException.class)
    public ResponseEntity<MessageDTO> handleNotFound(NotFoundCourseException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDTO(ex.getMessage()));
    }

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<MessageDTO> handleNotFoundUser(NotFoundUserException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDTO(ex.getMessage()));
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<MessageDTO> handleIncorrectPassword(IncorrectPasswordException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageDTO(ex.getMessage()));
    }

}
