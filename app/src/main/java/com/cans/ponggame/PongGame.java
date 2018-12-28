package com.cans.ponggame;

class PongGame {
    public static final int BAT_WIDTH = 100;
    public static final int BAT_HEIGHT = 10;
    private final int width;
    private final int height;
    private final Ball ball;
    private PongRect batRect;

    public PongGame(int width, int height, Ball ball) {

        this.width = width;
        this.height = height;
        batRect = new PongRect((width- BAT_WIDTH)/2, height - BAT_HEIGHT -5, (width- BAT_WIDTH)/2 + BAT_WIDTH, height-5);

        this.ball = ball;

    }

    public PongRect getBatRect() {
        return batRect;
    }

    public void SetBatPos(float x) {
        batRect = new PongRect((int) x, batRect.getTop(), (int)x + BAT_WIDTH, batRect.getBottom());
    }

    public PongRect getBallRect() {
        return ball.getRect();
    }

    public void update() {
        PongRect gameBounds = new PongRect(0, 0, width, height);

        Speed speed = ball.getSpeed();
        if (ball.getRect().getRight() >= gameBounds.getRight()   )
        {
            speed = new Speed(-speed.getX(), speed.getY());
        }

        if (ball.getRect().getLeft() <= gameBounds.getLeft()   )
        {
            speed = new Speed(-speed.getX(), speed.getY());
        }

        if (ball.getRect().getTop() <= gameBounds.getTop()   )
        {
            speed = new Speed(speed.getX(), -speed.getY());
        }
        ball.setSpeed(speed);

        ball.update(batRect);
    }
}
