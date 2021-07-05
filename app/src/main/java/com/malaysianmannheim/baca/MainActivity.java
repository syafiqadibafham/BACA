package com.malaysianmannheim.baca;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.jaeger.library.StatusBarUtil;
import com.malaysianmannheim.baca.ui.dashboard.DashboardFragment;
import com.malaysianmannheim.baca.ui.database.UserData;
import com.yarolegovich.slidingrootnav.SlideGravity;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.Arrays;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
TextView forParentTextView;
Button userProfile;
ImageView castle1,userImage,homeTapImageView;
ChipNavigationBar navBar;
UserData userData;
Toolbar toolbar;

public static final String PRODUCT_PHOTO = "photo";
String str_bitmap;
private Bitmap bitmap;
private ImageView  imageView_photo;

public SlidingRootNav slidingRootNav;
Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setTransparent(this);

        userData = new UserData(this);
        HashMap<String, String> userDetails = userData.getUsersDetailFromUserData();
        userImage = (ImageView) findViewById(R.id.ProfilePicture);
        //girlImage = (ImageView) findViewById(R.id.girlProfilePicture);

        String gender = userDetails.get(UserData.SPData_Gender);
        if(gender.equals("girl")){
            userImage.setImageResource(R.drawable.ic_girl__1_);}
        else {
            userImage.setImageResource(R.drawable.ic_boy);
        }


        //--------get image form previous activity,here ProductActivity is my previous activity.
        //str_bitmap = CreateUser.getDefaults(PRODUCT_PHOTO, this);
        //-------------- decode the string to the bitmap
        //bitmap=decodeBase64(str_bitmap);
        //----------- finally set the this image to the Imageview.
        //imageView_photo.setImageBitmap(bitmap);


        navBar = findViewById(R.id.bottomNavigationView);
        navBar.setItemSelected(R.id.navigation_home,true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
        bottomMenu();

        //open for Parent activity
        forParentTextView = (TextView) findViewById(R.id.forParentTextView);
        forParentTextView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,ForParent.class);
            startActivity(intent);
        }
        });

        //sliding root navigation
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        slidingRootNav = new  SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withGravity(SlideGravity.RIGHT)
                .withRootViewScale(0.80f)
                .withRootViewElevation(25)
                .withSavedState(savedInstanceState)
                .withContentClickableWhenMenuOpened(false)
                .withMenuOpened(false)
                .withMenuLayout(R.layout.activity_drawer)
                .inject();
        //open user Profile
        userProfile = (Button) findViewById(R.id.userButton);
        String name = userDetails.get(UserData.SPData_Name);
        userProfile.setText(name);
        /*userProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Drawer.class);
                startActivity(intent);

            }
        });*/

    }

    /*private Bitmap decodeBase64(String input) {
            byte[] decodedByte = Base64.decode(input, 0);
            return BitmapFactory.decodeByteArray(decodedByte, 0,   decodedByte.length);
    }*/


    private void bottomMenu() {
        navBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment selectedFragment = null;
                switch (i){
                    case R.id.navigation_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.navigation_progress:
                        selectedFragment = new ProgressFragment();
                        break;
                    case R.id.navigation_setting:
                        selectedFragment = new SettingFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            }
        });
    }

    protected void onStart() {
        super.onStart();

    }


    /*private boolean authenticate(){
        return userData.getUserLoggedIn();
    }*/

}