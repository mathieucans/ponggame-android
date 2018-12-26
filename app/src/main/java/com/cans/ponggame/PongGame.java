package com.cans.ponggame;

import android.graphics.Rect;

class PongGame {
    private final int width;
    private final int height;

    public PongGame(int width, int height) {

        this.width = width;
        this.height = height;
    }

    public PongRect getBatRect() {
        return new PongRect(40,90,60, 95);
    }
}
