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

public class crown7 extends AppCompatActivity {

    ImageView castle1Button, itemCrown7ImgV, nextButtonImgV;
    TextView itemCrown7TextV, letterCrown7TextV;
    String listItemText[], listLetter[];
    ArrayList<Integer> imgArr = new ArrayList<Integer>();
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crown7);
        StatusBarUtil.setTransparent(this);

        //back to Castle 1 activity
        castle1Button = (ImageView) findViewById(R.id.castle1ButtonImageView);
        castle1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(crown7.this, Castle1Activity.class);
                startActivity(intent);
            }
        });

        //listItemText = "ape";
        //item name crown 1
        listItemText = new String[2];
        listItemText[0] = "yarn";
        listItemText[1] = "zip";

        //list image item crown 1
        listLetter = new String[2];
        listLetter[0] = "Yy";
        listLetter[1] = "Zz";

        //list item image
        imgArr.add(R.drawable.yarn);
        imgArr.add(R.drawable.zip);

        x = 0;

        //set Letter appearance
        letterCrown7TextV = findViewById(R.id.letterCrown7);
        final SpannableStringBuilder sbLetter = new SpannableStringBuilder(listLetter[x]);
        letterCrown7TextV.setText(sbLetter);

        //set text appearance
        itemCrown7TextV = findViewById(R.id.crown7ItemTextView);
        final SpannableStringBuilder sb = new SpannableStringBuilder(listItemText[x]);
        sb.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make first characters red
        sb.setSpan(new UnderlineSpan(), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make last 1 characters underline
        itemCrown7TextV.setText(sb);

        //set image
        itemCrown7ImgV = findViewById(R.id.itemCrown7ImageView);
        itemCrown7ImgV.setImageResource(imgArr.get(x));

        nextButtonImgV = findViewById(R.id.nextButtonImgView);
        nextButtonImgV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //change name item
                if (x<1) {
                    x+=1;
                    itemCrown7ImgV.setImageResource(imgArr.get(x));
                    final SpannableStringBuilder sbLetter = new SpannableStringBuilder(listLetter[x]);
                    letterCrown7TextV.setText(sbLetter);
                    final SpannableStringBuilder sb = new SpannableStringBuilder(listItemText[x]);
                    sb.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make first characters red
                    sb.setSpan(new UnderlineSpan(), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make last 1 characters underline
                    itemCrown7TextV.setText(sb);
                }
                else{
                    x=0;
                    Intent intent = new Intent(crown7.this, Castle1Activity.class);
                    startActivity(intent);
                }

            }
        });


    }

}