package com.example.foody.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foody.Models.PlateModel;
import com.example.foody.R;

import java.util.List;

public class PlateAdapter extends RecyclerView.Adapter<PlateAdapter.PlateViewHolder> {
    private List<PlateModel>plateModelsList;
    private Context context;

    public PlateAdapter(List<PlateModel> plateModelsList,Context context) {
        this.plateModelsList = plateModelsList;
        this.context=context;
    }

    @NonNull
    @Override
    public PlateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.plates,viewGroup,false);
        return  new PlateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlateViewHolder holder, int position) {
        PlateModel plateModel=plateModelsList.get(position);
        Glide.with(context).load(plateModel.getPlate_img()).into(holder.plateImg);

    }

    @Override
    public int getItemCount() {

        return plateModelsList.size();
    }

    public class PlateViewHolder extends RecyclerView.ViewHolder {
        private ImageView plateImg;
        public PlateViewHolder(@NonNull View itemView) {

            super(itemView);
            plateImg=(ImageView)itemView.findViewById(R.id.imageView2);
        }
    }
}
