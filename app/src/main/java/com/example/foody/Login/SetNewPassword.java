package com.example.foody.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.foody.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SetNewPassword extends AppCompatActivity {
     EditText passwoord,passwoord1;
     Button next;
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);
        passwoord=findViewById(R.id.editTextPassword);
        passwoord1=findViewById(R.id.editTextPassword1);
       

    }
    public  void Update (View view) {
        String _newPassword=passwoord.getText().toString().trim();
        String _phone=getIntent().getStringExtra("phoneNo");
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Users");
        reference.child(_phone).child("userPassword").setValue(_newPassword);
        startActivity(new Intent(getApplicationContext(),forgetSuccessMessage.class));
        finish();

    }

    
}