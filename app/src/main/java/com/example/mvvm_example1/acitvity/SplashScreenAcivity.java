package com.example.mvvm_example1.acitvity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.mvvm_example1.MainActivity;
import com.example.mvvm_example11.R;

public class SplashScreenAcivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        LottieAnimationView animationView = findViewById(R.id.animation);
        animationView.setAnimation("write-list.json");
        animationView.playAnimation();

        new Handler().postDelayed(()->{
           startActivity(new Intent(SplashScreenAcivity.this, MainActivity.class));
        },5000);
    }
}
