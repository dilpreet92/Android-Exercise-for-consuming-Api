package com.test;

import android.content.SharedPreferences;
import android.util.Log;

import com.test.models.User;

/**
 * Created by vinsol on 4/6/15.
 */
public class SharedPreferencesHelper {
    public static final String PREF_USER = "prefs_user";

    public static SharedPreferences getSharedPreferences() {
        return Test.getSharedPreferences();
    }

    public static boolean isUserAvailable() {
        SharedPreferences sharedPreferences = getSharedPreferences();
        String json = sharedPreferences.getString(PREF_USER, "");
        Log.d("aaaaaaaa", json);
        if(json.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    public static void saveUser(User user) { saveString(PREF_USER, User.serialize(user)); }

    public static void logoutUser() { saveString(PREF_USER, ""); }

    private static void saveString(String key, String value) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putString(key, value);
        prefEditor.commit();
    }
}
