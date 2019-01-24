package com.cans.ponggame.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GameService {
    @GET("ads")
    Call<List<Game>> listGames();
}
