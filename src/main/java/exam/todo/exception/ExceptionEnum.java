package exam.todo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {
    NOT_FOUND_TODO(404,"Todo를 찾을 수 없습니다."),
    DUPLICATE(400,"중복된 값입니다."),
    REQUIRE_VALUE(400,"필수 값이 없습니다."),
    INTERNAL_SERVER_ERROR(500, "서버 에러입니다.");
    private final int status;
    private String message;
}
