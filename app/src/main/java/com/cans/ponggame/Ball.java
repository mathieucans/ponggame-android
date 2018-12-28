package com.cans.ponggame;

class Ball {
    private float x;
    private float y;
    private Speed speed;

    private static final int BALL_SIZE = 10;

    public Ball(float x, float y, Speed speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public PongRect getRect() {
        return new PongRect(x, y, x +BALL_SIZE, y+ BALL_SIZE);
    }

    public void Update() {
        x = x + speed.getX();
        y = y+ speed.getY();
    }
}
