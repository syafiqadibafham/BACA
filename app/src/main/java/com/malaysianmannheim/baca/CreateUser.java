package com.malaysianmannheim.baca;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.jaeger.library.StatusBarUtil;
import com.malaysianmannheim.baca.ui.database.UserData;
import com.shawnlin.numberpicker.NumberPicker;

import java.io.ByteArrayOutputStream;

import static com.malaysianmannheim.baca.ui.database.UserData.SPData_profilePicture;
import static com.malaysianmannheim.baca.ui.database.UserData.product_image;


public class CreateUser extends AppCompatActivity {
    NumberPicker agePicker;
    EditText usernameEditText;
    Button nextCreateUserButton;
    ImageView userImage;
    public int age;
    UserData userData;
    BitmapDrawable bitmapDrawable;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        StatusBarUtil.setTransparent(this);
        userImage = (ImageView) findViewById(R.id.userImageView);
        String userGender = getIntent().getStringExtra("gender");

        if(userGender.equals("girl")){
            userImage.setImageResource(R.drawable.ic_girl__1_);
        }
        else {
            userImage.setImageResource(R.drawable.ic_boy);
        }
        Drawable drawable = userImage.getDrawable();
        Bitmap newBmp = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(newBmp);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        userImage.setImageBitmap(newBmp);
        //---------set the image to bitmap
        product_image = newBmp;
        //__________create two method setDefaults() and getDefaults()
        //setDefaults(SPData_profilePicture, photo, this);
        //getDefaults(SPData_profilePicture, this);


        agePicker = (NumberPicker) findViewById(R.id.numberPicker);
        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        nextCreateUserButton = (Button) findViewById(R.id.NextCreateUserbutton);
        agePicker.setMinValue(1);
        agePicker.setValue(1);

        agePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                age = newVal;
            }
        });

        //save user data and to home screen
        nextCreateUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = usernameEditText.getText().toString();
                String age = String.valueOf(agePicker.getValue());
                String gender = userGender;
                //____________convert image to string
                String photo = "";
                //BitMapToString(product_image)"";

                String username = "";
                String password = "";
                UserData userData = new UserData(CreateUser.this);
                userData.newUser(name, age, gender);
                //User newUser = new User(name, age, username, password);
                Intent intent = new Intent(CreateUser.this,MainActivity.class);
                intent.putExtra("gender", userGender);
                startActivity(intent);

            }
        });
    }
    /*private void setToAnotherImageView() {
        Drawable drawable = userImage.getDrawable();
        Bitmap newBmp = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(newBmp);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        userImage.setImageBitmap(newBmp);
    }

    public static void setDefaults(String str_key, String value, Context context)
    {
        SharedPreferences shre = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit=shre.edit();
        edit.putString(str_key, value);
        edit.apply();
    }*/

    public static String getDefaults(String key, Context context)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);

    }

    /*public static String BitMapToString(Bitmap bitmap)
    {
        ByteArrayOutputStream baos = new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte[] arr = baos.toByteArray();
        return Base64.encodeToString(arr, Base64.DEFAULT);
    }*/

}