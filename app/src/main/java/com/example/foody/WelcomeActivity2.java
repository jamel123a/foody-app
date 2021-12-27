package com.example.foody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.foody.Adapters.PlateAdapter;
import com.example.foody.Login.Login;
import com.example.foody.Login.Register;
import com.example.foody.Models.PlateModel;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity2 extends AppCompatActivity {
     private RecyclerView recyclerView;
     private List<PlateModel> plateModelList;
     private PlateAdapter plateAdaper;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome2);


        ///hide status bar start
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.
                    FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        /////// add hilder start   //////////*/

     recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation((RecyclerView.HORIZONTAL));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setKeepScreenOn(true);
        recyclerView.setHasFixedSize(true);

        plateModelList=new ArrayList<>();
        plateModelList.add(new PlateModel(R.drawable.plat));
        plateModelList.add(new PlateModel(R.drawable.ver1));
        plateModelList.add(new PlateModel(R.drawable.s4));
        plateModelList.add(new PlateModel(R.drawable.sweets));
        plateModelList.add(new PlateModel(R.drawable.ver3));
        plateModelList.add(new PlateModel(R.drawable.s1));
        plateModelList.add(new PlateModel(R.drawable.ver2));
        plateModelList.add(new PlateModel(R.drawable.s3));

        plateAdaper=new PlateAdapter(plateModelList,this);
        recyclerView.setAdapter(plateAdaper);
        plateAdaper.notifyDataSetChanged();
//////  calll autoScroll
        autoScroll();

        ///// and autoScroll
    }
    public  void login(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.login_btn), "transition_login");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(WelcomeActivity2.this, pairs);
        startActivity(intent, options.toBundle());
       }
        else{
             startActivity(intent);
        }
        }
    public  void register(View view) {
        Intent intent = new Intent(getApplicationContext(), Register.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.register_btn), "transition_register");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(WelcomeActivity2.this, pairs);
            startActivity(intent, options.toBundle());
        }
        else{
            startActivity(intent);
        }
    }



    public  void  autoScroll(){
        final int speedScroll=0;
        final Handler handler=new Handler();
        final Runnable runnable=new Runnable() {
            int count=0;
            @Override
            public void run() {
                if (count==plateAdaper.getItemCount())
                    count=0;
                if (count<plateAdaper.getItemCount()){
                    recyclerView.smoothScrollToPosition(++count);
                    handler.postDelayed(this,speedScroll);
                }
            }
        };
        handler.postDelayed(runnable,speedScroll);
    }

    }
