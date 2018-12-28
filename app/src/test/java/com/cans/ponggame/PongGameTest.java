package com.cans.ponggame;

import android.support.annotation.NonNull;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PongGameTest {

    @NonNull
    private PongGame Create(Ball ball) {
        return new PongGame(400, 400, ball);
    }

    @Test
    public void game_should_have_a_centered_bat() {
        PongGame pongGame = Create(new Ball(300 / 3, 100 / 3, new Speed(10, 5)));

        PongRect batRect = pongGame.getBatRect();

        Assert.assertEquals(batRect, new PongRect (150,385,250, 395));
    }

    @Test
    public void after_an_update_the_ball_move_according_to_its_speed_vector()
    {
        PongGame pongGame = Create(new Ball(300 / 3, 100 / 3, new Speed(10, 5)));

        pongGame.update();

        PongRect ballRect = pongGame.getBallRect();
        Assert.assertEquals(ballRect, new PongRect (110,38,120, 48));
    }

    @Test
    public void when_ball_touch_the_right_bound_is_moving_with_simertic_speed() {
        Ball ball = new Ball(390, 50, new Speed(5, 5));
        PongGame pongGame = Create(ball);

        pongGame.update();

        assertEquals(new PongRect(385, 55, 395, 65), pongGame.getBallRect());
    }

    @Test
    public void when_ball_touch_the_left_bound_is_moving_with_simertic_speed() {
        PongGame pongGame = Create(new Ball(0, 50, new Speed(-5, 5)));

        pongGame.update();

        assertEquals(new PongRect(5, 55, 15, 65), pongGame.getBallRect());
    }

    @Test
    public void when_ball_touch_the_top_bound_is_moving_with_simertic_speed() {
        PongGame pongGame = Create(new Ball(50, 0, new Speed(5, -5)));

        pongGame.update();

        assertEquals(new PongRect(55, 5, 65, 15), pongGame.getBallRect());
    }


    public static final PongRect BAT_RECT = new PongRect(150,385,250, 395);
}