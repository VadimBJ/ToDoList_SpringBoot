package de.ait.todolist.services;

import de.ait.todolist.ToDo;
import de.ait.todolist.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
  ToDoRepository toDoRepository;

  public ToDoService(ToDoRepository toDoRepository) {
    this.toDoRepository = toDoRepository;
  }

  public List<ToDo> getTodoList() {
    return toDoRepository.getTodoList();
  }

  public void addToDo(ToDo newtoDo) {
    toDoRepository.addToDo(newtoDo);
  }

  public void remove(Integer id) {
    toDoRepository.remove(id);
  }

  public void editToDo(ToDo toDo) {
    toDoRepository.editToDo(toDo);
  }
}
