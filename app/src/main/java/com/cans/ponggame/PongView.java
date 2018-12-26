package com.cans.ponggame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class PongView extends SurfaceView implements Runnable {

    private final SurfaceHolder holder;
    private final Thread drawingThread;
    private final PongGame pongGame;

    public PongView(Context context, int width, int height) {
        super(context);

        holder = getHolder();
        drawingThread = new Thread(this);

        pongGame = new PongGame(width, height);

        drawingThread.start();
    }


    @Override
    public void run()
    {
        while (!Thread.currentThread().isInterrupted())
        {
            draw();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Log.i(VIEW_LOG_TAG,"sleep interrupt");
            }
        }
    }

    private void draw() {
        if (holder.getSurface().isValid())
        {
            Canvas canvas = holder.lockCanvas();

            canvas.drawColor(Color.argb(255, 120, 197, 87));

            PongRect batRect = this.pongGame.getBatRect();
            Paint red = new Paint();
            red.setColor(Color.argb(255, 255,0,0));
            canvas.drawRect(batRect.getLeft(), batRect.getTop(), batRect.getRight(), batRect.getBottom(), red);

            holder.unlockCanvasAndPost(canvas);
        }
    }
}
