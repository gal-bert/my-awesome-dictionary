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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ExploreFragment extends Fragment implements View.OnClickListener {

    Context context;
    List<Word> words;
    RecyclerView rvExplore;
    ExploreAdapter exploreAdapter;
    EditText etSearchbar;
    String search;
    ImageButton btnSearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        rvExplore = view.findViewById(R.id.rvExplore);
        etSearchbar = view.findViewById(R.id.etSearch);
        btnSearch = view.findViewById(R.id.btnSearch);

        LinearLayoutManager manager = new LinearLayoutManager(context);
        rvExplore.setLayoutManager(manager);

        render("");

        btnSearch.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        search = etSearchbar.getText().toString();
        render(search);
    }

    public void render(String word){

        Retrofit retrofit = APIClient.getRetrofit();
        HerokuService herokuService = retrofit.create(HerokuService.class);

        Call<List<Word>> call = herokuService.getWords(word);

        call.enqueue(new Callback<List<Word>>() {
            @Override
            public void onResponse(Call<List<Word>> call, Response<List<Word>> response) {
                if (response.isSuccessful()){
                    words = response.body();

                    exploreAdapter = new ExploreAdapter(words);
                    rvExplore.setAdapter(exploreAdapter);
                    exploreAdapter.setWords(words);
                }
            }

            @Override
            public void onFailure(Call<List<Word>> call, Throwable t) {
                Log.i("MYLOGS", t.getMessage());
            }
        });
    }
}