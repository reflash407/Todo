package exam.todo.controller;


import exam.todo.domain.Todo;
import exam.todo.dto.*;
import exam.todo.dto.request.CreateTodoRequset;
import exam.todo.dto.request.UpdateTodoRequset;
import exam.todo.dto.response.CreateTodoResponse;
import exam.todo.dto.response.DeleteTodoResponse;
import exam.todo.dto.response.UpdateTodoResponse;
import exam.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/todo")
    public Result<CreateTodoResponse> saveTodo(@RequestBody CreateTodoRequset requset){

        Todo todo = new Todo();
        todo.setTitle(requset.getTitle());
        todo.setContent(requset.getContent());
        Long id = todoService.create(todo);

        return Result.<CreateTodoResponse>builder()
                .code(HttpStatus.OK.value())
                .message("Todo 생성 완료")
                .data(new CreateTodoResponse(id))
                .build();
    }

    @GetMapping("/todo/{id}")
    public Result<TodoDto> Todo(@PathVariable("id") Long id){
        Todo findTodo = todoService.read(id);

        return Result.<TodoDto>builder()
                .code(HttpStatus.OK.value())
                .message("Todo 조회")
                .data(new TodoDto(findTodo.getTitle(), findTodo.getContent()))
                .build();
    }

    @GetMapping("/todo")
    public Result<List<TodoDto>> Todos() {
        List<Todo> todos = todoService.readAll();
        List<TodoDto> collect = todos.stream()
                .map(t -> new TodoDto(t.getTitle(), t.getContent()))
                .collect(Collectors.toList());

        return Result.<List<TodoDto>>builder()
                .code(HttpStatus.OK.value())
                .message("Todo 전체 조회")
                .data(collect)
                .build();
    }

    @PutMapping("/todo/{id}")
    public Result<UpdateTodoResponse> updateTodo(
            @PathVariable("id") Long id,
            @RequestBody UpdateTodoRequset requset){

        todoService.updateTitle(id, requset.getTitle());
        Todo findTodo = todoService.read(id);

        return Result.<UpdateTodoResponse>builder()
                .code(HttpStatus.OK.value())
                .message("업데이트에 성공하였습니다.")
                .data(new UpdateTodoResponse(findTodo.getTitle(), findTodo.getContent()))
                .build();
    }

    @DeleteMapping("/todo/{id}")
    public Result<DeleteTodoResponse> deleteTodo(@PathVariable("id") Long id) {
        todoService.delete(id);
        return Result.<DeleteTodoResponse>builder()
                .code(HttpStatus.OK.value())
                .message("삭제가 완료되었습니다.")
                .data(new DeleteTodoResponse(id))
                .build();
    }






















}
