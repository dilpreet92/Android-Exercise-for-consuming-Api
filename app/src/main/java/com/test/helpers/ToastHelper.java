package com.test.helpers;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by vinsol on 4/6/15.
 */
public class ToastHelper {

    public static void showMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
