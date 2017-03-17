package com.dawoudaliapp.snl;


import java.util.Random;

/**
 * Created by Dawoud Ali on 3/14/2017.
 */
public class Dice {

    private int value;
    private String diceImage;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDiceImage() {
        return diceImage;
    }

    public void setDiceImage(String diceImage) {
        this.diceImage = diceImage;
    }


    // Function to generate the random value
    public int throwDice() {
        Random rand = new Random();

        setValue(rand.nextInt(6) + 1);
        setImageString();

        return getValue();

    }


    // Based on Dice Value, the String for the ImageName is set

    public void setImageString() {

        if (getValue() == 1) {
            setDiceImage("dice1");
        } else if (getValue() == 2) {
            setDiceImage("dice2");
        } else if (getValue() == 3) {
            setDiceImage("dice3");
        } else if (getValue() == 4) {
            setDiceImage("dice4");
        } else if (getValue() == 5) {
            setDiceImage("dice5");
        } else if (getValue() == 6) {
            setDiceImage("dice6");
        }

    }


}
