package exam.todo.dto.response;

import exam.todo.exception.ExceptionEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private int status;
    private String message;

    public ErrorResponse(ExceptionEnum errorCode){
        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();
    }
}
