package com.malaysianmannheim.baca.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.jaeger.library.StatusBarUtil;
import com.malaysianmannheim.baca.GenderSelection;
import com.malaysianmannheim.baca.MainActivity;
import com.malaysianmannheim.baca.R;
import com.malaysianmannheim.baca.ui.database.UserData;

import java.util.HashMap;

public class SplashActivity extends AppCompatActivity {
    ImageView textSplash;
    UserData userData;
    private static int SPLASH_Screen = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        StatusBarUtil.setTransparent(this);
        userData = new UserData(this);
        HashMap<String, String> userDetails = userData.getUsersDetailFromUserData();
        String name = userDetails.get(UserData.SPData_Name);
        textSplash = (ImageView) findViewById(R.id.splashImageView);
        textSplash.animate().translationX(200).setDuration(800).setStartDelay(2000);
        textSplash.animate().alpha(1).setDuration(400).setStartDelay(2000);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                if(name == null){
                Intent intent = new Intent(SplashActivity.this, GenderSelection.class);
                startActivity(intent);
                finish();}
                else{
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },SPLASH_Screen);
    }
}