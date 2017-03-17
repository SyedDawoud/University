package com.dawoudaliapp.snl;

/**
 * Created by Dawoud Ali on 3/14/2017.
 */
public class Level3 extends Level {

    // In Level 3, AI will not be affected by the bite of the snake
    public Level3() {
        this.setIsPlayer1ClimbLadder(true);

        this.setIsPlayer2ClimbLadder(true);

        this.setIsPlayer1HarmedBySnakes(true);

        this.setIsPlayer2HarmedBySnakes(false);

        this.setIsPlayer1finishBarrier(true);

        this.setIsPlayer2finishBarrier(true);

        this.setPlayer1Victories(0);
        this.setPlayer2Victories(0);
    }

}
