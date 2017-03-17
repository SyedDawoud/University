package com.dawoudaliapp.snl;

/**
 * Created by Dawoud Ali on 3/14/2017.
 */
public class Level {

    // Check Whether Players are harmed by the snakes or not
    private boolean isPlayer1HarmedBySnakes;
    private boolean isPlayer2HarmedBySnakes;
    // Check whether players can climb the ladders or not
    private boolean isPlayer1ClimbLadder;
    private boolean isPlayer2ClimbLadder;
    // Check whether Players are restricted by 100 position boundary
    private boolean isPlayer1finishBarrier;
    private boolean isPlayer2finishBarrier;

    // Getting count of how many games both player 1 and 2 have won
    private int player1Victories;
    private int player2Victories;

    public int getPlayer1Victories() {
        return player1Victories;
    }

    public void setPlayer1Victories(int player1Victories) {
        this.player1Victories = player1Victories;
    }

    public int getPlayer2Victories() {
        return player2Victories;
    }

    public void setPlayer2Victories(int player2Victories) {
        this.player2Victories = player2Victories;
    }

    public boolean isPlayer1HarmedBySnakes() {
        return isPlayer1HarmedBySnakes;
    }

    public void setIsPlayer1HarmedBySnakes(boolean isPlayer1HarmedBySnakes) {
        this.isPlayer1HarmedBySnakes = isPlayer1HarmedBySnakes;
    }

    public boolean isPlayer2HarmedBySnakes() {
        return isPlayer2HarmedBySnakes;
    }

    public void setIsPlayer2HarmedBySnakes(boolean isPlayer2HarmedBySnakes) {
        this.isPlayer2HarmedBySnakes = isPlayer2HarmedBySnakes;
    }

    public boolean isPlayer1ClimbLadder() {
        return isPlayer1ClimbLadder;
    }

    public void setIsPlayer1ClimbLadder(boolean isPlayer1ClimbLadder) {
        this.isPlayer1ClimbLadder = isPlayer1ClimbLadder;
    }

    public boolean isPlayer2ClimbLadder() {
        return isPlayer2ClimbLadder;
    }

    public void setIsPlayer2ClimbLadder(boolean isPlayer2ClimbLadder) {
        this.isPlayer2ClimbLadder = isPlayer2ClimbLadder;
    }

    public boolean isPlayer1finishBarrier() {
        return isPlayer1finishBarrier;
    }

    public void setIsPlayer1finishBarrier(boolean isPlayer1finishBarrier) {
        this.isPlayer1finishBarrier = isPlayer1finishBarrier;
    }

    public boolean isPlayer2finishBarrier() {
        return isPlayer2finishBarrier;
    }

    public void setIsPlayer2finishBarrier(boolean isPlayer2finishBarrier) {
        this.isPlayer2finishBarrier = isPlayer2finishBarrier;
    }
}
