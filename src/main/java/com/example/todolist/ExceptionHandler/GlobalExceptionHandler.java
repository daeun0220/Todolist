package com.example.todolist.ExceptionHandler;


import com.example.todolist.Exception.NotFoundMemberException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Member 찾지 못했을 때
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundMemberException.class) // 인자로 캐치하고싶은 예외클래스
    public String handleNotFoundMemberException(NotFoundMemberException exception) {
        log.error(exception.getMessage());
        return exception.getMessage();
    }

}

