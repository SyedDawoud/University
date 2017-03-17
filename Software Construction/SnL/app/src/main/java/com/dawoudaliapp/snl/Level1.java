package com.dawoudaliapp.snl;

/**
 * Created by Dawoud Ali on 3/14/2017.
 */
public class Level1 extends Level {

    // Level 1 will have normal rules. Both Player 1 and 2 will be affected by the snakes
    // Both can climb ladders and the position 100 related checks will be performed
    public Level1() {
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
