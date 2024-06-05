package com.gaurav.springboot.learnwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class TodoControllerJPA {

    private final TodoRepository todoRepository;

    TodoControllerJPA(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @RequestMapping("list-todos")
    public String getTodos(ModelMap model){
        String username = getLoggedInUsername();
        System.out.println("username we got " + username);
        List<Todo> todosList = todoRepository.findByUsername(username);
        model.addAttribute("todos",todosList);
        return "todos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap model){
        String username = (String) model.get("username");
        Todo todo = new Todo(0,"", LocalDate.now(),false,username);
        model.put("todo",todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addTodo(@Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        String username = getLoggedInUsername();
        todo.setUsername(username);
        System.out.println("saving todo " + todo);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model){
        Todo todo = todoRepository.findById(id).get();
        model.put("todo",todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String doUpdateTodo(@Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        String username = getLoggedInUsername();
        todo.setUsername(username);
        System.out.println("updating todo " + todo);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    public String getLoggedInUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
