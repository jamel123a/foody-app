package com.example.foody.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.foody.R;

public class forgetSuccessMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_success_message);


    }
    public  void  login(View view){
        Intent intent =new Intent(forgetSuccessMessage.this,Login.class);
        startActivity(intent);
    }
}