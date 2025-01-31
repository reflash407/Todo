package exam.todo.exception;


import lombok.Getter;

@Getter
public class RequireValueException extends RuntimeException{
    private ExceptionEnum exceptionEnum;
    public RequireValueException(String message, ExceptionEnum exceptionEnum){
        super(message);
        this.exceptionEnum = exceptionEnum;
    }
}
