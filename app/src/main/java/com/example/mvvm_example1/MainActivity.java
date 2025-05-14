package com.example.mvvm_example1;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm_example1.adapter.NewsAdapter;
import com.example.mvvm_example1.fragment.AllTodoListFragment;
import com.example.mvvm_example1.fragment.CompletedTodoListFragment;
import com.example.mvvm_example1.fragment.TodaysTodoListFragment;
import com.example.mvvm_example1.viewmodel.NewsViewModel;
import com.example.mvvm_example11.R;

public class MainActivity extends AppCompatActivity {
    private NewsViewModel viewModel;
    private RecyclerView recyclerView;
    private NewsAdapter adapter;
    private TextView all, today, completed;
    private FrameLayout todoFrameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            all = findViewById(R.id.all);
            today = findViewById(R.id.today);
            completed = findViewById(R.id.completed);
            todoFrameLayout = findViewById(R.id.FragmentContainer);
     loadFragment(new AllTodoListFragment());
     highlightSelectedTab(all);

     all.setOnClickListener(v ->{
         loadFragment(new AllTodoListFragment());
         highlightSelectedTab(all);
     });

     today.setOnClickListener(v->{
         loadFragment(new TodaysTodoListFragment());
         highlightSelectedTab(today);

     });

     completed.setOnClickListener(v->{
         loadFragment(new CompletedTodoListFragment());
         highlightSelectedTab(completed);
     });
//        recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new NewsAdapter();
//        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(NewsViewModel.class);
        viewModel.getNewsArticles().observe(this, articles -> {
            adapter.setArticles(articles);
        });

        viewModel.fetchNews("tesla", "2025-03-01", "publishedAt", "ac397abe7917419ab00620ed80c49d9b");
    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.FragmentContainer,fragment);
        transaction.commit();
    }

    private void highlightSelectedTab(TextView selectedTab) {
        // Reset all tabs
        all.setTextColor(ContextCompat.getColor(this, R.color.white));
        today.setTextColor(ContextCompat.getColor(this, R.color.white));
        completed.setTextColor(ContextCompat.getColor(this, R.color.white));

        // Highlight selected tab
        selectedTab.setTextColor(ContextCompat.getColor(this, R.color.purple_700));
    }

}