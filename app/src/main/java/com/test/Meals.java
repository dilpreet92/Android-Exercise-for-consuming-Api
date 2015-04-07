package com.test;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.test.api.ApiClient;
import com.test.helpers.ToastHelper;
import com.test.models.Meal;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class Meals extends ActionBarActivity {

    private ListView listView;
    private ArrayList<Meal> mealsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMeals();
        setContentView(R.layout.activity_meals);
    }

    @Override
    public void onBackPressed() {}


    public void getMeals() {
        ApiClient.getInstance().getApiService().getMeals(new Callback<ArrayList<Meal>>() {
            @Override
            public void success(ArrayList<Meal> meals, Response response) {
                mealsList = meals;
                showMeals(meals);
            }

            @Override
            public void failure(RetrofitError error) {
                ToastHelper.showMessage(Meals.this, "not able to retrieve meals");
            }
        });
    }

    public void showMeals(ArrayList<Meal> meals) {
        listView = (ListView) findViewById(R.id.mealsList);
        ArrayAdapter<Meal> adapter = new ArrayAdapter<Meal>(this, android.R.layout.simple_list_item_1, meals);
        listView.setAdapter(adapter);
        setListeners();
    }

    public void setListeners() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToastHelper.showMessage(Meals.this, "You have choosen " + mealsList.get(position).toString());
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_meals, menu);
        return true;
    }

    public void logout() {
        SharedPreferencesHelper.logoutUser();
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
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
        } else if (id == R.id.logout) {
            logout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
