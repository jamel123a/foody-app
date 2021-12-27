package com.example.foody.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foody.R;

public class SelectForget extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mak_selection);

    }
    public void email(View view){
        Intent intent =new Intent(SelectForget.this,ForgetPasswordEmail.class);
        startActivity(intent);
    }
}
