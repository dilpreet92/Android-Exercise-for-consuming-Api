package com.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.test.api.ApiClient;
import com.test.helpers.ToastHelper;
import com.test.models.User;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class SignIn extends ActionBarActivity {

    private Button signInButton;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getElements();
        setListeners();
        showMeals();
    }

    @Override
    public void onBackPressed() {}

    public void setListeners() {
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verify()) {
                    trylogin();
                }
            }
        });
    }

    public void trylogin() {
        ApiClient.getInstance().getApiService().login(email.getText().toString().trim(), password.getText().toString().trim(), new Callback<User>() {
            @Override
            public void success(User user, Response response) {
                SharedPreferencesHelper.saveUser(user);
                ToastHelper.showMessage(SignIn.this, "Successfully signed in");
                showMeals();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("error", error.toString());
                ToastHelper.showMessage(SignIn.this, "Not able to sign in");
            }
        });
    }

    public void showMeals() {
        if(SharedPreferencesHelper.isUserAvailable()) {
            Intent intent = new Intent(this, Meals.class);
            startActivity(intent);
        }
    }

    public boolean verify(){
        if (email.getText().toString().trim().equals("")) {
            email.setFocusable(true);
            Toast.makeText(this, "Email cannot be blank", Toast.LENGTH_SHORT).show();
            return false;
        } else if (password.getText().toString().trim().equals("")) {
            password.setFocusable(true);
            Toast.makeText(this, "Password cannot be blank", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    public void getElements() {
        signInButton = (Button)findViewById(R.id.signInButton);
        email = (EditText)findViewById(R.id.emailText);
        password = (EditText)findViewById(R.id.passwordText);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sign_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
