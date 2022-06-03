package com.example.quiz1.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.quiz1.R;

public class ViewPagerAdapter extends PagerAdapter {
    Context context;

    ImageView rule_slide;
    TextView tvRule_slide;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_rules, container, false);

        rule_slide = view.findViewById(R.id.rule_slide);
        tvRule_slide = view.findViewById(R.id.tvRule_slide);


        switch (position) {
            case 0:
                rule_slide.setImageResource(R.drawable.history1);
                tvRule_slide.setText(R.string.tvRule_slide1);
                break;
            case 1:
                rule_slide.setImageResource(R.drawable.history2);
                tvRule_slide.setText(R.string.tvRule_slide2);
                break;
            case 2:
                rule_slide.setImageResource(R.drawable.history3);
                tvRule_slide.setText(R.string.tvRule_slide3);
                break;
            case 3:
                rule_slide.setImageResource(R.drawable.history4);
                tvRule_slide.setText(R.string.tvRule_slide4);
                break;
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
