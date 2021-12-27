package com.example.foody.adapters1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foody.R;
import com.example.foody.models1.CartModel;

import java.util.List;

public class CartAdapder  extends RecyclerView.Adapter<CartAdapder.ViewHolder> {
   List<CartModel> list;

    public CartAdapder(List<CartModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mycart_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.rating.setText(list.get(position).getRating());
        holder.price.setText(list.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,rating,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.detailed_img);
            name=itemView.findViewById(R.id.detailed_name);
            rating=itemView.findViewById(R.id.datailed_rating);
            price=itemView.findViewById(R.id.textView9);


        }
    }
}