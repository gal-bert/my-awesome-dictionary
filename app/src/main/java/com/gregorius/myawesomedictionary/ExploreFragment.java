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
    List<Word> words;
    List<Definitions> definitions;
    RecyclerView rvExplore;
    ExploreAdapter exploreAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        rvExplore = view.findViewById(R.id.rvExplore);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        rvExplore.setLayoutManager(manager);

        Retrofit retrofit = APIClient.getRetrofit();
        HerokuService herokuService = retrofit.create(HerokuService.class);

        Call<List<Word>> call = herokuService.getWords("app");

        call.enqueue(new Callback<List<Word>>() {
            @Override
            public void onResponse(Call<List<Word>> call, Response<List<Word>> response) {
                if (response.isSuccessful()){
                    words = response.body();

                    exploreAdapter = new ExploreAdapter(words);
                    rvExplore.setAdapter(exploreAdapter);
                    exploreAdapter.setWords(words);

                    for(Word word : words){
                        Log.i("MYLOGS", word.getWord());
                        definitions = word.getDefinitions();
                        for(Definitions definition : definitions){
                            Log.i("MYLOGS", definition.getDefinition());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Word>> call, Throwable t) {
                Log.i("MYLOGS", t.getMessage());
            }
        });


        return view;
    }


}