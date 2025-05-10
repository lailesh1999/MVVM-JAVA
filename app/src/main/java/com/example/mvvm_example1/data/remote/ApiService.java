package com.example.mvvm_example1.data.remote;

import com.example.mvvm_example1.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("everything")
    Call<NewsResponse> getNews(
            @Query("q") String query,
            @Query("from") String fromDate,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String apiKey
    );


}
