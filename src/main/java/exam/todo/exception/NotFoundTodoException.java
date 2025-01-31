package exam.todo.exception;


import lombok.Getter;

@Getter
public class NotFoundTodoException extends RuntimeException{
    private ExceptionEnum exceptionEnum;
    public NotFoundTodoException(String message, ExceptionEnum exceptionEnum){
        super(message);
        this.exceptionEnum = exceptionEnum;
    }
}
