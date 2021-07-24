package com.gregorius.myawesomedictionary;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Vector;

public class ExploreFragment extends Fragment {

    Context context;
    Vector<String> listWord;
    RecyclerView rvExplore;
    ExploreAdapter exploreAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        listWord = new Vector<>();
        listWord.add("Alpha");
        listWord.add("Beta");
        listWord.add("Charlie");
        listWord.add("Delta");
        listWord.add("Epoch");
        listWord.add("Franklin");
        listWord.add("Ginette");

        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        rvExplore = view.findViewById(R.id.rvExplore);

        LinearLayoutManager manager = new LinearLayoutManager(context);
        rvExplore.setLayoutManager(manager);

        exploreAdapter = new ExploreAdapter(listWord);
        rvExplore.setAdapter(exploreAdapter);

        return view;
    }
}