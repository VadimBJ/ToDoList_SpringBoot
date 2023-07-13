package de.ait.todolist;

public class ToDo {
  private int id;
  private static int counter = 0;
  private String description;

  public ToDo() {
  }

  public ToDo(String description) {
    this.id = ++counter;
    this.description = description;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
