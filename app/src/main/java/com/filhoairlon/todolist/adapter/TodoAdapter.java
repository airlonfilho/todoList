package com.filhoairlon.todolist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.filhoairlon.todolist.R;
import com.filhoairlon.todolist.model.Todo;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.MyViewHolder> {

    private List<Todo> listTodo;

    public TodoAdapter(List<Todo> list) {
        this.listTodo = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemList = LayoutInflater.from((parent.getContext()))
                                      .inflate(R.layout.list_todo_adapter, parent, false);

        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Todo todo = listTodo.get(position);
        holder.todo.setText(todo.getName());
    }

    @Override
    public int getItemCount() {
        return this.listTodo.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView todo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            todo = itemView.findViewById(R.id.textViewList);
        }
    }

}
