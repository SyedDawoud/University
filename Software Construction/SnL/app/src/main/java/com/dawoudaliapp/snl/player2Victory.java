package com.dawoudaliapp.snl;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class player2Victory extends AppCompatActivity implements View.OnClickListener {

    Button vic;
    ImageView Im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MediaPlayer mp = MediaPlayer.create(player2Victory.this, R.raw.vic);
        mp.start();
        setContentView(R.layout.activity_player2_victory);
        vic = (Button) findViewById(R.id.player2VictoryBack);
        Im = (ImageView) findViewById(R.id.player2VictoryImage);
        vic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.player2VictoryBack:
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
                finish();

        }
    }
}
