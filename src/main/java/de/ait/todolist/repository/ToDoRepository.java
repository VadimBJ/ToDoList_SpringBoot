package de.ait.todolist.repository;

import de.ait.todolist.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ToDoRepository {
  private static List<ToDo> toDoList = new ArrayList<>(
      List.of(
          new ToDo("first task"),
          new ToDo("second task"),
          new ToDo("third task")
      )
  );

  public List<ToDo> getTodoList() {
    return toDoList;
  }

  public void addToDo(ToDo newtoDo) {
    toDoList.add(newtoDo);
  }

  public void remove(int id) {
    toDoList.remove(id);
  }

  public void editToDo(ToDo newToDo) {
    toDoList.stream()
        .filter(todo -> todo.getId() == newToDo.getId())
        .findFirst()
        .ifPresent(todo -> todo.setDescription(newToDo.getDescription()));
  }
}
