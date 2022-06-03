package com.example.quiz1.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.quiz1.MainActivity;
import com.example.quiz1.R;
import com.example.quiz1.other.Constants;

public class QuizActivity extends AppCompatActivity {

    CardView cvMath, cvGeog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        cvMath = findViewById(R.id.cvQuizMath);
        cvGeog = findViewById(R.id.cvQuizGeog);

        cvMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, MathQuizActivity.class);
                intent.putExtra(Constants.SUBJECT, "Математика");
                startActivity(intent);
            }
        });


        cvGeog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, GeoQuizActivity.class);
                intent.putExtra(Constants.SUBJECT, "География");
                startActivity(intent);
            }
        });
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}