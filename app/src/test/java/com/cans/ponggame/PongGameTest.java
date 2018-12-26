package com.cans.ponggame;

import android.graphics.Rect;

import org.junit.Assert;
import org.junit.Test;


public class PongGameTest {
    @Test
    public void game_should_have_a_centered_bat() {

        PongGame pongGame = new PongGame(200, 100);

        PongRect batRect = pongGame.getBatRect();
        Assert.assertEquals(batRect, new PongRect (40,90,60, 95));
    }
}