package exam.todo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Todo {
    private Long id;
    private String title;
    private String content;
}
