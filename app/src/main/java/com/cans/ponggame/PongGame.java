package com.cans.ponggame;

import android.graphics.Rect;

class PongGame {
    private final int width;
    private final int height;
    private PongRect batRect;

    public PongGame(int width, int height) {

        this.width = width;
        this.height = height;
        batRect = new PongRect((width-100)/2, height - 10 -5, (width-100)/2 +100, height-5);

    }

    public PongRect getBatRect() {
        return batRect;
    }

    public void SetBatPos(float x) {
        batRect = new PongRect((int) x, batRect.getTop(), (int)x +100, batRect.getBottom());
    }
}
