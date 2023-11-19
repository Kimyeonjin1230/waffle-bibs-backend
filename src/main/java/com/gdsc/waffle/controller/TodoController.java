package com.gdsc.waffle.controller;

import com.gdsc.waffle.dto.TodoDto;
import com.gdsc.waffle.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class TodoController {

    private final TodoService todoService;

    // todo 목록 전체 가져오기
    @GetMapping("/{categoryId}")
    public ResponseEntity<List<TodoDto>> getAllTodos(@PathVariable Long categoryId) {
        List<TodoDto> todos = todoService.findAll();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    // todo 상세조회
    @GetMapping("/{todoId}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable Long todoId) {
        TodoDto todo = todoService.findById(todoId);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    // todo 생성
    @PostMapping("/{categoryId}/add")
    public ResponseEntity<TodoDto> addTodo(@PathVariable Long categoryId, @RequestBody TodoDto todoDto) {
        todoService.addTodo(categoryId, todoDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // todo 수정
    @PatchMapping("/{todoId}/update")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long todoId, @ModelAttribute TodoDto todoDto) {
        todoService.update(todoId, todoDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // todo 삭제
    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long todoId) {
        todoService.deleteTodo(todoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}