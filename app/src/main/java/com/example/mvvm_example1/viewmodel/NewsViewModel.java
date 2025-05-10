package com.example.mvvm_example1.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_example1.data.repository.NewsRepository;
import com.example.mvvm_example1.model.Article;
import com.example.mvvm_example1.model.NewsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {
    private MutableLiveData<List<Article>> newsArticle = new MutableLiveData<>();
    private NewsRepository repository;

    public NewsViewModel(){
        repository = new NewsRepository();
    }
    public LiveData<List<Article>> getNewsArticles() {
        return newsArticle;
    }

    public void  fetchNews(String query,String fromData,String sortBy,String apiKey){
        Call<NewsResponse> call = repository.getNews(query,fromData,sortBy,apiKey);
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if(response.isSuccessful() && response.body() != null){
                    newsArticle.setValue(response.body().getArticles());
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {

            }
        });
    }

}
