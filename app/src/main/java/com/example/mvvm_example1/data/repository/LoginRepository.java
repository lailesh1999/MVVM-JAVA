package com.example.mvvm_example1.data.repository;

import com.example.mvvm_example1.data.remote.ApiService;
import com.example.mvvm_example1.data.remote.RetrofitHelper;
import com.example.mvvm_example1.model.LoginResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {
    private ApiService apiService;

    public  LoginRepository(){
        apiService = RetrofitHelper.getClient().create(ApiService.class);
    }

    public void Login(String email,String password,LoginCallBack callBack){
        apiService.login(email,password).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful() && response.body() != null){
                    callBack.onSucess(response.body());
                }else {
                    try {
                        // ✅ Parse error body (401, 400, etc.)
                        String errorBody = response.errorBody().string();
                        JSONObject json = new JSONObject(errorBody);
                        String message = json.optString("message", "Unknown error");

                        callBack.onFailure(message);
                    } catch (Exception e) {
                        callBack.onFailure("Something went wrong");
                    }
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable throwable) {
                callBack.onFailure(throwable.getMessage());
            }
        });
    }

    public interface  LoginCallBack{
        void onSucess(LoginResponse response);
        void onFailure(String erroMessage);
    }
}
