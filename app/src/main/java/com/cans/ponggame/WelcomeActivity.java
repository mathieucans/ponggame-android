package com.cans.ponggame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cans.ponggame.api.Game;
import com.cans.ponggame.api.GameService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        Log.d("INFO", "onSelectGameClicked: ");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mypong.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GameService gameService = retrofit.create(GameService.class);

        final Activity self = this;
        Call<List<Game>> games = gameService.listGames();
        games.enqueue(new Callback<List<Game>>(){

            @Override
            public void onResponse(Call<List<Game>> call, final Response<List<Game>> response) {
                self.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AlertDialog alertDialog = new AlertDialog.Builder(self).create();
                        alertDialog.setTitle("Alert");
                        alertDialog.setMessage("games : " + response.body().size());
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();

                    }
                });
            }

            @Override
            public void onFailure(Call<List<Game>> call, Throwable t) {

            }
        });

    }
}
