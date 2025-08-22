package com.example.mvvm_example1.acivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mvvm_example1.data.repository.LoginRepository;
import com.example.mvvm_example1.model.LoginResponse;
import com.example.mvvm_example11.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText passwordTxt,emailTxt;
    LoginRepository loginRepository;
    Button loginBtn;
    String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        emailTxt = findViewById(R.id.email);
        passwordTxt = findViewById(R.id.password);
        loginBtn = findViewById(R.id.btnLogin);

        loginBtn.setOnClickListener(this);
         loginRepository = new LoginRepository();

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnLogin){
            email = emailTxt.getText().toString().trim();
            password = passwordTxt.getText().toString().trim();
            loginRepository.Login(email, password, new LoginRepository.LoginCallBack() {
                @Override
                public void onSucess(LoginResponse response) {
                    Toast.makeText(LoginActivity.this, response.getMessage() + " : " + response.getUsername(), Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(String erroMessage) {
                    Toast.makeText(LoginActivity.this, "Error:eee " + erroMessage, Toast.LENGTH_LONG).show();
                    Log.d("loginBtn", erroMessage);
                }
            });
        }
    }
}