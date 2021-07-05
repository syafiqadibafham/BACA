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

public class crown2 extends AppCompatActivity {
    ImageView castle1Button, itemCrown2ImgV, nextButtonImgV;
    TextView itemCrown2TextV, letterCrown2TextV;
    String listItemText[], listLetter[];
    ArrayList<Integer> imgArr = new ArrayList<Integer>();
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crown2);
        StatusBarUtil.setTransparent(this);

        //back to Castle 1 activity
        castle1Button = (ImageView) findViewById(R.id.castle1ButtonImageView);
        castle1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(crown2.this, Castle1Activity.class);
                startActivity(intent);
            }
        });

        //listItemText = "ape";
        //item name crown 1
        listItemText = new String[4];
        listItemText[0] = "eye";
        listItemText[1] = "finger";
        listItemText[2] = "gum";
        listItemText[3] = "head";
        //list image item crown 1
        listLetter = new String[4];
        listLetter[0] = "Ee";
        listLetter[1] = "Ff";
        listLetter[2] = "Gg";
        listLetter[3] = "Hh";
        //list item image
        imgArr.add(R.drawable.eye);
        imgArr.add(R.drawable.finger);
        imgArr.add(R.drawable.gum);
        imgArr.add(R.drawable.head);

        x = 0;

        //set Letter appearance
        letterCrown2TextV = findViewById(R.id.letterCrown2);
        final SpannableStringBuilder sbLetter = new SpannableStringBuilder(listLetter[x]);
        letterCrown2TextV.setText(sbLetter);

        //set text appearance
        itemCrown2TextV = findViewById(R.id.crown2ItemTextView);
        final SpannableStringBuilder sb = new SpannableStringBuilder(listItemText[x]);
        sb.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make first characters red
        sb.setSpan(new UnderlineSpan(), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make last 1 characters underline
        itemCrown2TextV.setText(sb);

        //set image
        itemCrown2ImgV = findViewById(R.id.itemCrown2ImageView);
        itemCrown2ImgV.setImageResource(imgArr.get(x));

        nextButtonImgV = findViewById(R.id.nextButtonImgView);
        nextButtonImgV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //change name item
                if (x<3) {
                    x+=1;
                    itemCrown2ImgV.setImageResource(imgArr.get(x));
                    final SpannableStringBuilder sbLetter = new SpannableStringBuilder(listLetter[x]);
                    letterCrown2TextV.setText(sbLetter);
                    final SpannableStringBuilder sb = new SpannableStringBuilder(listItemText[x]);
                    sb.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make first characters red
                    sb.setSpan(new UnderlineSpan(), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make last 1 characters underline
                    itemCrown2TextV.setText(sb);
                }
                else{
                    x=0;
                    Intent intent = new Intent(crown2.this, crown2WAM.class);
                    startActivity(intent);
                }

            }
        });


    }

}