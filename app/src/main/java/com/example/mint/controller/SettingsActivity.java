package com.example.mint.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.mint.R;
import com.example.mint.model.PreferencesSize;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class SettingsActivity extends AppCompatActivity {
    SwitchCompat switchCompat;

    /**
     * This activity handles the various application settings (FAQ, language...)
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String sizePolice = PreferencesSize.getSize("police", SettingsActivity.this);

        if (sizePolice.equals("big")) {
            setContentView(R.layout.activity_settings_big);
        } else {
            setContentView(R.layout.activity_settings);
        }

        this.switchCompat = (SwitchCompat) findViewById(R.id.switch_police_button);
        switchCompat.setChecked(!sizePolice.equals("normal"));
        switchCompat.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        Toast.makeText(
                                SettingsActivity.this,
                                "Modification appliquée au premier changement d'onglet.",
                                Toast.LENGTH_SHORT).show();
                        if (b) {
                            PreferencesSize.setSize("police", "big", SettingsActivity.this);
                        } else {
                            PreferencesSize.setSize("police", "normal", SettingsActivity.this);
                        }
                    }
                }
        );

        //Bottom Menu
        Menu menu;
        if (sizePolice.equals("big")) {
            NavigationView bottomNav = findViewById(R.id.bottom_navigation);
            bottomNav.setNavigationItemSelectedListener(new MenuSwitcherActivity(this));
            bottomNav.setItemIconTintList(null);
            menu = bottomNav.getMenu();
        } else {
            BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
            bottomNav.setOnNavigationItemSelectedListener(new MenuSwitcherActivity(this));
            bottomNav.setItemIconTintList(null);
            menu = bottomNav.getMenu();
        }

        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);
    }

    /**
     * Method applying when user clicks on "Mentions légales". Launches the TermsofUse Activity.
     *
     * @param view
     */
    public void onClickTermsOfUse(View view) {
        Intent intent = new Intent(this, TermsOfUseActivity.class);
        startActivity(intent);
    }

    /**
     * Method applying when user clicks on "FAQ". Launches the FAQActivity.
     *
     * @param view
     */
    public void onClickFAQ(View view) {
        Intent intent = new Intent(this, FaqActivity.class);
        startActivity(intent);
    }


    /**
     * Method applying when user clicks on "Mentions légales". Launches the LegalNotices Activity.
     *
     * @param view
     */
    public void onClickLegalNotices(View view) {
        Intent intent = new Intent(this, LegalNoticesActivity.class);
        startActivity(intent);
    }

    public void onClickSizePolice(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("big", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.apply();
    }

    @Override
    public void onResume() {
        super.onResume();

        switchCompat = (SwitchCompat) findViewById(R.id.switch_police_button);

        String sizeMode = PreferencesSize.getSize("police", this);
        switchCompat.setChecked(!sizeMode.equals("normal"));

    }
}
