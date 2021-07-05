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

public class crown4 extends AppCompatActivity {

    ImageView castle1Button, itemCrown4ImgV, nextButtonImgV;
    TextView itemCrown4TextV, letterCrown4TextV;
    String listItemText[], listLetter[];
    ArrayList<Integer> imgArr = new ArrayList<Integer>();
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crown4);
        StatusBarUtil.setTransparent(this);

        //back to Castle 1 activity
        castle1Button = (ImageView) findViewById(R.id.castle1ButtonImageView);
        castle1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(crown4.this, Castle1Activity.class);
                startActivity(intent);
            }
        });

        //listItemText = "ape";
        //item name crown 1
        listItemText = new String[4];
        listItemText[0] = "muffin";
        listItemText[1] = "nuts";
        listItemText[2] = "orange";
        listItemText[3] = "pizza";
        //list image item crown 1
        listLetter = new String[4];
        listLetter[0] = "Mm";
        listLetter[1] = "Nn";
        listLetter[2] = "Oo";
        listLetter[3] = "Pp";
        //list item image
        imgArr.add(R.drawable.muffin);
        imgArr.add(R.drawable.nut);
        imgArr.add(R.drawable.orange);
        imgArr.add(R.drawable.pizza);

        x = 0;

        //set Letter appearance
        letterCrown4TextV = findViewById(R.id.letterCrown4);
        final SpannableStringBuilder sbLetter = new SpannableStringBuilder(listLetter[x]);
        letterCrown4TextV.setText(sbLetter);

        //set text appearance
        itemCrown4TextV = findViewById(R.id.crown4ItemTextView);
        final SpannableStringBuilder sb = new SpannableStringBuilder(listItemText[x]);
        sb.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make first characters red
        sb.setSpan(new UnderlineSpan(), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make last 1 characters underline
        itemCrown4TextV.setText(sb);

        //set image
        itemCrown4ImgV = findViewById(R.id.itemCrown4ImageView);
        itemCrown4ImgV.setImageResource(imgArr.get(x));

        nextButtonImgV = findViewById(R.id.nextButtonImgView);
        nextButtonImgV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //change name item
                if (x<3) {
                    x+=1;
                    itemCrown4ImgV.setImageResource(imgArr.get(x));
                    final SpannableStringBuilder sbLetter = new SpannableStringBuilder(listLetter[x]);
                    letterCrown4TextV.setText(sbLetter);
                    final SpannableStringBuilder sb = new SpannableStringBuilder(listItemText[x]);
                    sb.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make first characters red
                    sb.setSpan(new UnderlineSpan(), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make last 1 characters underline
                    itemCrown4TextV.setText(sb);
                }
                else{
                    x=0;
                    Intent intent = new Intent(crown4.this, Castle1Activity.class);
                    startActivity(intent);
                }

            }
        });


    }

}