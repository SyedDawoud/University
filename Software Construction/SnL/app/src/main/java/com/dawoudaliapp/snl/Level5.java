package com.dawoudaliapp.snl;

/**
 * Created by Dawoud Ali on 3/14/2017.
 */
public class Level5 extends Level {

    // Level 5 is toughest. Your opponent will not be harmed by the snakes and there is no stopping at 100 i.e. if pos=99 and 2 comes, AI wins
    public Level5() {
        this.setIsPlayer1ClimbLadder(false);

        this.setIsPlayer2ClimbLadder(true);

        this.setIsPlayer1HarmedBySnakes(true);

        this.setIsPlayer2HarmedBySnakes(false);

        this.setIsPlayer1finishBarrier(true);

        this.setIsPlayer2finishBarrier(false);

        this.setPlayer1Victories(0);
        this.setPlayer2Victories(0);
    }

}
