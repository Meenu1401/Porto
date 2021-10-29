package com.example.myapplication.ui;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.myapplication.Porto;

public class AppPreference {

    public static final String PASSWORD = "password";
    public static final String USER_NAME = "username";

    private static AppPreference mInstance;

    private final SharedPreferences sharedPref;
    public AppPreference() {
        String PREF_NAME = "pref";
        sharedPref = Porto.getAppContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static AppPreference getInstance() {
        if (mInstance == null)
            mInstance = new AppPreference();

        return mInstance;
    }


    public void setString(String key, String val) {
        SharedPreferences.Editor mEditor = sharedPref.edit();
        mEditor.putString(key, val);
        mEditor.apply();
    }

    public String getString(String key){
        return sharedPref.getString(key, "");
    }

}
