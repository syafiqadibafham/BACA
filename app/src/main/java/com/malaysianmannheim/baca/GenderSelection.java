package com.malaysianmannheim.baca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.malaysianmannheim.baca.ui.database.UserData;

import java.util.HashMap;


public class GenderSelection extends AppCompatActivity {
    private ImageView boyImageView, girlImageView,tickbutton1,tickbutton2;
    Button nextButton;
    UserData userData;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_selection);
        StatusBarUtil.setTransparent(this);


        boyImageView = (ImageView) findViewById(R.id.BoyimageView);
        girlImageView = (ImageView) findViewById(R.id.GirlimageView);
        tickbutton1 = (ImageView) findViewById(R.id.tickImageView);
        tickbutton2 = (ImageView) findViewById(R.id.tickImageView2);

            // select boy
        boyImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    tickbutton1.setVisibility(View.VISIBLE);
                    tickbutton2.setVisibility(View.INVISIBLE);

            }
        });

        //select girl
        girlImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tickbutton2.setVisibility(View.VISIBLE);
                tickbutton1.setVisibility(View.INVISIBLE);

                //if (tickbutton1.setVisibility(View.VISIBLE)) {
                //tickbutton2.setVisibility(View.VISIBLE);
                //tickbutton1.setVisibility(View.INVISIBLE);}
                //else{ tickbutton2.setVisibility(View.VISIBLE);}
            }
        });



        nextButton = (Button) findViewById(R.id.NextGenderbutton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tickbutton1.getVisibility() == View.VISIBLE){
                    gender = "boy";
                }
                else{
                    gender = "girl";
                }
                Intent intent = new Intent(GenderSelection.this,CreateUser.class);
                intent.putExtra("gender", gender);
                startActivity(intent);
            }
        });


    }
}