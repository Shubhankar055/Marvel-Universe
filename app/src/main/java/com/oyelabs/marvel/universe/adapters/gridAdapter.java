package com.oyelabs.marvel.universe.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oyelabs.marvel.universe.R;
import com.oyelabs.marvel.universe.models.marvelData;
import java.util.ArrayList;

public class gridAdapter extends RecyclerView.Adapter<gridAdapter.ViewHolder>implements Filterable {
    private ArrayList<marvelData> arrayMarvel;
    ArrayList <marvelData> backup;
    Context context;

    public gridAdapter (ArrayList<marvelData> arrayMarvel, Context context){
        this.arrayMarvel = arrayMarvel;
        backup = new ArrayList<>(arrayMarvel);
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView heroName;
        ImageView heroImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heroImage = itemView.findViewById(R.id.gridImage);
            heroName =itemView.findViewById(R.id.gridText);

        }
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public gridAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull gridAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrayMarvel.size();
    }
}
