package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.quiz1.view.HistoryActivity;
import com.example.quiz1.view.QuizActivity;
import com.example.quiz1.view.RuleActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvUserName;
    CardView cvStartQuiz, cvRule, cvHistory, cvLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUserName = findViewById(R.id.tvUserNameMenu);
        cvStartQuiz = findViewById(R.id.cvStartQuiz);
        cvRule = findViewById(R.id.cvRule);
        cvHistory = findViewById(R.id.cvHistory);
        cvLogout = findViewById(R.id.cvLogOut);

        cvStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QuizActivity.class));
            }
        });

        cvRule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RuleActivity.class));
            }
        });

        cvHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HistoryActivity.class));
            }
        });

        cvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}