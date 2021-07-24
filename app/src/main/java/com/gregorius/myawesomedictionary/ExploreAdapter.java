package com.gregorius.myawesomedictionary;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Vector;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ViewHolder> {

    List<WordListResponse> wordListResponses;

    public ExploreAdapter(List<WordListResponse> wordListResponses){
        this.wordListResponses = wordListResponses;
    }

    public void setListWord(List<WordListResponse> wordListResponses){
        this.wordListResponses = wordListResponses;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvWord;

        public ViewHolder(View itemView) {
            super(itemView);
            tvWord = itemView.findViewById(R.id.tvWord);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.explore_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WordListResponse wordListResponse = wordListResponses.get(position);
        holder.tvWord.setText(wordListResponse.word);
    }

    @Override
    public int getItemCount() {
        return wordListResponses.size();
    }


}
