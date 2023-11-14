package com.jkay.springbootjpatodoval.Controller;

import com.jkay.springbootjpatodoval.Model.Todo;
import com.jkay.springbootjpatodoval.Request.TodoRequest;
import com.jkay.springbootjpatodoval.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/all/{userId}")
    public List<Todo> getTodo(@PathVariable int userId) {
        return todoService.findAll(userId);
    }

    @PostMapping
    public List<Todo> addtodo(@RequestBody TodoRequest todo) {
        return todoService.addTodo(todo);
    }

    @PutMapping
    public List<Todo> upadate(@RequestBody TodoRequest todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("/delete/{id}")
    public List<Todo> delete(@PathVariable int id) {
        return todoService.delete(id);
    }

}