package com.example.foody.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foody.R;
import com.example.foody.adapters1.FeaturedAdapter;
import com.example.foody.adapters1.FeaturedVerAdapter;
import com.example.foody.models1.FeaturedModel;
import com.example.foody.models1.FeaturedVerModel;

import java.util.ArrayList;
import java.util.List;


public class FirstFragment extends Fragment {



    /// horizontale
   List<FeaturedModel> featuredModelList;
   RecyclerView recyclerView;
   FeaturedAdapter featuredAdapter;

   /// verticale
   List<FeaturedVerModel> featuredVerModelList;
   RecyclerView recyclerView2;
   FeaturedVerAdapter featuredVerAdapter;


  public FirstFragment(){

  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_first,container,false);

        // hor
        recyclerView=view.findViewById(R.id.featured_hor_rec) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        featuredModelList =new ArrayList<>();

        featuredModelList.add(new FeaturedModel(R.drawable.fav1,"featured 1","description 1"));
        featuredModelList.add(new FeaturedModel(R.drawable.fav2,"featured 2","description 2"));
        featuredModelList.add(new FeaturedModel(R.drawable.fav3,"featured 3","description 3"));

        featuredAdapter=new FeaturedAdapter(featuredModelList);
        recyclerView.setAdapter(featuredAdapter);

        // ver
        recyclerView2=view.findViewById(R.id.featured_ver_rec) ;
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        featuredVerModelList =new ArrayList<>();

        featuredVerModelList.add(new FeaturedVerModel(R.drawable.ver1,"Featured 1","description 1","4.8","10:00 - 19:00"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.ver2,"Featured 2","description 2","4.8","10:00 - 19:00"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.ver3,"Featured 3","description 3","4.8","10:00 - 19:00"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.ver1,"Featured 1","description 1","4.8","10:00 - 19:00"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.ver2,"Featured 2","description 2","4.8","10:00 - 19:00"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.ver3,"Featured 3","description 3","4.8","10:00 - 19:00"));
        featuredVerAdapter=new FeaturedVerAdapter(featuredVerModelList);
        recyclerView2.setAdapter(featuredVerAdapter);

        return  view;
    }
}