package com.example.quiz1.other;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Helper {

    public static Map<String, String> getMathQuestion() {
        HashMap<String, String> questions = new HashMap<>();
        questions.put("1+1","2");
        questions.put("2+2","4");
        questions.put("3+3","6");
        questions.put("4+4","8");
        questions.put("5+5","10");
        questions.put("6+6","12");
        questions.put("7+7","14");
        questions.put("8+8","16");
        questions.put("9+9","18");
        questions.put("10+10","20");
        questions.put("11+11","22");
        questions.put("12+12","24");
        questions.put("13+13","26");
        questions.put("14+14","28");
        questions.put("15+15","30");

        return questions;
    }

    public static Map<String, String> getRandomMathQuestions(int size) {
        HashMap<String, String> questionsMap = new HashMap<>();
        Map<String, String> originalQuestion = getMathQuestion();
        int originalSize = originalQuestion.size();
        ArrayList<String> keyList = new ArrayList<String>(originalQuestion.keySet());

        while(questionsMap.size() <= size) {
            Random random = new Random();
            int randomNumber = random.nextInt(originalSize);
            String question = keyList.get(randomNumber);
            if (!questionsMap.containsKey(question)) {
                questionsMap.put(question, originalQuestion.get(question));
            }
        }

        return questionsMap;
    }


    public static Map<String, Map<String, Boolean>> getGeoQuestions() {
        HashMap<String, Map<String, Boolean>> questions = new HashMap<>();

        HashMap<String, Boolean> answer1 = new HashMap<>();
        answer1.put("Южная Америка", true);
        answer1.put("Северная Америка", false);
        answer1.put("Африка", false);
        answer1.put("Азия", false);
        questions.put("Где находится Бразилия?", answer1);

        HashMap<String, Boolean> answer2 = new HashMap<>();
        answer2.put("Австралия", false);
        answer2.put("Канада", false);
        answer2.put("США", false);
        answer2.put("Россия", true);
        questions.put("Какая страна самая большая в мире?", answer2);


        HashMap<String, Boolean> answer3 = new HashMap<>();
        answer3.put("Польша", false);
        answer3.put("США", true);
        answer3.put("Япония", false);
        answer3.put("Австралия", false);
        questions.put("В какой стране находится статуя Свободы?", answer3);

        HashMap<String, Boolean> answer4 = new HashMap<>();
        answer4.put("Исток", false);
        answer4.put("Русло", true);
        answer4.put("Половодье", false);
        answer4.put("Устье", false);
        questions.put("Как называется место, где река впадает в другую реку, море или озеро?", answer4);

        HashMap<String, Boolean> answer5 = new HashMap<>();
        answer5.put("Байкал", false);
        answer5.put("Селигер", true);
        answer5.put("Ладожское", false);
        answer5.put("Виктория", false);
        questions.put("В это озеро нашей страны впадает множество рек, а вытекает из него только одна — Ангара.", answer5);

        HashMap<String, Boolean> answer6 = new HashMap<>();
        answer6.put("Египет", false);
        answer6.put("США", true);
        answer6.put("Индия", false);
        answer6.put("Украина", false);
        questions.put("Столица какой страны расположена на реке Нил?", answer6);

        HashMap<String, Boolean> answer7 = new HashMap<>();
        answer7.put("Италия", false);
        answer7.put("СТурция", true);
        answer7.put("Япония", false);
        answer7.put("Греция", false);
        questions.put("Какая страна является родиной Олимпийских игр?", answer7);

        HashMap<String, Boolean> answer8 = new HashMap<>();
        answer8.put("Ливия", false);
        answer8.put("Ливан", true);
        answer8.put("Боливия", false);
        answer8.put("Болгария", false);
        questions.put("На флаге какой страны изображён кедр?", answer8);

        HashMap<String, Boolean> answer9 = new HashMap<>();
        answer9.put("Днепр", false);
        answer9.put("Петер", true);
        answer9.put("Нева", false);
        answer9.put("Сена", false);
        questions.put("На какой реке стоит город Санкт-Петербург?", answer9);

        return questions;
    }

    public static Map<String, Map<String, Boolean>> getRandomGeoQuestions(int size) {
        Map<String, Map<String, Boolean>> questionsMap = new HashMap<>();
        Map<String, Map<String, Boolean>> originalQuestion = getGeoQuestions();
        int originalSize = originalQuestion.size();
        ArrayList<String> keyList = new ArrayList<String>(originalQuestion.keySet());

        while(questionsMap.size() <= size) {
            Random random = new Random();
            int randomNumber = random.nextInt(originalSize);
            String question = keyList.get(randomNumber);
            if (!questionsMap.containsKey(question)) {
                questionsMap.put(question, originalQuestion.get(question));
            }
        }

        return questionsMap;
    }




}
