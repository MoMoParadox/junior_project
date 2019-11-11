package com.example.guan_lun.loginandhome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signin extends AppCompatActivity {

    private Button mBtnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        mBtnButton = (Button) findViewById(R.id.btn_start);
        mBtnButton.setOnContextClickListener(new View.OnContextClickListener() {
            @Override
            public boolean onContextClick(View v) {
                Intent intent = new Intent(signin.this, homepage.class);
                startActivity(intent);
                return true;
            }
        });
    }
}
