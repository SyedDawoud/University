package com.dawoudaliapp.snl;

/**
 * Created by Dawoud Ali on 3/14/2017.
 */
public class Level4 extends Level {

    // In level4, AI will not be harmed by snakes and Our player can't climb the ladders
    public Level4() {
        this.setIsPlayer1ClimbLadder(false);

        this.setIsPlayer2ClimbLadder(true);

        this.setIsPlayer1HarmedBySnakes(true);

        this.setIsPlayer2HarmedBySnakes(false);

        this.setIsPlayer1finishBarrier(true);

        this.setIsPlayer2finishBarrier(true);

        this.setPlayer1Victories(0);
        this.setPlayer2Victories(0);
    }

}
