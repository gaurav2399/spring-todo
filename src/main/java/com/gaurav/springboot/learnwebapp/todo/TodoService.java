package com.gaurav.springboot.learnwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1,"Spring",  LocalDate.now().plusYears(2), false, "gaurav"));
        todos.add(new Todo(2,"LLD",  LocalDate.now().plusYears(1), true, "gaurav"));
        todos.add(new Todo(3,"DSA",  LocalDate.now().plusYears(3), false, "gaurav"));
    }

    public List<Todo> findTodosByName(String name){
        System.out.println("list we have to send " + todos + " for user " + name);
        return todos.stream().filter(todo -> todo.getUsername().equals(name)).toList();
    }

    public void addTodo(int id, String title, LocalDate date, boolean done, String username){
        Todo todo = new Todo(id, title, date, done, username);
        todos.add(todo);
    }

    public void deleteTodo(int id){
        todos.removeIf(todo -> todo.getId() == id);
    }

    public void updateTodo(Todo todo){
        deleteTodo(todo.getId());
        todos.add(todo);
    }

    public Todo findTodoById(int id){
        return todos.stream().filter(todo -> todo.getId() == id).findFirst().get();
    }
}
