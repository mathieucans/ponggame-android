package com.cans.ponggame;

import android.graphics.Rect;

import org.junit.Assert;
import org.junit.Test;


public class PongGameTest {
    @Test
    public void game_should_have_a_centered_bat() {

        PongGame pongGame = new PongGame(300, 100);

        PongRect batRect = pongGame.getBatRect();
        Assert.assertEquals(batRect, new PongRect (100,85,200, 95));
    }

    @Test
    public void at_init_ball_should_be_on_the_third_upper_left_corner()
    {
        PongGame pongGame = new PongGame(300, 100);

        PongRect ballRect = pongGame.getBallRect();

        Assert.assertEquals(ballRect, new PongRect (100,33,110, 43));
    }

    @Test
    public void after_an_update_the_ball_move_according_to_its_speed_vector()
    {
        PongGame pongGame = new PongGame(300, 100);

        pongGame.update();

        PongRect ballRect = pongGame.getBallRect();

        // speed 5,3
        Assert.assertEquals(ballRect, new PongRect (110,38,120, 48));
    }

}