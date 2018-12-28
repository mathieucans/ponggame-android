package com.cans.ponggame;

import android.graphics.Rect;

class PongGame {
    public static final int BAT_WIDTH = 100;
    public static final int BAT_HEIGHT = 10;
    private static final int BALL_SIZE = 10;
    private final int width;
    private final int height;
    private PongRect batRect;
    private PongRect ballRect;

    public PongGame(int width, int height) {

        this.width = width;
        this.height = height;
        batRect = new PongRect((width- BAT_WIDTH)/2, height - BAT_HEIGHT -5, (width- BAT_WIDTH)/2 + BAT_WIDTH, height-5);
        ballRect = new PongRect(width/3 , height/3, width/3+BALL_SIZE, height/3+BALL_SIZE);

    }

    public PongRect getBatRect() {
        return batRect;
    }

    public void SetBatPos(float x) {
        batRect = new PongRect((int) x, batRect.getTop(), (int)x + BAT_WIDTH, batRect.getBottom());
    }

    public PongRect getBallRect() {
        return ballRect;
    }

    public void update() {
        ballRect = ballRect.translate(10,5);
    }
}
