package com.example.mvvm_example1.data.repository;

import com.example.mvvm_example1.data.remote.ApiService;
import com.example.mvvm_example1.data.remote.RetrofitHelper;
import com.example.mvvm_example1.model.NewsResponse;

import retrofit2.Call;


public class NewsRepository {
        private ApiService apiService;

        public NewsRepository() {
            apiService = RetrofitHelper.getClient().create(ApiService.class);
        }

        public Call<NewsResponse> getNews(String query, String fromDate, String sortBy, String apiKey) {
            return apiService.getNews(query, fromDate, sortBy, apiKey);
        }
    }

