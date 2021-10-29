package com.example.myapplication;

import android.app.Application;
import android.content.Context;

public class Porto extends Application {

    private static Porto instance;

        @Override
        public void onCreate() {
            super.onCreate();
            instance = this;
        }

    public static Context getAppContext() {
        return instance;
    }
}
