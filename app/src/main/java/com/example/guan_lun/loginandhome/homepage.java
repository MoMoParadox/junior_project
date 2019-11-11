package com.example.guan_lun.loginandhome;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

import static com.example.guan_lun.loginandhome.R.id.bottom_navigation;

public class homepage extends AppCompatActivity {
    BottomNavigationView mBottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        mBottomNav = findViewById(bottom_navigation);
        mBottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new fragment_home()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
        new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragement = null;

                switch(menuItem.getItemId()) {
                    case R.id.nav_home:
                        selectedFragement = new fragment_home();
                        break;
                    case R.id.nav_search:
                        selectedFragement = new fragment_search();
                        break;
                    case R.id.nav_booking:
                        selectedFragement = new fragment_booking();
                        break;
                    case R.id.nav_user:
                        selectedFragement = new fragment_user();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragement).commit();
                return true;
            }
        };

    public void getSpeechInput(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.TAIWAN);


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(this , "你的手機不支援語音輸入", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    String[] result = data.getStringArrayExtra(RecognizerIntent.EXTRA_RESULTS);
                    Toast.makeText(this , result.toString(), Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
