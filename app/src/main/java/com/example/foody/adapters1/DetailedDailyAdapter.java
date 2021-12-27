package com.example.foody.adapters1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foody.R;
import com.example.foody.models1.DetailedDailyModel;

import java.util.List;

public class DetailedDailyAdapter extends RecyclerView.Adapter<DetailedDailyAdapter.ViewHolder> {
    List<DetailedDailyModel>list;

    public DetailedDailyAdapter(List<DetailedDailyModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public DetailedDailyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.detaled_daily_meal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DetailedDailyAdapter.ViewHolder holder, int position) {
       holder.imageView.setImageResource(list.get(position).getImage());
       holder.price.setText(list.get(position).getPrice());
       holder.description.setText(list.get(position).getDescription());
       holder.name.setText(list.get(position).getName());
       holder.rating.setText(list.get(position).getRating());
       holder.timing.setText(list.get(position).getTiming());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,price,description,rating,timing;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.detailed_img);
            name=itemView.findViewById(R.id.detailed_name);
            description=itemView.findViewById(R.id.datailed_description);
            price=itemView.findViewById(R.id.datailed_prive);
            rating=itemView.findViewById(R.id.datailed_rating);
            timing=itemView.findViewById(R.id.datailed_time);

        }
    }
}
