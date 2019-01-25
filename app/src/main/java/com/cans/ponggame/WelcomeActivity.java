package com.cans.ponggame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cans.ponggame.api.Game;
import com.cans.ponggame.api.GameService;
import com.cans.ponggame.api.GameServiceRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void onStartNewGameClicked(View view) {
        Intent intent = new Intent(this, PongActivity.class);
        startActivity(intent);
    }

    public void onSelectGameClicked(View view) {

        Intent intent = new Intent(this, SelectGameActivity.class);
        startActivity(intent);

    }

}
