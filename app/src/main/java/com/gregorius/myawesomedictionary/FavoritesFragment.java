package com.gregorius.myawesomedictionary;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

public class FavoritesFragment extends Fragment {

    Context context;
    RecyclerView rvFavorites;
    List<String> words;
    FavoritesAdapter favoritesAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        rvFavorites = view.findViewById(R.id.rvFavorites);

        ExploreHelper exploreHelper = new ExploreHelper(getContext());
        words = exploreHelper.selectAll();

        for(String word : words){
            Log.i("MYLOG", word);
        }

        LinearLayoutManager manager = new LinearLayoutManager(context);
        rvFavorites.setLayoutManager(manager);

        favoritesAdapter = new FavoritesAdapter(words);
        rvFavorites.setAdapter(favoritesAdapter);
        favoritesAdapter.setWords(words);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}