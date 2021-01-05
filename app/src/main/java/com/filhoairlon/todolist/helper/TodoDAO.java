package com.filhoairlon.todolist.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.filhoairlon.todolist.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoDAO implements InterfaceTodoDAO {

    private SQLiteDatabase write;
    private SQLiteDatabase read;

    public TodoDAO(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        write = dbHelper.getWritableDatabase();
        read = dbHelper.getReadableDatabase();
    }

    @Override
    public boolean save(Todo todo) {

        try{

            ContentValues contentValues = new ContentValues();
            contentValues.put("NAME", todo.getName());

            write.insert(DBHelper.TABLE_TODO, null, contentValues );
            Log.i("INFO", "Tarefa Criada com sucesso");

        }catch (Exception e){
            Log.i("INFO", "Erro ao salvar tarefa" + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean update(Todo todo) {
        return false;
    }

    @Override
    public boolean delete(Todo todo) {
        return false;
    }

    @Override
    public List<Todo> list() {

        List<Todo> todos = new ArrayList<>();

        String sql = "SELECT * FROM " + DBHelper.TABLE_TODO + " ;";

        Cursor cursor = read.rawQuery(sql, null);

        while ( cursor.moveToNext() ){
            Todo todo = new Todo();

            Long id = cursor.getLong( cursor.getColumnIndex("ID"));
            String name = cursor.getString( cursor.getColumnIndex("NAME"));

            todo.setId(id);
            todo.setName(name);

            todos.add(todo);

        }
        return todos;
    }
}
