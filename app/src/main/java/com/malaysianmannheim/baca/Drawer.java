package com.malaysianmannheim.baca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.malaysianmannheim.baca.ui.database.UserData;

import java.util.HashMap;

public class Drawer extends AppCompatActivity {
    UserData userData;
    ImageView userImageDrawer;
    TextView username, ageTxtV, changeUser, editProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        StatusBarUtil.setTransparent(this);

        //call SharePreferences Data
        userData = new UserData(this);
        HashMap<String, String> userDetails = userData.getUsersDetailFromUserData();
        userImageDrawer = (ImageView) findViewById(R.id.ProfilePictureDrawer);
        String gender = userDetails.get(UserData.SPData_Gender);
        if(gender.equals("girl")){
            userImageDrawer.setImageResource(R.drawable.ic_girl__1_);}
        else {
            userImageDrawer.setImageResource(R.drawable.ic_boy);
        }
        username = (TextView) findViewById(R.id.username);
        ageTxtV = (TextView) findViewById(R.id.age);
        String name = userDetails.get(UserData.SPData_Name);
        String age = userDetails.get(UserData.SPData_age);
        username.setText(name);
        ageTxtV.setText(age + " Years Old");
        editProfile = (TextView) findViewById(R.id.editProfileTxtV);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Drawer.this,GenderSelection.class);
                startActivity(intent);
            }
        });
        changeUser = findViewById(R.id.changeProfileTxtV);
    }

    protected void onStart() {
        super.onStart();

    }
}