package com.dawoudaliapp.snl;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Level2Activity extends AppCompatActivity implements View.OnClickListener {


    Dice dice;
    Button throwButton;
    ImageView mainBoard, diceImage, player1Position, player2Position;
    TextView p1Pos, p2Pos, turn;
    Player p1, p2;
    ArrayList<Snake> snakes;
    ArrayList<Ladder> ladders;
    Level lvl;


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);
        dice = new Dice();
        p1 = new Player();
        p2 = new Player();
        lvl = new Level2();

        p1.setCurrentPosition(0);
        p1.setSnakeBitten(false);

        p2.setCurrentPosition(0);
        p2.setSnakeBitten(false);


        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
        setUpSnakes();
        setUpLadders();

        throwButton = (Button) findViewById(R.id.diceThrowLevel2);
        mainBoard = (ImageView) findViewById(R.id.level2Board);
        diceImage = (ImageView) findViewById(R.id.diceImageLevel2);
        p1Pos = (TextView) findViewById(R.id.player1ValueLevel2);
        p2Pos = (TextView) findViewById(R.id.player2ValueLevel2);
        turn = (TextView) findViewById(R.id.playerTurnLevel2);
        player1Position = (ImageView) findViewById(R.id.player1PositionLevel2);
        player2Position = (ImageView) findViewById(R.id.player2PositionLevel2);


        throwButton.setOnClickListener(this);


    }

    public void setUpSnakes() {

        for (int i = 0; i < 10; i++) {
            snakes.add(i, new Snake());
        }

        snakes.get(0).setBitePoint(16);
        snakes.get(0).setTailPoint(6);

        snakes.get(1).setBitePoint(46);
        snakes.get(1).setTailPoint(25);

        snakes.get(2).setBitePoint(49);
        snakes.get(2).setTailPoint(11);

        snakes.get(3).setBitePoint(62);
        snakes.get(3).setTailPoint(19);

        snakes.get(4).setBitePoint(64);
        snakes.get(4).setTailPoint(60);

        snakes.get(5).setBitePoint(74);
        snakes.get(5).setTailPoint(53);

        snakes.get(6).setBitePoint(89);
        snakes.get(6).setTailPoint(68);

        snakes.get(7).setBitePoint(92);
        snakes.get(7).setTailPoint(88);

        snakes.get(8).setBitePoint(95);
        snakes.get(8).setTailPoint(75);

        snakes.get(9).setBitePoint(99);
        snakes.get(9).setTailPoint(80);


    }

    public void setUpLadders() {

        for (int i = 0; i < 11; i++) {
            ladders.add(i, new Ladder());
        }

        ladders.get(0).setBottomPosition(2);
        ladders.get(0).setTopPosition(38);

        ladders.get(1).setBottomPosition(7);
        ladders.get(1).setTopPosition(14);

        ladders.get(2).setBottomPosition(8);
        ladders.get(2).setTopPosition(31);


        ladders.get(3).setBottomPosition(15);
        ladders.get(3).setTopPosition(26);


        ladders.get(4).setBottomPosition(21);
        ladders.get(4).setTopPosition(42);

        ladders.get(5).setBottomPosition(28);
        ladders.get(5).setTopPosition(84);

        ladders.get(6).setBottomPosition(36);
        ladders.get(6).setTopPosition(44);


        ladders.get(7).setBottomPosition(51);
        ladders.get(7).setTopPosition(67);


        ladders.get(8).setBottomPosition(71);
        ladders.get(8).setTopPosition(91);


        ladders.get(9).setBottomPosition(78);
        ladders.get(9).setTopPosition(98);


        ladders.get(10).setBottomPosition(87);
        ladders.get(10).setTopPosition(94);


    }


    public void changeDiceImage() {

        String img = dice.getDiceImage();
        if (img == "dice1")
            diceImage.setBackgroundResource(R.drawable.dice1);
        else if (img == "dice2")
            diceImage.setBackgroundResource(R.drawable.dice2);
        else if (img == "dice3")
            diceImage.setBackgroundResource(R.drawable.dice3);
        else if (img == "dice4")
            diceImage.setBackgroundResource(R.drawable.dice4);
        else if (img == "dice5")
            diceImage.setBackgroundResource(R.drawable.dice5);
        else if (img == "dice6")
            diceImage.setBackgroundResource(R.drawable.dice6);


    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void setPlayerPosition(Player P, ImageView im) {

        int mainHeight = mainBoard.getHeight();
        int mainWidth = mainBoard.getWidth();


        int heightPerTen = mainHeight / 10;
        int widthPerTen = mainWidth / 10;


        int pos = P.getCurrentPosition();

        int yComponent = pos / 10;
        int xComponent = pos % 10;

        // This case is when player is moving from left to right
        if (yComponent % 2 == 0) {
//  If player is on 20,40,60,80,100
            //
            if (pos % 10 == 0) {

                im.setX(0);
                im.setY(mainHeight - ((yComponent + 1) * heightPerTen));
            } else {
                // Otherwise, set according to the position
                im.setX((float) ((xComponent - 1.5) * widthPerTen));
                im.setY(mainHeight - ((yComponent + 2) * heightPerTen));
            }
        }

        // This is case when player is moving from right to left
        else {
            // For case of 10,30,50,70,90
            if (pos % 10 == 0) {
                im.setX(mainWidth - widthPerTen - 10);
                im.setY(mainHeight - ((yComponent + 1) * heightPerTen));

            } else {
                im.setX((float) (mainWidth - ((xComponent + 0.75) * widthPerTen)));
                im.setY(mainHeight - ((yComponent + 2) * heightPerTen));
            }
        }


    }


    public void movePlayer1(int val) {

        player1Position.setVisibility(View.VISIBLE);
        if (p1.isSnakeBitten() == true && val < 6)
            return;

        if (p1.isSnakeBitten() == true && val >= 6)
            p1.setSnakeBitten(false);

        int curr = p1.getCurrentPosition() + val;

        if (curr == 100) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent in = new Intent(getApplicationContext(), player1Victory.class);
                    startActivity(in);
                    finish();
                }
            }, 500);

            return;
        }

        if (curr > 100)
            return;

        for (int i = 0; i < snakes.size(); i++) {
            if (curr == snakes.get(i).getBitePoint()) {
                p1.setCurrentPosition(snakes.get(i).getTailPoint());
                p1.setSnakeBitten(true);
                setPlayerPosition(p1, player1Position);
                return;
            }
        }

        for (int i = 0; i < ladders.size(); i++) {
            if (curr == ladders.get(i).getBottomPosition()) {
                p1.setCurrentPosition(ladders.get(i).getTopPosition());
                int temp = dice.throwDice();
                changeDiceImage();
                temp = checkForSix(temp);
                changeDiceImage();
                p1.setCurrentPosition(p1.getCurrentPosition()+temp);
                setPlayerPosition(p1, player1Position);
                return;
            }
        }

        p1.setCurrentPosition(curr);
        setPlayerPosition(p1, player1Position);
    }


    public void movePlayer2(int val) {
        player2Position.setVisibility(View.VISIBLE);

        if (p2.isSnakeBitten() == true && val < 6)
            return;

        if (p2.isSnakeBitten() == true && val >= 6)
            p2.setSnakeBitten(false);

        int curr = p2.getCurrentPosition() + val;

        if (curr == 100) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent in = new Intent(getApplicationContext(), player2Victory.class);
                    startActivity(in);
                    finish();
                }
            }, 500);
            return;
        }
        if (curr > 100)
            return;


        for (int i = 0; i < snakes.size(); i++) {
            if (curr == snakes.get(i).getBitePoint()) {
                p2.setCurrentPosition(snakes.get(i).getTailPoint());
                p2.setSnakeBitten(true);
                setPlayerPosition(p2, player2Position);
                return;
            }
        }

        for (int i = 0; i < ladders.size(); i++) {
            if (curr == ladders.get(i).getBottomPosition()) {
                p2.setCurrentPosition(ladders.get(i).getTopPosition());
                int temp = dice.throwDice();
                changeDiceImage();
                temp = checkForSix(temp);
                changeDiceImage();
                p2.setCurrentPosition(p2.getCurrentPosition()+temp);
                setPlayerPosition(p2, player2Position);
                return;
            }
        }

        p2.setCurrentPosition(curr);
        setPlayerPosition(p2, player2Position);
    }


    public int checkForSix(int val) {
        while (val == 6) {


            val += dice.throwDice();
            changeDiceImage();




        }  return val;


    }

    public void player1Turn() {
        turn.setText("Player 1 Turn");
        int val = dice.throwDice();

        if (p1.isSnakeBitten() == true && val < 6) {
            changeDiceImage();
            return;
        }

        int val2 = checkForSix(val);

        movePlayer1(val2);

        p1Pos.setText(Integer.toString(p1.getCurrentPosition()));
        changeDiceImage();
    }

    public void player2Turn() {
        turn.setText("Player 2 Turn");
        int val = dice.throwDice();

        if (p2.isSnakeBitten() == true && val < 6) {
            changeDiceImage();
            return;
        }
        int val2 = checkForSix(val);


        movePlayer2(val2);
        p2Pos.setText(Integer.toString(p2.getCurrentPosition()));
        changeDiceImage();

        turn.setText("Roll Again");
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.diceThrowLevel2:
                throwButton.setEnabled(false);
                // Call Player 1 Move Function
                player1Turn();
                // After delay of 2 sec, call the AI function
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        player2Turn();
                        throwButton.setEnabled(true);
                    }
                }, 2000);


                break;
        }
    }
}
