package de.ait.todolist.controller;

import de.ait.todolist.ToDo;
import de.ait.todolist.services.ToDoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class TodoController {
  ToDoService toDoService;

  public TodoController(ToDoService toDoService) {
    this.toDoService = toDoService;
  }

  @GetMapping ("/")
    public String openToDos(){
    return "start";
    }

  @GetMapping("/todos")
  public String getAllToDos(Model model) {
    model.addAttribute("toDoList", toDoService.getTodoList());
    return "todos";
  }

  @PostMapping("/todos")
  public String addToDo(Model model, @ModelAttribute("todo") ToDo todo) {
    if (!todo.getDescription().trim().equals("")) {
      ToDo newtoDo = new ToDo(todo.getDescription());
      toDoService.addToDo(newtoDo);
    }
    return "redirect:/todos";
  }

  @PostMapping("/todos/delete")
  public String deleteTodo(@RequestParam("id") int id) {
    toDoService.remove(id);
    return "redirect:/todos";
  }

  @GetMapping("/todos/edit/{id}")
  public String editTodoForm(@PathVariable("id") int id, Model model) {
    Optional<ToDo> editTodo = toDoService.getTodoList().stream()
        .filter(todo -> todo.getId() == id)
        .findFirst();
    model.addAttribute("todo", editTodo);
    return "edittodo";
  }

  @PostMapping("/todos/save")
  public String saveEditedTodo(@ModelAttribute ToDo toDo) {
    toDoService.editToDo(toDo);
    return "redirect:/todos";
  }
}
