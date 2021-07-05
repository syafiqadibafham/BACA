package com.malaysianmannheim.baca.castle1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.malaysianmannheim.baca.Castle1Activity;
import com.malaysianmannheim.baca.R;

import java.util.ArrayList;

public class crown1 extends AppCompatActivity {
ImageView castle1Button, itemCrown1ImgV, nextButtonImgV;
TextView itemCrown1TextV, letterCrown1TextV;
String listItemText[], listLetter[];
ArrayList<Integer> imgArr = new ArrayList<Integer>();
int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crown1);
        StatusBarUtil.setTransparent(this);

        //back to Castle 1 activity
        castle1Button = (ImageView) findViewById(R.id.castle1ButtonImageView);
        castle1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(crown1.this, Castle1Activity.class);
                startActivity(intent);
            }
        });

        //listItemText = "ape";
        //item name crown 1
        listItemText = new String[4];
        listItemText[0] = "ape";
        listItemText[1] = "bee";
        listItemText[2] = "cat";
        listItemText[3] = "dog";
        //list image item crown 1
        listLetter = new String[4];
        listLetter[0] = "Aa";
        listLetter[1] = "Bb";
        listLetter[2] = "Cc";
        listLetter[3] = "Dd";
        //list item image
        imgArr.add(R.drawable.ape);
        imgArr.add(R.drawable.bee);
        imgArr.add(R.drawable.cat);
        imgArr.add(R.drawable.dog);

        x = 0;

        //set Letter appearance
        letterCrown1TextV = findViewById(R.id.letterCrown1);
        final SpannableStringBuilder sbLetter = new SpannableStringBuilder(listLetter[x]);
        letterCrown1TextV.setText(sbLetter);

        //set text appearance
        itemCrown1TextV = findViewById(R.id.crown1ItemTextView);
        final SpannableStringBuilder sb = new SpannableStringBuilder(listItemText[x]);
        sb.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make first characters red
        sb.setSpan(new UnderlineSpan(), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make last 1 characters underline
        itemCrown1TextV.setText(sb);

        //set image
        itemCrown1ImgV = findViewById(R.id.itemCrown1ImageView);
        itemCrown1ImgV.setImageResource(imgArr.get(x));

        nextButtonImgV = findViewById(R.id.nextButtonImgView);
        nextButtonImgV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //change name item
                if (x<3) {
                    x+=1;
                    itemCrown1ImgV.setImageResource(imgArr.get(x));
                    final SpannableStringBuilder sbLetter = new SpannableStringBuilder(listLetter[x]);
                    letterCrown1TextV.setText(sbLetter);
                    final SpannableStringBuilder sb = new SpannableStringBuilder(listItemText[x]);
                    sb.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make first characters red
                    sb.setSpan(new UnderlineSpan(), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make last 1 characters underline
                    itemCrown1TextV.setText(sb);
                }
                else{
                    Intent intent = new Intent(crown1.this, crown1FITB.class);
                    startActivity(intent);
                }

            }
        });


    }

}