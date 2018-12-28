package com.cans.ponggame;

import org.junit.Test;

import static org.junit.Assert.*;

public class BallTest {
    private static final PongRect GAME_BOUNDS = new PongRect(0, 0, 400, 400);
    public static final PongRect BAT_RECT = new PongRect(10, 100, 110, 110);

    @Test
    public void when_ball_doesnot_touch_the_bat_is_moving() {
        Ball ball = new Ball(10, 10, new Speed(5, 5));

        ball.Update(BAT_RECT, GAME_BOUNDS);

        assertEquals(new PongRect(15, 15, 25, 25), ball.getRect());
    }

    @Test
    public void when_ball_touch_the_bat_is_moving_with_simertic_speed() {
        Ball ball = new Ball(20, 91, new Speed(5, 5));

        ball.Update(BAT_RECT, GAME_BOUNDS);

        assertEquals(new PongRect(25, 91-5, 35, 91-5+10), ball.getRect());
    }

    @Test
    public void when_ball_touch_the_right_bound_is_moving_with_simertic_speed() {
        Ball ball = new Ball(390, 50, new Speed(5, 5));

        ball.Update(BAT_RECT, GAME_BOUNDS);

        assertEquals(new PongRect(385, 55, 395, 65), ball.getRect());
    }

    @Test
    public void when_ball_touch_the_left_bound_is_moving_with_simertic_speed() {
        Ball ball = new Ball(0, 50, new Speed(-5, 5));

        ball.Update(BAT_RECT, GAME_BOUNDS);

        assertEquals(new PongRect(5, 55, 15, 65), ball.getRect());
    }

    @Test
    public void when_ball_touch_the_top_bound_is_moving_with_simertic_speed() {
        Ball ball = new Ball(50, 0, new Speed(5, -5));

        ball.Update(BAT_RECT, GAME_BOUNDS);

        assertEquals(new PongRect(55, 5, 65, 15), ball.getRect());
    }
}