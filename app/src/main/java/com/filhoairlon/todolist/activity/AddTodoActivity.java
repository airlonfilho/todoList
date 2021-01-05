package com.filhoairlon.todolist.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.filhoairlon.todolist.R;
import com.filhoairlon.todolist.helper.TodoDAO;
import com.filhoairlon.todolist.model.Todo;
import com.google.android.material.textfield.TextInputEditText;

public class AddTodoActivity extends AppCompatActivity {

    private TextInputEditText editTodo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        editTodo = findViewById(R.id.textTodo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.itemSalvar:

                TodoDAO todoDAO = new TodoDAO( getApplicationContext() );

                String nameTodo = editTodo.getText().toString();

                if ( !nameTodo.isEmpty()){
                    Todo todo = new Todo();
                    todo.setName(nameTodo);

                    todoDAO.save(todo);

                    finish();
                }

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}