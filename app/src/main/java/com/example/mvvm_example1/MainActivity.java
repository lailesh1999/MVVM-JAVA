package com.example.mvvm_example1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm_example1.adapter.NewsAdapter;
import com.example.mvvm_example1.viewmodel.NewsViewModel;
import com.example.mvvm_example11.R;

public class MainActivity extends AppCompatActivity {
    private NewsViewModel viewModel;
    private RecyclerView recyclerView;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}