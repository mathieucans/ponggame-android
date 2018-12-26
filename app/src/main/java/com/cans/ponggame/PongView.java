package com.cans.ponggame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class PongView extends SurfaceView implements Runnable {

    private final SurfaceHolder holder;
    private final Thread drawingThread;

    public PongView(Context context) {
        super(context);

        holder = getHolder();
        drawingThread = new Thread(this);

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

            holder.unlockCanvasAndPost(canvas);
        }
    }
}
