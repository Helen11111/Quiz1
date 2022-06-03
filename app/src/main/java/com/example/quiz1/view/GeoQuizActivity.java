package com.example.quiz1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz1.MainActivity;
import com.example.quiz1.R;
import com.example.quiz1.other.Constants;
import com.example.quiz1.other.Helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeoQuizActivity extends AppCompatActivity {

    private int currentQuestionIndex = 0;
    private TextView tvQuestion, tvQuestionNumber;
    private Button btnNext;
    private RadioGroup radioGroup;
    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    private List<String> questions;
    private int correctAnswer = 0;
    private Map<String, Map<String, Boolean>> questionAnswerMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_quiz);

        questionAnswerMap = (Map<String, Map<String, Boolean>>) Helper.getRandomGeoQuestions(Constants.QUESTIONS_COUNT);
        questions = new ArrayList<>(questionAnswerMap.keySet());

        tvQuestion = findViewById(R.id.tvGeo_question);
        radioGroup = findViewById(R.id.radioGroupGeo);
        radioButton1 = findViewById(R.id.radioBtn1);
        radioButton2 = findViewById(R.id.radioBtn2);
        radioButton3 = findViewById(R.id.radioBtn3);
        radioButton4 = findViewById(R.id.radioBtn4);

        tvQuestionNumber = findViewById(R.id.tvCurrentQuestionGeo);
        btnNext = findViewById(R.id.btnNextGeo);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                boolean answer = questionAnswerMap.get(questions.get(currentQuestionIndex)).get(radioButton.getText());

                if (answer) {
                    correctAnswer++;
                }

                currentQuestionIndex++;

                if (btnNext.getText().equals("Next")) {
                    diplayNextQuestions();
                }
                else {
                    Intent intent = new Intent(GeoQuizActivity.this, FinalResultActivity.class);
                    intent.putExtra(Constants.SUBJECT, "География");
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
        setAnswersToRadioButton();
        tvQuestion.setText(questions.get(currentQuestionIndex));
        tvQuestionNumber.setText("Номер вопроса : " + (currentQuestionIndex + 1));

        if (currentQuestionIndex == Constants.QUESTIONS_COUNT - 1) {
            btnNext.setText("ФИНИШ");
        }
    }


    private void displayData() {
        tvQuestion.setText(questions.get(currentQuestionIndex));
        tvQuestionNumber.setText("Номер вопроса : " + (currentQuestionIndex + 1));
        setAnswersToRadioButton();
    }

    private void setAnswersToRadioButton() {
        ArrayList<String> questionKey = new ArrayList<>(questionAnswerMap.get(questions.get(currentQuestionIndex)).keySet());

        radioButton1.setText(questionKey.get(0));
        radioButton2.setText(questionKey.get(1));
        radioButton3.setText(questionKey.get(2));
        radioButton4.setText(questionKey.get(3));
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}