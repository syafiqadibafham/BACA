package com.malaysianmannheim.baca.castle1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.malaysianmannheim.baca.Castle1Activity;
import com.malaysianmannheim.baca.R;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class crown2WAM extends AppCompatActivity {
    ImageView castle1Button, moleImgV, startBtn, nextBtn, tryAgainBtn;
    ImageView listMole[];
    TextView listItemWAMTxtView[], timerTxtV, marksTxtV, finalScoreTxtV;
    ArrayList<Integer> moleImgVArr = new ArrayList<Integer>();
    RelativeLayout startLayout, resultLayout;
    String markString;
    int marksCrown2game2;
    private CountDownTimer countDownTimer;
    private Timer timer;
    private TimerTask timerTask;
    private long timeLeftInMilliseconds = 60000; //1mins


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crown2wam);
        StatusBarUtil.setTransparent(this);

        //back to Castle 1 activity
        castle1Button = (ImageView) findViewById(R.id.castle1ButtonImageView);
        castle1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(crown2WAM.this, Castle1Activity.class);
                startActivity(intent);
            }
        });
        timerTxtV = findViewById(R.id.timer);
        marksTxtV = findViewById(R.id.scoreTxtView);
        finalScoreTxtV = findViewById(R.id.markTextView);
        startBtn = findViewById(R.id.startButton2ImgView);
        nextBtn = findViewById(R.id.nextButton2ImgView);
        tryAgainBtn = findViewById(R.id.tryAgainButtonImageView);
        startLayout = findViewById(R.id.startLayout);
        resultLayout = findViewById(R.id.resultLayout);

        //list 7 mole&hole image
        moleImgVArr.add(R.drawable.mole);
        moleImgVArr.add(R.drawable.hole);
        moleImgVArr.add(R.drawable.hole);
        moleImgVArr.add(R.drawable.hole);
        moleImgVArr.add(R.drawable.mole);
        moleImgVArr.add(R.drawable.hole);
        moleImgVArr.add(R.drawable.mole);

        //list mole Img View
        listMole = new ImageView[7];
        listMole[0] = findViewById(R.id.moleImageV0);
        listMole[1] = findViewById(R.id.moleImageV1);
        listMole[2] = findViewById(R.id.moleImageV2);
        listMole[3] = findViewById(R.id.moleImageV3);
        listMole[4] = findViewById(R.id.moleImageV4);
        listMole[5] = findViewById(R.id.moleImageV5);
        listMole[6] = findViewById(R.id.moleImageV6);

        //list item Txt view
        listItemWAMTxtView = new TextView[7];
        listItemWAMTxtView[0] = findViewById(R.id.moleItem0crown2TxtView);
        listItemWAMTxtView[1] = findViewById(R.id.moleItem1crown2TxtView);
        listItemWAMTxtView[2] = findViewById(R.id.moleItem2crown2TxtView);
        listItemWAMTxtView[3] = findViewById(R.id.moleItem3crown2TxtView);
        listItemWAMTxtView[4] = findViewById(R.id.moleItem4crown2TxtView);
        listItemWAMTxtView[5] = findViewById(R.id.moleItem5crown2TxtView);
        listItemWAMTxtView[6] = findViewById(R.id.moleItem6crown2TxtView);


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLayout.setVisibility(View.INVISIBLE);
                startTimer();

                for (int i = 0; i <7;i++){

                    //moleImgV.setImageResource(moleImgVArr.get(i));
                    int finalI = i;
                    listMole[i].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listMole[finalI].setImageResource(R.drawable.hole);
                            listItemWAMTxtView[finalI].setVisibility(View.INVISIBLE);
                            marksCrown2game2 += 1;
                        }
                    });
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(crown2WAM.this, Castle1Activity.class);
                startActivity(intent);

            }
        });

        tryAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(crown2WAM.this, crown2WAM.class);
                startActivity(intent);

            }
        });


    }


    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override


            public void onTick(long millisUntilFinished) {
                timeLeftInMilliseconds = millisUntilFinished;
                final Random random = new Random();
                int irand = random.nextInt(7 );
                listMole[irand].setImageResource(R.drawable.mole);
                listItemWAMTxtView[irand].setVisibility(View.VISIBLE);
                markString = String.valueOf(marksCrown2game2);
                marksTxtV.setText(markString);
                updateTimer();
            }

            @Override
            public void onFinish() {
                resultLayout.setVisibility(View.VISIBLE);
                timerTxtV.setVisibility(View.INVISIBLE);
                castle1Button.setVisibility(View.INVISIBLE);
                finalScoreTxtV.setText(markString);
            }
        }.start();
    }

    public void updateTimer() {
       int seconds = (int) timeLeftInMilliseconds / 1000;
       String timeLeftTxt;
       timeLeftTxt = "Time Left : " + seconds + "s";
       timerTxtV.setText(timeLeftTxt);
    }


}

