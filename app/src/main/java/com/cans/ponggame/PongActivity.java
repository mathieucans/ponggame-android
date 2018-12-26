package com.cans.ponggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PongActivity extends AppCompatActivity {

    private PongView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = new PongView(this);

        setContentView(view);
    }
}
