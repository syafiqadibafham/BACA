package com.malaysianmannheim.baca.ui.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.SpannableString;

import java.util.HashMap;

public class UserData {
    SharedPreferences userLocalDatabase;
    SharedPreferences.Editor spEditor;
    Context context;


    public static final String Is_Login = "IsLoggedIn";
    public static final String SPData_Name = "name";
    public static final String SPData_Gender = "gender";
    public static final String SPData_age = "age";
    public static final String SPData_profilePicture = "photo";
    public static Bitmap product_image;
    public static final String SPData_password = "password";

    public UserData(Context _context){
        context = _context;
        userLocalDatabase = _context.getSharedPreferences("userLoggedIn",Context.MODE_PRIVATE);
        spEditor = userLocalDatabase.edit();
        spEditor.apply();
    }

    public void newUser(String name, String age, String gender){
        spEditor.putBoolean(Is_Login, true);

        spEditor.putString(SPData_Name, name);
        spEditor.putString(SPData_age, age);
        spEditor.putString(SPData_Gender, gender);

        spEditor.commit();
    }

    public HashMap<String, String> getUsersDetailFromUserData(){
        HashMap<String, String> userData = new HashMap<>();

        userData.put(SPData_Name, userLocalDatabase.getString(SPData_Name, null));
        userData.put(SPData_age, userLocalDatabase.getString(SPData_age, null));
        userData.put(SPData_Gender, userLocalDatabase.getString(SPData_Gender, null));

        return userData;
    }

    public boolean checkLogin(){
        if(userLocalDatabase.getBoolean(Is_Login, false)){
            return true;
        }
        else
            return false;
    }

    public void clearUserData(){
        spEditor.clear();
        spEditor.apply();
    }
}
