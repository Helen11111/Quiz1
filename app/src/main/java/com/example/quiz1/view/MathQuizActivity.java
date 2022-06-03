package com.example.quiz1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz1.MainActivity;
import com.example.quiz1.R;
import com.example.quiz1.other.Constants;
import com.example.quiz1.other.Helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MathQuizActivity extends AppCompatActivity {

    private int currentQuestionIndex = 0;
    private TextView tvQuestion, tvQuestionNumber;
    private Button btnNext;
    private List<String> questions;
    private int correctAnswer = 0;
    private EditText etAnswer;
    private HashMap<String, String> questionAnswerMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_quiz);

        questionAnswerMap = (HashMap<String, String>) Helper.getRandomMathQuestions(Constants.QUESTIONS_COUNT);
        questions = new ArrayList<>(questionAnswerMap.keySet());

        tvQuestion = findViewById(R.id.tvMath_example);
        tvQuestionNumber = findViewById(R.id.tvCurrentQuestionMath);
        btnNext = findViewById(R.id.btnNextMath);
        etAnswer = findViewById(R.id.etMathQuiz);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = etAnswer.getText().toString();

                if (answer.isEmpty()) {
                    Toast.makeText(MathQuizActivity.this, "Заполните поле ответа", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (questionAnswerMap.get(questions.get(currentQuestionIndex)).equals(answer)) {
                    correctAnswer++;
                }

                currentQuestionIndex++;

                if (btnNext.getText().equals("Next")) {
                    diplayNextQuestions();
                }
                else {
                    Intent intent = new Intent(MathQuizActivity.this, FinalResultActivity.class);
                    //intent.putExtra(Constants.SUBJECT, "Математика");
                    intent.putExtra(Constants.CORRECT, correctAnswer);
                    intent.putExtra(Constants.INCORRECT, Constants.QUESTIONS_COUNT - correctAnswer);
                    startActivity(intent);
                    finish();

                }
            }
        });

        displayData();

    }

    private void diplayNextQuestions() {
        etAnswer.setText("");
        tvQuestion.setText(questions.get(currentQuestionIndex) + " = ?");
        tvQuestionNumber.setText("Номер вопроса : " + (currentQuestionIndex + 1));

        if (currentQuestionIndex == Constants.QUESTIONS_COUNT - 1) {
            btnNext.setText("ФИНИШ");
        }
    }


    private void displayData() {
        tvQuestion.setText(questions.get(currentQuestionIndex) + " = ?");
        tvQuestionNumber.setText("Номер вопроса : " + (currentQuestionIndex + 1));
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}