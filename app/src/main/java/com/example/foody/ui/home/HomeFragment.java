package com.example.foody.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foody.R;
import com.example.foody.adapters1.HomeHorApadter;
import com.example.foody.adapters1.HomeVerAdapter;
import com.example.foody.adapters1.UpdateVerticaleRec;
import com.example.foody.models1.HomeHorModel;
import com.example.foody.models1.HomeVerModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment  implements UpdateVerticaleRec {
  RecyclerView homeHorizontaleRec,homeVerticaleRec;
  ArrayList<HomeHorModel> homeHorModelsList;
  HomeHorApadter homeHorApadter;
  // verticale home

    ArrayList<HomeVerModel>homeVerModellist;
    HomeVerAdapter homeVerAdapter;
    EditText text;
    DatabaseReference ref;
    FirebaseDatabase data;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root =inflater.inflate(R.layout.fragment_home,container,false);

      homeHorizontaleRec =root.findViewById(R.id.home_hor_rec);
      homeVerticaleRec =root.findViewById(R.id.home_ver_rec);
      FirebaseDatabase.getInstance();


  /// horizontale
      homeHorModelsList =new ArrayList<>();
      homeHorModelsList.add(new HomeHorModel("Pizza", R.drawable.pizza));
      homeHorModelsList.add(new HomeHorModel("HamBurger", R.drawable.hamburger));
      homeHorModelsList.add(new HomeHorModel("Fried", R.drawable.fried_potatoes));
      homeHorModelsList.add(new HomeHorModel("Ice Cream", R.drawable.ice_cream));
      homeHorModelsList.add(new HomeHorModel("Sandwish", R.drawable.sandwich));

      homeHorApadter =new HomeHorApadter(homeHorModelsList, this, getActivity());
      homeHorizontaleRec.setAdapter(homeHorApadter);

        homeHorizontaleRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontaleRec.setHasFixedSize(true);
        homeHorizontaleRec.setNestedScrollingEnabled(false);
        // verticale
      homeVerModellist=new ArrayList<>();

      homeVerAdapter =new HomeVerAdapter(homeVerModellist, getActivity());
      homeVerticaleRec.setAdapter(homeVerAdapter);
      homeVerticaleRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));

      return root;
    }

  @Override
  public void callBack(int position, ArrayList<HomeVerModel> list) {
    homeVerAdapter =new HomeVerAdapter(list, getContext());
    homeVerAdapter.notifyDataSetChanged();
    homeVerticaleRec.setAdapter(homeVerAdapter);

  }
}