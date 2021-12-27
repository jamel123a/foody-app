package com.example.foody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.foody.adapters1.DetailedDailyAdapter;
import com.example.foody.models1.DetailedDailyModel;

import java.util.ArrayList;
import java.util.List;

public class DetailedDailyMealActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DetailedDailyModel>detailedDailyModelList;
    DetailedDailyAdapter dailyAdapter;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_daily_meal);


        String type =getIntent().getStringExtra("type");


        recyclerView=findViewById(R.id.detailed_rec);
        imageView=findViewById(R.id.detailed_img);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailedDailyModelList=new ArrayList<>();
        dailyAdapter=new DetailedDailyAdapter(detailedDailyModelList);
        recyclerView.setAdapter(dailyAdapter);

        if (type!= null && type.equalsIgnoreCase("breakfast")){
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.fav1,"Breakfast","descrption","4.3","40$","10:00 - 18-00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.fav2,"Breakfast","descrption","4.3","40$","10:00 - 18-00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.fav3,"Breakfast","descrption","4.3","40$","10:00 - 18-00"));
            dailyAdapter.notifyDataSetChanged();

        }
        if (type!= null && type.equalsIgnoreCase("sweets")){

            imageView.setImageResource(R.drawable.sweets);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s1,"Breakfast","descrption","4.3","40$","10:00 - 18-00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s2,"Breakfast","descrption","4.3","40$","10:00 - 18-00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s3,"Breakfast","descrption","4.3","40$","10:00 - 18-00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s4,"Breakfast","descrption","4.3","40$","10:00 - 18-00"));

            dailyAdapter.notifyDataSetChanged();

        }
        if (type!= null && type.equalsIgnoreCase("dinner")){

            imageView.setImageResource(R.drawable.dinner);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s1,"Breakfast","descrption","4.3","40$","10:00 - 18-00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s2,"Breakfast","descrption","4.3","40$","10:00 - 18-00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s3,"Breakfast","descrption","4.3","40$","10:00 - 18-00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s4,"Breakfast","descrption","4.3","40$","10:00 - 18-00"));

            dailyAdapter.notifyDataSetChanged();

        }
        if (type!= null && type.equalsIgnoreCase("lunch")) {

            imageView.setImageResource(R.drawable.lunch);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s1, "Breakfast", "descrption", "4.3", "40$", "10:00 - 18-00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s2, "Breakfast", "descrption", "4.3", "40$", "10:00 - 18-00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s3, "Breakfast", "descrption", "4.3", "40$", "10:00 - 18-00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s4, "Breakfast", "descrption", "4.3", "40$", "10:00 - 18-00"));

            dailyAdapter.notifyDataSetChanged();
        }
        if (type!= null && type.equalsIgnoreCase("coffe")) {

            imageView.setImageResource(R.drawable.coffe);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s1, "Breakfast", "descrption", "4.3", "40$", "10:00 - 18-00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s2, "Breakfast", "descrption", "4.3", "40$", "10:00 - 18-00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s3, "Breakfast", "descrption", "4.3", "40$", "10:00 - 18-00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s4, "Breakfast", "descrption", "4.3", "40$", "10:00 - 18-00"));

            dailyAdapter.notifyDataSetChanged();
        }



    }
}
