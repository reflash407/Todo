package exam.todo.repository;

import exam.todo.domain.Todo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TodoRepositoryImpl implements TodoRepository{

    private static Map<Long, Todo> data = new HashMap<>();
    private static Long sequence = 0L;


    @Override
    public Long save(Todo todo) {
        todo.setId(sequence++);
        data.put(todo.getId(), todo);
        return todo.getId();
    }

    @Override
    public Todo findById(Long id) {
        return data.get(id);
    }

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Long update(Todo todo) {
        data.put(todo.getId(), todo);
        return todo.getId();
    }


    @Override
    public Long delete(Long id) {
        data.remove(id);
        return id;
    }
}
