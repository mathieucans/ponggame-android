package com.cans.ponggame;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

public class PongActivity extends AppCompatActivity {

    private PongView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get a Display object to access screen details
        Display display = getWindowManager().getDefaultDisplay();

        // Load the resolution into a Point object
        Point size = new Point();
        display.getSize(size);

        // Initialize pongView and set it as the view
        view = new PongView(this, size.x, size.y-200);

        setContentView(view);
    }
}
