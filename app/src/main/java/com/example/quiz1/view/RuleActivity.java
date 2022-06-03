package com.example.quiz1.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.example.quiz1.MainActivity;
import com.example.quiz1.R;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

public class RuleActivity extends AppCompatActivity {

    public static ViewPager viewPager;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule);

        SpringDotsIndicator springDotsIndicator = findViewById(R.id.spring_dot_indicator);
        viewPager = findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
        springDotsIndicator.setViewPager(viewPager);


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}