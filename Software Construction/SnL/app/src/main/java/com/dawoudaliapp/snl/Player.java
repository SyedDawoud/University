package com.dawoudaliapp.snl;

/**
 * Created by Dawoud Ali on 3/14/2017.
 */
public class Player {

    private int currentPosition;

    private boolean snakeBitten;


    private float playerX;

    private float playerY;


    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isSnakeBitten() {
        return snakeBitten;
    }

    public void setSnakeBitten(boolean snakeBitten) {
        this.snakeBitten = snakeBitten;
    }


    public float getPlayerX() {
        return playerX;
    }

    public void setPlayerX(float playerX) {
        this.playerX = playerX;
    }

    public float getPlayerY() {
        return playerY;
    }

    public void setPlayerY(float playerY) {
        this.playerY = playerY;
    }
}
