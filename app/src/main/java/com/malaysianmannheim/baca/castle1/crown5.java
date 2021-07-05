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

public class crown5 extends AppCompatActivity {

    ImageView castle1Button, itemCrown5ImgV, nextButtonImgV;
    TextView itemCrown5TextV, letterCrown5TextV;
    String listItemText[], listLetter[];
    ArrayList<Integer> imgArr = new ArrayList<Integer>();
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crown5);
        StatusBarUtil.setTransparent(this);

        //back to Castle 1 activity
        castle1Button = (ImageView) findViewById(R.id.castle1ButtonImageView);
        castle1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(crown5.this, Castle1Activity.class);
                startActivity(intent);
            }
        });

        //listItemText = "ape";
        //item name crown 1
        listItemText = new String[4];
        listItemText[0] = "queen";
        listItemText[1] = "robot";
        listItemText[2] = "snowman";
        listItemText[3] = "transformer";
        //list image item crown 1
        listLetter = new String[4];
        listLetter[0] = "Qq";
        listLetter[1] = "Rr";
        listLetter[2] = "Ss";
        listLetter[3] = "Tt";
        //list item image
        imgArr.add(R.drawable.queen);
        imgArr.add(R.drawable.robot);
        imgArr.add(R.drawable.snowman);
        imgArr.add(R.drawable.transformer);

        x = 0;

        //set Letter appearance
        letterCrown5TextV = findViewById(R.id.letterCrown5);
        final SpannableStringBuilder sbLetter = new SpannableStringBuilder(listLetter[x]);
        letterCrown5TextV.setText(sbLetter);

        //set text appearance
        itemCrown5TextV = findViewById(R.id.crown5ItemTextView);
        final SpannableStringBuilder sb = new SpannableStringBuilder(listItemText[x]);
        sb.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make first characters red
        sb.setSpan(new UnderlineSpan(), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make last 1 characters underline
        itemCrown5TextV.setText(sb);

        //set image
        itemCrown5ImgV = findViewById(R.id.itemCrown5ImageView);
        itemCrown5ImgV.setImageResource(imgArr.get(x));

        nextButtonImgV = findViewById(R.id.nextButtonImgView);
        nextButtonImgV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //change name item
                if (x<3) {
                    x+=1;
                    itemCrown5ImgV.setImageResource(imgArr.get(x));
                    final SpannableStringBuilder sbLetter = new SpannableStringBuilder(listLetter[x]);
                    letterCrown5TextV.setText(sbLetter);
                    final SpannableStringBuilder sb = new SpannableStringBuilder(listItemText[x]);
                    sb.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make first characters red
                    sb.setSpan(new UnderlineSpan(), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make last 1 characters underline
                    itemCrown5TextV.setText(sb);
                }
                else{
                    x=0;
                    Intent intent = new Intent(crown5.this, Castle1Activity.class);
                    startActivity(intent);
                }

            }
        });


    }

}