package com.filhoairlon.todolist.helper;

import com.filhoairlon.todolist.model.Todo;

import java.util.List;

public interface InterfaceTodoDAO {

    public boolean save(Todo todo);
    public boolean update(Todo todo);
    public boolean delete(Todo todo);
    public List<Todo> list();
}
