package com.malaysianmannheim.baca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jaeger.library.StatusBarUtil;
import com.malaysianmannheim.baca.adapter.Castle1Adapter;
import com.malaysianmannheim.baca.castle1.crown1FITB;
import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar;

public class Castle1Activity extends AppCompatActivity {
    ImageView backButton, castle1Fg;
    Animation animCastle, animTransition;
    RelativeLayout relativeCastle1;
    ViewPager2 viewPager;
    RoundedHorizontalProgressBar progressBar;
    Castle1Adapter adapter;
    int list[],nameCrown[], listBackground[], listProgressColor[];
    float percentCrown1;

    //List<Castle1Crown> listCrown = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_castle1);
        StatusBarUtil.setTransparent(this);

        castle1Fg = findViewById(R.id.castle1Foreground);
        viewPager = findViewById(R.id.viewPagerCrown);
        relativeCastle1 = findViewById(R.id.background_crown);
        progressBar = findViewById(R.id.progressBar);
        //picture for each crown
        list = new int[8];
        list[0] = R.drawable.icon_crown1;
        list[1] = R.drawable.icon_crown2;
        list[2] = R.drawable.icon_crown3;
        list[3] = R.drawable.icon_crown4;
        list[4] = R.drawable.icon_crown5;
        list[5] = R.drawable.icon_crown6;
        list[6] = R.drawable.icon_crown7;
        list[7] = R.drawable.ape;
        //background list
        listBackground = new int[8];
        listBackground[0] = R.drawable.crown1background;
        listBackground[1] = R.drawable.crown2background;
        listBackground[2] = R.drawable.crown3background;
        listBackground[3] = R.drawable.crown4background;
        listBackground[4] = R.drawable.crown5background;
        listBackground[5] = R.drawable.crown6background;
        listBackground[6] = R.drawable.crown7background;
        listBackground[7] = R.drawable.crown8background;

        percentCrown1 = crown1FITB.marksCrown1game1*25;
        //store progress color
        listProgressColor = new int[8];
        listProgressColor[0] = (int) percentCrown1;
        listProgressColor[1] = 60;
        listProgressColor[2] = 50;
        listProgressColor[3] = 40;
        listProgressColor[4] = 20;
        listProgressColor[5] = 15;
        listProgressColor[6] = 10;
        listProgressColor[7] = 0;
        /*listProgressColor[0] = R.array.crown1progress;
        listProgressColor[1] = R.array.crown2progress;
        listProgressColor[2] = R.array.crown3progress;
        listProgressColor[3] = R.array.crown4progress;
        listProgressColor[4] = R.array.crown5progress;
        listProgressColor[5] = R.array.crown6progress;
        listProgressColor[6] = R.array.crown7progress;
        listProgressColor[7] = R.array.crown8progress;*/
        //roundCornerProgressBar.setProgressColor(listProgressColor[2]);

        //name for each crown
        nameCrown = new int[8];
        nameCrown[0] = R.string.Crown1Title;
        nameCrown[1] = R.string.Crown2Title;
        nameCrown[2] = R.string.Crown3Title;
        nameCrown[3] = R.string.Crown4Title;
        nameCrown[4] = R.string.Crown5Title;
        nameCrown[5] = R.string.Crown6Title;
        nameCrown[6] = R.string.Crown7Title;
        nameCrown[7] = R.string.Crown8Title;
        //store each array
        adapter = new Castle1Adapter(list, nameCrown, listBackground, listProgressColor);
        viewPager.setAdapter(adapter);
        viewPager.setClipToPadding(false);
        viewPager.setClipChildren(false);
        viewPager.setOffscreenPageLimit(2);

        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float a = 1-Math.abs(position);
                page.setScaleY(0.85f+ a*0.15f);
                //page.setScaleX(0.85f+ a*0.15f);
            }
        });

        viewPager.setPageTransformer(transformer);


        animCastle = AnimationUtils.loadAnimation(this, R.anim.castle_move);
        animTransition = AnimationUtils.loadAnimation(this, R.anim.transition);


        //open Home activity
        backButton = (ImageView) findViewById(R.id.backButtonImageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Castle1Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        
    }



    /*private void initData() {
        listCrown.add(new Castle1Crown("crown 1","40%",R.drawable.crown1background,R.drawable.icon_crown1, R.color.white));
        listCrown.add(new Castle1Crown("crown 2","30%",R.drawable.crown2background,R.drawable.icon_crown2, R.color.white));
        listCrown.add(new Castle1Crown("crown 3","28%",R.drawable.crown3background,R.drawable.icon_crown3, R.color.white));
        listCrown.add(new Castle1Crown("crown 4","15%",R.drawable.crown4background,R.drawable.icon_crown4, R.color.white));
        listCrown.add(new Castle1Crown("crown 5","10%",R.drawable.crown5background,R.drawable.icon_crown5, R.color.white));
        listCrown.add(new Castle1Crown("crown 6","07%",R.drawable.crown6background,R.drawable.icon_crown6, R.color.white));
        listCrown.add(new Castle1Crown("crown 7","06%",R.drawable.crown7background,R.drawable.icon_crown7, R.color.white));
        listCrown.add(new Castle1Crown("crown 8","0%",R.drawable.crown8background,R.drawable.icon_crown2, R.color.white));


    }*/
}