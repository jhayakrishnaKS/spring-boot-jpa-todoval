package com.jkay.springbootjpatodoval.Repository;


import com.jkay.springbootjpatodoval.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {
}
