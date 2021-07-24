package com.gregorius.myawesomedictionary;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
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

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FavoritesFragment extends Fragment {

    static Context context;
    RecyclerView rvFavorites;
    static List<String> words;
    static FavoritesAdapter favoritesAdapter;
    static ExploreHelper exploreHelper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        context = container.getContext();

        rvFavorites = view.findViewById(R.id.rvFavorites);

        exploreHelper = new ExploreHelper(getContext());
        words = exploreHelper.selectAll();

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

    @Override
    public void onStart() {
        super.onStart();

        exploreHelper = new ExploreHelper(getContext());
        words = exploreHelper.selectAll();
        favoritesAdapter.setWords(words);
    }

    public static void refresh(){
        exploreHelper = new ExploreHelper(context);
        words = exploreHelper.selectAll();
        favoritesAdapter.setWords(words);
    }

}