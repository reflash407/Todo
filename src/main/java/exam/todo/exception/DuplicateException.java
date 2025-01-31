package exam.todo.exception;


import lombok.Getter;

@Getter
public class DuplicateException extends RuntimeException{
    private ExceptionEnum exceptionEnum;
    public DuplicateException(String message, ExceptionEnum exceptionEnum){
        super(message);
        this.exceptionEnum = exceptionEnum;
    }
}
