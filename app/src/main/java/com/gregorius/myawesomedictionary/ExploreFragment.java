package com.gregorius.myawesomedictionary;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Vector;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExploreFragment extends Fragment {

    Context context;
    List<WordListResponse> wordListResponses;
    RecyclerView rvExplore;
    ExploreAdapter exploreAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        wordListResponses = new Vector<>();

        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        rvExplore = view.findViewById(R.id.rvExplore);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        rvExplore.setLayoutManager(manager);

        exploreAdapter = new ExploreAdapter(wordListResponses);
        rvExplore.setAdapter(exploreAdapter);

        Retrofit retrofit = APIClient.getRetrofit();
        HerokuService herokuService = retrofit.create(HerokuService.class);

        Call<WordListResponse> call = herokuService.getWords("app");

        call.enqueue(new Callback<WordListResponse>() {
            @Override
            public void onResponse(Call<WordListResponse> call, Response<WordListResponse> response) {
                Log.i("MYLOGS", String.valueOf(response));
                Log.i("MYLOGS", "OK1");
                if (response.isSuccessful()){
                    Log.i("MYLOGS", "OK");
                    WordListResponse wordListResponse = response.body();
                    wordListResponses = (List<WordListResponse>) wordListResponse;
                    exploreAdapter.setListWord(wordListResponses);
                }
                else{
                    Log.i("MYLOGS", "fail");
                }
            }

            @Override
            public void onFailure(Call<WordListResponse> call, Throwable t) {
                Log.i("MYLOGS", String.valueOf(t));
            }
        });

        return view;
    }


}