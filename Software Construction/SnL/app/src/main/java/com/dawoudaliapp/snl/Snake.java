package com.dawoudaliapp.snl;


// Class Related to the Snake Attributes
public class Snake {

    /*
    Bite and ending co-ordinates and actual positions
     */
    private int bitePoint;
    private int tailPoint;
    private float biteX;
    private float biteY;
    private float tailX;
    private float tailY;

    public float getBiteX() {
        return biteX;
    }

    public void setBiteX(float biteX) {
        this.biteX = biteX;
    }

    public float getBiteY() {
        return biteY;
    }

    public void setBiteY(float biteY) {
        this.biteY = biteY;
    }

    public float getTailX() {
        return tailX;
    }

    public void setTailX(float tailX) {
        this.tailX = tailX;
    }

    public float getTailY() {
        return tailY;
    }

    public void setTailY(float tailY) {
        this.tailY = tailY;
    }

    public int getBitePoint() {
        return bitePoint;
    }

    public void setBitePoint(int bitePoint) {
        this.bitePoint = bitePoint;
    }

    public int getTailPoint() {
        return tailPoint;
    }

    public void setTailPoint(int tailPoint) {
        this.tailPoint = tailPoint;
    }


}
