package com.gregorius.myawesomedictionary;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder> {

    List<Definition> definitions;
    Context context;

    public ShowAdapter(Context context){
        this.context = context;
        this.definitions = new ArrayList<>();
    }

    public void setDefinitions(List<Definition> definitions) {
        this.definitions = definitions;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvType, tvDesc;
        ImageView imvImage;

        public ViewHolder(View itemView) {
            super(itemView);
            tvType = itemView.findViewById(R.id.tvType);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            imvImage = itemView.findViewById(R.id.imvImage);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvType.setText("Type: " + definitions.get(position).getType());
        holder.tvDesc.setText(definitions.get(position).getDefinition());
        Log.i("MYLOG", "IMG URL: " + definitions.get(position).getImage_url());
        Glide.with(context).load(definitions.get(position).getImage_url()).fallback(R.drawable.ic_launcher_foreground).into(holder.imvImage);

    }

    @Override
    public int getItemCount() {
        return definitions.size();
    }

}
