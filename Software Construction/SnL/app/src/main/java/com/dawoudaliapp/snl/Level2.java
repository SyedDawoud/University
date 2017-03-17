package com.dawoudaliapp.snl;

/**
 * Created by Dawoud Ali on 3/14/2017.
 */

// Level 2 is same as Level 1
public class Level2 extends Level {


    public Level2() {
        this.setIsPlayer1ClimbLadder(true);

        this.setIsPlayer2ClimbLadder(true);

        this.setIsPlayer1HarmedBySnakes(true);

        this.setIsPlayer2HarmedBySnakes(true);

        this.setIsPlayer1finishBarrier(true);

        this.setIsPlayer2finishBarrier(true);

        this.setPlayer1Victories(0);
        this.setPlayer2Victories(0);
    }

}
