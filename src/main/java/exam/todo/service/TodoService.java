package exam.todo.service;

import exam.todo.domain.Todo;
import exam.todo.exception.DuplicateException;
import exam.todo.exception.ExceptionEnum;
import exam.todo.exception.NotFoundTodoException;
import exam.todo.exception.RequireValueException;
import exam.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Long create(Todo todo){
        if(todo.getTitle().isEmpty() || todo.getContent().isEmpty()){
            throw new RequireValueException("필수 값을 보내지 않았습니다", ExceptionEnum.REQUIRE_VALUE);
        }
        todoRepository.save(todo);
        return todo.getId();
    }

    public List<Todo> readAll(){
        return todoRepository.findAll();
    }

    public Todo read(Long id){
        Todo findTodo = todoRepository.findById(id);
        if(findTodo==null){
            throw new NotFoundTodoException("Not Found Todo", ExceptionEnum.NOT_FOUND_TODO);
        }
        return findTodo;
    }

    public Long updateTitle(Long id, String title){
        Todo findTodo = todoRepository.findById(id);
        if(findTodo.getTitle().equals(title)){
            throw new DuplicateException("title duplicate", ExceptionEnum.DUPLICATE);
        }
        findTodo.setTitle(title);
        return todoRepository.update(findTodo);
    }

    public Long updateContent(Long id, String content){
        Todo findTodo = todoRepository.findById(id);
        findTodo.setContent(content);
        return todoRepository.update(findTodo);
    }

    public Long delete(Long id){
        Todo findTodo = todoRepository.findById(id);
        if(findTodo==null){
            throw new NotFoundTodoException("Not Found Todo", ExceptionEnum.NOT_FOUND_TODO);
        }
        return todoRepository.delete(id);
    }

}
