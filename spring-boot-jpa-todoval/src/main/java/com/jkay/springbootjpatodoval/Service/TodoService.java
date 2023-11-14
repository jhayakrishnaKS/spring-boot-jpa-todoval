package com.jkay.springbootjpatodoval.Service;

import com.jkay.springbootjpatodoval.Model.AppUser;
import com.jkay.springbootjpatodoval.Model.Todo;
import com.jkay.springbootjpatodoval.Repository.AppUserRepository;
import com.jkay.springbootjpatodoval.Repository.TodoRepository;
import com.jkay.springbootjpatodoval.Request.TodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRespository;

    @Autowired
    private AppUserRepository appUserRepository;

    public List<Todo> findAll(int userId) {
        return todoRespository.findAll()
                .stream()
                .filter(todo -> todo.getAppUser().getId() == userId)
                .collect(Collectors.toList());
    }

    public List<Todo> addTodo(TodoRequest todo) {
        Todo originalTodo = new Todo();
        originalTodo.setTodo(todo.getTodo());
        AppUser user = appUserRepository.findById(todo.getUserId()).get();
        originalTodo.setAppUser(user);
        todoRespository.save(originalTodo);
        return findAll(todo.getUserId());
    }

    public List<Todo> update(TodoRequest todo) {
        Todo originalTodo = new Todo();
        originalTodo.setId(todo.getId());
        originalTodo.setTodo(todo.getTodo());
        AppUser user = appUserRepository.findById(todo.getUserId()).get();
        originalTodo.setAppUser(user);
        todoRespository.save(originalTodo);
        return findAll(todo.getUserId());
    }

    public List<Todo> delete(Integer id) {
        int userId = todoRespository.findById(id).get().getAppUser().getId();
        todoRespository.deleteById(id);
        return findAll(userId);
    }
}