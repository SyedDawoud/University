package com.dawoudaliapp.snl;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button startButton, aboutButton, scoreButton, exitButton, backMenu;

    ViewSwitcher switcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Playing the Dice sound on the beginning of the application
        MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.dice);
        mp.start();

        // First, set view to splash and then change the view on splash completion
        setContentView(R.layout.splash);

        //Hides the Top Notification bar to get full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    /*
    Setting Up Splash Screen at the Start
     */
        new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                //set the new Content of your activity
                MainActivity.this.setContentView(R.layout.activity_main);
                // Registering the Buttons
                /*
                Buttons are being registered at this point because
                the main activity XML files links here. Registering
                buttons before this point causes NullPointerException
                 */
                startButton = (Button) findViewById(R.id.Start);
                aboutButton = (Button) findViewById(R.id.about);
                scoreButton = (Button) findViewById(R.id.score);
                exitButton = (Button) findViewById(R.id.exit);
                backMenu = (Button) findViewById(R.id.backToMenu);
                startButton.setOnClickListener(MainActivity.this);
                aboutButton.setOnClickListener(MainActivity.this);
                scoreButton.setOnClickListener(MainActivity.this);
                exitButton.setOnClickListener(MainActivity.this);
                backMenu.setOnClickListener(MainActivity.this);

                switcher = (ViewSwitcher) findViewById(R.id.viewSwitch);
            }
        }.start();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.exit:
                System.exit(0);
                break;

            case R.id.about:
                switcher.showNext();
                break;

            case R.id.backToMenu:
                switcher.showPrevious();
                break;

            case R.id.Start:
                Intent i = new Intent(getApplicationContext(), LevelSelector.class);
                startActivity(i);
                finish();
        }

    }
}
