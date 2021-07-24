package com.gregorius.myawesomedictionary;

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

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {

    List<String> words;
    String word;

    public FavoritesAdapter(List<String> words){
        this.words = words;
    }

    public void setWords(List<String> words){
        this.words = words;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvWord;
        Button btnDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            tvWord = itemView.findViewById(R.id.tvWord);
            btnDelete = itemView.findViewById(R.id.btnDelete);

            btnDelete.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    word = words.get(position);

                    ExploreHelper exploreHelper = new ExploreHelper(view.getContext());
                    exploreHelper.delete(word);
                    words.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, words.size());

                }
            });

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            word = words.get(position);
            Log.i("MYLOG", "WORD: " + word);

            Intent intent = new Intent(itemView.getContext(), ShowActivity.class);
            intent.putExtra("WORD", word);

            itemView.getContext().startActivity(intent);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourites_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvWord.setText(words.get(position));
    }

    @Override
    public int getItemCount() {
        return words.size();
    }
}
