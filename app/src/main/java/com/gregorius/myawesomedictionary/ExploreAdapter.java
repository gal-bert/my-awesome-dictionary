package com.gregorius.myawesomedictionary;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ViewHolder> {

    List<Word> words;
    Context context;
    String word;

    public ExploreAdapter(List<Word> words){
        this.words = words;
    }

    public void setWords(List<Word> words){
        this.words = words;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvWord;
        Button btnSave;

        public ViewHolder(View itemView) {
            super(itemView);
            tvWord = itemView.findViewById(R.id.tvWord);
            btnSave = itemView.findViewById(R.id.btnSave);

            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    word = words.get(position).getWord();
                    ExploreHelper exploreHelper = new ExploreHelper(view.getContext());
                    exploreHelper.insert(word);
                    Toast.makeText(view.getContext(), "Word saved successfully!", Toast.LENGTH_SHORT).show();
                    FavoritesFragment.refresh();
                }
            });

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            word = words.get(position).getWord();
            Log.i("MYLOG", "WORD: " + word);

            Intent intent = new Intent(itemView.getContext(), ShowActivity.class);
            intent.putExtra("WORD", word);

            itemView.getContext().startActivity(intent);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.explore_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvWord.setText(words.get(position).getWord());
    }

    @Override
    public int getItemCount() {
        return words.size();
    }


}
