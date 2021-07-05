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

public class crown6 extends AppCompatActivity {

    ImageView castle1Button, itemCrown6ImgV, nextButtonImgV;
    TextView itemCrown6TextV, letterCrown6TextV;
    String listItemText[], listLetter[];
    ArrayList<Integer> imgArr = new ArrayList<Integer>();
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crown6);
        StatusBarUtil.setTransparent(this);

        //back to Castle 1 activity
        castle1Button = (ImageView) findViewById(R.id.castle1ButtonImageView);
        castle1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(crown6.this, Castle1Activity.class);
                startActivity(intent);
            }
        });

        //listItemText = "ape";
        //item name crown 1
        listItemText = new String[4];
        listItemText[0] = "ukulele";
        listItemText[1] = "violin";
        listItemText[2] = "whistle";
        listItemText[3] = "xylophone";
        //list image item crown 1
        listLetter = new String[4];
        listLetter[0] = "Uu";
        listLetter[1] = "Vv";
        listLetter[2] = "Ww";
        listLetter[3] = "Xx";
        //list item image
        imgArr.add(R.drawable.ukulele);
        imgArr.add(R.drawable.violin);
        imgArr.add(R.drawable.whistle);
        imgArr.add(R.drawable.xylophone);

        x = 0;

        //set Letter appearance
        letterCrown6TextV = findViewById(R.id.letterCrown6);
        final SpannableStringBuilder sbLetter = new SpannableStringBuilder(listLetter[x]);
        letterCrown6TextV.setText(sbLetter);

        //set text appearance
        itemCrown6TextV = findViewById(R.id.crown6ItemTextView);
        final SpannableStringBuilder sb = new SpannableStringBuilder(listItemText[x]);
        sb.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make first characters red
        sb.setSpan(new UnderlineSpan(), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make last 1 characters underline
        itemCrown6TextV.setText(sb);

        //set image
        itemCrown6ImgV = findViewById(R.id.itemCrown6ImageView);
        itemCrown6ImgV.setImageResource(imgArr.get(x));

        nextButtonImgV = findViewById(R.id.nextButtonImgView);
        nextButtonImgV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //change name item
                if (x<3) {
                    x+=1;
                    itemCrown6ImgV.setImageResource(imgArr.get(x));
                    final SpannableStringBuilder sbLetter = new SpannableStringBuilder(listLetter[x]);
                    letterCrown6TextV.setText(sbLetter);
                    final SpannableStringBuilder sb = new SpannableStringBuilder(listItemText[x]);
                    sb.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make first characters red
                    sb.setSpan(new UnderlineSpan(), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make last 1 characters underline
                    itemCrown6TextV.setText(sb);
                }
                else{
                    x=0;
                    Intent intent = new Intent(crown6.this, Castle1Activity.class);
                    startActivity(intent);
                }

            }
        });


    }

}