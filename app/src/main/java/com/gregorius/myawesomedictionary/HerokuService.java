package com.gregorius.myawesomedictionary;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HerokuService {
    @GET("words?")
    Call<WordListResponse> getWords(@Query("q") String keyword);
}
