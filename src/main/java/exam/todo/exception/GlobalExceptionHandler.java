package exam.todo.exception;

import exam.todo.dto.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundTodoException.class)
    public ResponseEntity<ErrorResponse> notFoundTodoException(NotFoundTodoException ex){
        log.error("handleTodoException",ex);
        ErrorResponse response = new ErrorResponse(ex.getExceptionEnum());
        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getExceptionEnum().getStatus()));
    }

    @ExceptionHandler(RequireValueException.class)
    public ResponseEntity<ErrorResponse> requireValueException(RequireValueException ex){
        log.error("handleTodoException",ex);
        ErrorResponse response = new ErrorResponse(ex.getExceptionEnum());
        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getExceptionEnum().getStatus()));
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ErrorResponse> duplicateException(DuplicateException ex){
        log.error("handleTodoException",ex);
        ErrorResponse response = new ErrorResponse(ex.getExceptionEnum());
        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getExceptionEnum().getStatus()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex){
        log.error("handleException",ex);
        ErrorResponse response = new ErrorResponse(ExceptionEnum.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
