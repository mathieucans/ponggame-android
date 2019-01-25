package com.cans.ponggame.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GameServiceRetrofit {
    public static GameService Create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mypong.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(GameService.class);
    }
}
