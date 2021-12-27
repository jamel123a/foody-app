package com.example.foody.adapters1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foody.models1.HomeVerModel;
import com.example.foody.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class HomeVerAdapter  extends RecyclerView.Adapter<HomeVerAdapter.ViewHolder> {
  private BottomSheetDialog bottomSheetDialog;
    Context context;
 ArrayList<HomeVerModel> list;

    public HomeVerAdapter(ArrayList<HomeVerModel> list,Context context) {
        this.list = list;
        this.context=context;
    }

    @NonNull
    @Override
    public HomeVerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return   new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull HomeVerAdapter.ViewHolder holder, int position) {

        final String mName =list.get(position).getName();
        final String  mTiming=list.get(position).getTiming();
        final String mRating =list.get(position).getRating();
        final String mPrice =list.get(position).getPrice();
        final int mImage =list.get(position).getImage();


        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.timing.setText(list.get(position).getTiming());
        holder.rating.setText(list.get(position).getRating());
        holder.price.setText(list.get(position).getPrice());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog=new BottomSheetDialog(context,R.style.BottomSheetTheme);

                View sheetView=LayoutInflater.from(context).inflate(R.layout.buttom_item_layout,null);
                sheetView.findViewById(R.id.add_to_cart).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"added to a card",Toast.LENGTH_LONG).show();
                        bottomSheetDialog.dismiss();
                    }
                });
                ImageView bottomImg=sheetView.findViewById(R.id.bottom_img);
                TextView bottomName=sheetView.findViewById(R.id.bottom_name);
                TextView bottomPrice=sheetView.findViewById(R.id.bottom_prive);
                TextView bottomRatting=sheetView.findViewById(R.id.bottom_rating);

                bottomName.setText(mName);
                bottomPrice.setText(mPrice);
                bottomRatting.setText(mRating);
                bottomImg.setImageResource(mImage);

                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,timing,rating,price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.ver_img);
            name =itemView.findViewById(R.id.name);
            timing =itemView.findViewById(R.id.timing);
            rating =itemView.findViewById(R.id.rating);
            price =itemView.findViewById(R.id.price);


        }
    }
}
