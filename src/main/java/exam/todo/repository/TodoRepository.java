package exam.todo.repository;

import exam.todo.domain.Todo;

import java.util.List;

public interface TodoRepository {

    Long save(Todo todo);
    Todo findById(Long id);
    List<Todo> findAll();
    Long update(Todo todo);
    Long delete(Long id);
}
