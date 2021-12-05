package com.oyelabs.marvel.universe.adapters;

import android.content.Context;
import android.view.LayoutInflater;
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
    public static Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<marvelData> filtereddata = new ArrayList<>();

            if (charSequence.toString().isEmpty()){
                filtereddata.addAll(backup);

            }
            else{
                for(marvelData obj : backup){
                    if(obj.getName()
                            .toLowerCase().
                                    contains(charSequence.toString().toLowerCase()));
                            filtereddata.add(obj);
                }
            }
            FilterResults results = new FilterResults();
            results.values = filtereddata;

            return results;

        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
           arrayMarvel.clear();
           arrayMarvel.addAll((ArrayList<marvelData>)filterResults.values);
           notifyDataSetChanged();
        }
    };

    @NonNull
    @Override
    public gridAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.gridlayout,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull gridAdapter.ViewHolder holder, int position) {

        holder.heroName.setText(arrayMarvel.get(position).getName());

        //will implement glide or picasso library here
        //holder.heroImage.setImageURI(arrayMarvel.get(position).getImgurl());
        holder.heroImage.setImageResource(R.drawable.ic_launcher_background);
    }

    @Override
    public int getItemCount() {
        return arrayMarvel.size();
    }
}
