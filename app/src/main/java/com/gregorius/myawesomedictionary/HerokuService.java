package com.gregorius.myawesomedictionary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HerokuService {
    @GET("words?")
    Call<List<Word>> getWords(@Query("q") String keyword);
}
