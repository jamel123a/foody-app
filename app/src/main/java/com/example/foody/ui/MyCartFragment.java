package com.example.foody.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foody.R;
import com.example.foody.adapters1.CartAdapder;
import com.example.foody.models1.CartModel;

import java.util.ArrayList;
import java.util.List;


public class MyCartFragment extends Fragment {

    List<CartModel> list;
    CartAdapder cartAdapder;
    RecyclerView recyclerView;

    public MyCartFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_my_cart,container,false);

        recyclerView =view.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list=new ArrayList<>();
        list.add(new CartModel(R.drawable.s1,"order 1","40","4.3"));
        list.add(new CartModel(R.drawable.s2,"order 1","50","4.3"));
        list.add(new CartModel(R.drawable.fav1,"order 1","30","4.3"));
        list.add(new CartModel(R.drawable.s1,"order 1","20","4.3"));
        list.add(new CartModel(R.drawable.s2,"order 1","40","4.3"));
        list.add(new CartModel(R.drawable.fav1,"order 1","20","4.3"));
        cartAdapder=new CartAdapder(list);
        recyclerView.setAdapter(cartAdapder);
        return  view;

    }
}