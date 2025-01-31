package exam.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;
}
