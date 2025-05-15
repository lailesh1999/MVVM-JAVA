package com.example.mvvm_example1.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvm_example1.model.TodoItems;
import com.example.mvvm_example11.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllTodoListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllTodoListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;

    List<TodoItems> todoList = new ArrayList<>();

    public AllTodoListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllTodoListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AllTodoListFragment newInstance(String param1, String param2) {
        AllTodoListFragment fragment = new AllTodoListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_todo_list,container,false);

        recyclerView = view.findViewById(R.id.allListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        todoList.add(new TodoItems("Buy groceries", "Today, 5:00 PM", "", 0, R.color.orange));
        todoList.add(new TodoItems("Call plumber", "", "", 0, R.color.red));
        todoList.add(new TodoItems("Finish report", "Tomorrow", "Work", 0, R.color.blue));
        todoList.add(new TodoItems("Read a book", "", "", 1, R.color.green));


        return view;
       // return inflater.inflate(R.layout.fragment_all_todo_list, container, false);
    }
}