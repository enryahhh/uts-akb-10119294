package com.example.uts_10119294_lingga.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_10119294_lingga.adapter.TodoAdapter;
import com.example.uts_10119294_lingga.databinding.FragmentDashboardBinding;
import com.example.uts_10119294_lingga.models.Todo;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private RecyclerView recyclerView;
    private TodoAdapter adapter;
    private List<Todo> todos;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
//        final TextView textView = binding.textDashboard;
//        textView.setText("Dashbor");
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = binding.recyclerViewTodo;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        todos = dummyTodo();
        adapter = new TodoAdapter(todos);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private List<Todo> dummyTodo(){
        List<Todo> todosnya = new ArrayList<>();
        for(int i=1;i<=5;i++){
            Todo todo = new Todo();
            todo.setTodo("coba");
            todo.setDescription("tes aja");
            todosnya.add(todo);
        }
        return todosnya;
    }
}