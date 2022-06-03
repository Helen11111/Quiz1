package com.example.quiz1.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quiz1.MainActivity;
import com.example.quiz1.R;
import com.example.quiz1.controller.AuthController;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class RegisterActivity extends AppCompatActivity {

    EditText etUserName, etEmail, etPassword;
    Button btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.Theme_Quiz1);

        AuthController authController = new AuthController();
        if (authController.isRegistered()) {
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
        }

        setContentView(R.layout.activity_register);

        etUserName = findViewById(R.id.etUserName2);
        etEmail = findViewById(R.id.etEmail2);
        etPassword = findViewById(R.id.etPassword2);
        btnRegister = findViewById(R.id.btnCreateUser);



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUserName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                authController.registerNewUser(email, password, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                            Toast.makeText(RegisterActivity.this, authController
                                    .getUser().getEmail(), Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}