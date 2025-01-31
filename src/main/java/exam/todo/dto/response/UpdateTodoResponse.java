package exam.todo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateTodoResponse{
    private String title;
    private String content;
}