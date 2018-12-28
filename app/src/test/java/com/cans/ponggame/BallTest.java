package com.cans.ponggame;

import org.junit.Test;

import static org.junit.Assert.*;

public class BallTest {
    @Test
    public void when_ball_doesnot_touch_the_bat_is_moving() {
        Ball ball = new Ball(10, 10, new Speed(5, 5));

        ball.Update(new PongRect(10, 100, 110, 110));

        assertEquals(new PongRect(15, 15, 25, 25), ball.getRect());
    }

    @Test
    public void when_ball_touch_the_bat_is_moving_with_simertic_speed() {
        Ball ball = new Ball(20, 91, new Speed(5, 5));

        ball.Update(new PongRect(10, 100, 110, 110));

        assertEquals(new PongRect(25, 91-5, 35, 91-5+10), ball.getRect());
    }
}