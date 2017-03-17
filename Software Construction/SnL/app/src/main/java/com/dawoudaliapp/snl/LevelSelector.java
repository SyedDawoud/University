package com.dawoudaliapp.snl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class LevelSelector extends AppCompatActivity implements View.OnClickListener {

    ImageButton b1, b2, b3, b4, b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selector);
        b1 = (ImageButton) findViewById(R.id.imageButton);
        b2 = (ImageButton) findViewById(R.id.imageButton2);
        b3 = (ImageButton) findViewById(R.id.imageButton3);
        b4 = (ImageButton) findViewById(R.id.imageButton4);
        b5 = (ImageButton) findViewById(R.id.imageButton5);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

// Buttons to launch different levels
        switch (v.getId()) {

            case R.id.imageButton:
                Intent in = new Intent(getApplicationContext(), Level1Activity.class);
                finish();
                startActivity(in);

                break;

            case R.id.imageButton2:
                Intent inte = new Intent(getApplicationContext(), Level2Activity.class);
                finish();
                startActivity(inte);

                break;

            case R.id.imageButton3:
                inte = new Intent(getApplicationContext(), Level3Activity.class);
                finish();
                startActivity(inte);
                break;

            case R.id.imageButton4:
                inte = new Intent(getApplicationContext(), Level4Activity.class);
                finish();
                startActivity(inte);
                break;

            case R.id.imageButton5:
                inte = new Intent(getApplicationContext(), Level5Activity.class);
                finish();
                startActivity(inte);
                break;

        }
    }
}
