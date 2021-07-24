package com.gregorius.myawesomedictionary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ShowActivity extends AppCompatActivity {

    TextView tvWord;
    RecyclerView rvShow;
    String intentWord;
    List<Word> words;
    List<Definition> definitions;
    ShowAdapter showAdapter;
    Context context;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        actionBar();

        tvWord = findViewById(R.id.tvWord);
        rvShow = findViewById(R.id.rvShow);
        btnSave = findViewById(R.id.btnSave);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvShow.setLayoutManager(manager);
        showAdapter = new ShowAdapter(this);
        rvShow.setAdapter(showAdapter);

        Intent intent = getIntent();
        intentWord = intent.getStringExtra("WORD");

        tvWord.setText("Word: " + intentWord);

        Retrofit retrofit = APIClient.getRetrofit();
        HerokuService herokuService = retrofit.create(HerokuService.class);

        Call<List<Word>> call = herokuService.getWords(intentWord);

        call.enqueue(new Callback<List<Word>>() {
            @Override
            public void onResponse(@NotNull Call<List<Word>> call, @NotNull Response<List<Word>> response) {
                if (response.isSuccessful()){
                    words = response.body();

                    for(Word word : words){
                        Log.i("MYLOGS", word.getWord());
                        definitions = word.getDefinitions();
                        for(Definition definition : definitions){
                            Log.i("MYLOGS", definition.getDefinition());
                        }
                    }

                    showAdapter.setDefinitions(definitions);

                }
            }

            @Override
            public void onFailure(Call<List<Word>> call, Throwable t) {

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExploreHelper exploreHelper = new ExploreHelper(view.getContext());
                exploreHelper.insert(intentWord);
                Toast.makeText(view.getContext(), "Word saved successfully!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    public void actionBar(){
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}