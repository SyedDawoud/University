package com.dawoudaliapp.snl;

/**
 * Created by Dawoud Ali on 3/14/2017.
 */

/*
Ladder Related Class. It will deal with end and up point of the ladder
 */

public class Ladder {

    private int bottomPosition;
    private int topPosition;
    private float bottomX;
    private float bottomY;
    private float topX;
    private float topY;

    public int getBottomPosition() {
        return bottomPosition;
    }

    public void setBottomPosition(int bottomPosition) {
        this.bottomPosition = bottomPosition;
    }

    public float getBottomX() {
        return bottomX;
    }

    public void setBottomX(float bottomX) {
        this.bottomX = bottomX;
    }

    public int getTopPosition() {
        return topPosition;
    }

    public void setTopPosition(int topPosition) {
        this.topPosition = topPosition;
    }

    public float getBottomY() {
        return bottomY;
    }

    public void setBottomY(float bottomY) {
        this.bottomY = bottomY;
    }

    public float getTopX() {
        return topX;
    }

    public void setTopX(float topX) {
        this.topX = topX;
    }

    public float getTopY() {
        return topY;
    }

    public void setTopY(float topY) {
        this.topY = topY;
    }
}
