package com.example.exception.controller;

import com.example.exception.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class ApiController {
    @GetMapping("")
    public User get(@RequestParam(required=false) String name, @RequestParam(required=false) int age) {
        User user = new User();
        user.setAge(age);
        user.setName(name);
        return user;
    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user) {
        return user;

    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e){
        System.out.println("api controller");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
