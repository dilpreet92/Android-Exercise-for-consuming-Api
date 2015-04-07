package com.test;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by vinsol on 4/6/15.
 */
public class Test extends Application {

    private final static String DEFAULT_PREFERENCES = "test";
    private static SharedPreferences sharedPreferences;
    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationContext = this;
        sharedPreferences = getSharedPreferences(DEFAULT_PREFERENCES, Context.MODE_PRIVATE);
    }

    public static SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public static SharedPreferences.Editor getSharedPreferencesEditor() {
        return sharedPreferences.edit();
    }

    public static Context getContext() {
        return applicationContext;
    }


}
