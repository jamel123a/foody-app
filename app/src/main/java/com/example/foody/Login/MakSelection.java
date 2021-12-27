package com.example.foody.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.foody.R;

public class MakSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mak_selection);
    }
    public  void  email(View view){
        Intent intent =new Intent(MakSelection.this,ForgetPasswordEmail.class);
        startActivity(intent);
    }
    public  void  phone(View view){
        Intent intent =new Intent(MakSelection.this,ForgetPasswordPhone.class);
        startActivity(intent);
    }
}