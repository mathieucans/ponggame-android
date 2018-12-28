package com.cans.ponggame;

import org.junit.Test;

import static org.junit.Assert.*;

public class BallTest {
    public static final PongRect BAT_RECT = new PongRect(10, 100, 110, 110);

    @Test
    public void when_ball_doesnot_touch_the_bat_is_moving() {
        Ball ball = new Ball(10, 10, new Speed(5, 5));

        boolean result = ball.update(BAT_RECT);

        assertEquals(new PongRect(15, 15, 25, 25), ball.getRect());
        assertFalse(result);
    }

    @Test
    public void when_ball_touch_the_bat_is_moving_with_incrreased_symertic_speed() {
        Ball ball = new Ball(20, 91, new Speed(5, 5));

        boolean result = ball.update(BAT_RECT);

        assertEquals(new PongRect(25.5F, 85.5F, 35.5F, 95.5F), ball.getRect());
        assertTrue(result);
    }


}