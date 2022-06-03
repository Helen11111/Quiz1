package com.example.quiz1.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.quiz1.MainActivity;
import com.example.quiz1.R;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView tvAllPoonts, tvAllQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        recyclerView = findViewById(R.id.rvHistory);
        tvAllPoonts = findViewById(R.id.tvAllPoints);
        tvAllQuestion = findViewById(R.id.tvAllQuestions);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}