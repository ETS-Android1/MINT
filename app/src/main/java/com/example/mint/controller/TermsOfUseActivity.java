package com.example.mint.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mint.R;
import com.example.mint.model.PreferencesSize;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

/**
 * Terms of use activity, which launches the terms of use for this application.
 * It can be accessed in parameters/settings activity
 */
public class TermsOfUseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String sizePolice = PreferencesSize.getSize("police", TermsOfUseActivity.this);
        if (sizePolice.equals("big")) {
            setContentView(R.layout.activity_terms_of_use_big);
        } else {
            setContentView(R.layout.activity_terms_of_use);
        }
    }

    /**
     * Methods which returns to the previous activity, which is Settings Activity.
     *
     * @param view
     */
    public void onClickBackButton(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);

    }
}