package com.cans.ponggame;

import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.cans.ponggame.api.Game;
import com.cans.ponggame.api.GameService;
import com.cans.ponggame.api.GameServiceRetrofit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.layout.simple_spinner_item;

public class SelectGameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_game);

        final GameService gameService = GameServiceRetrofit.Create();
        final SelectGameActivity self = this;
        Call<List<Game>> games = gameService.listGames();
        games.enqueue(new Callback<List<Game>>() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(
                    @NonNull Call<List<Game>> call,
                    @NonNull final Response<List<Game>> response) {
                self.runOnUiThread(() -> {
                    ProgressBar progressbar = self.findViewById(R.id.progressbar);
                    progressbar.setVisibility(View.INVISIBLE);

                    LinearLayout layout = self.findViewById(R.id.choicelayout);
                    layout.setVisibility(View.VISIBLE);

                    self.fillChoiceWithGame(response.body());
                });
            }

            @Override
            public void onFailure(
                    @NonNull Call<List<Game>> call,
                    @NonNull final Throwable t) {
                final String message = "Fail to communicate with server : " + t.getLocalizedMessage();
                self.runOnUiThread(() -> {
                    AlertDialog alertDialog = new AlertDialog.Builder(self).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage(message);
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            (dialog, which) -> dialog.dismiss());
                    alertDialog.show();

                });
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void fillChoiceWithGame(List<Game> body) {
        ArrayList<String> collect = body.stream().map(Game::getName).collect(Collectors.toCollection(ArrayList::new));
        Spinner spinner = findViewById(R.id.gamechoice);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                simple_spinner_item, collect);
        spinner.setAdapter(adapter);
    }
}
