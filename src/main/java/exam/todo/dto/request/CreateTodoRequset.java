package exam.todo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateTodoRequset{

    private String title;
    private String content;
}