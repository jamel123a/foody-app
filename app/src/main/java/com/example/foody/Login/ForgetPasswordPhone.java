package com.example.foody.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.foody.MainActivity;
import com.example.foody.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;

public class ForgetPasswordPhone extends AppCompatActivity {
    private CountryCodePicker countryCodePicker;
     private TextView phone;
     private Button next;
     ProgressBar progressBar;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_phone);


        // hooks
        countryCodePicker= findViewById(R.id.country_code_picker);
        phone= findViewById(R.id.phone_forget);
        next=findViewById(R.id.button);
        progressBar =findViewById(R.id.progressBar4);
        auth=FirebaseAuth.getInstance();



    }
    public void next (View view) {
          String _phone = phone.getText().toString().trim();
         final String _competePhoneNumber ="+" + countryCodePicker.getFullNumber()+_phone;
      /// cheack user
        Query   cheackuser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phoneNo").equalTo(_phone);
        cheackuser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    phone.setError(null);

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("phoneNo", _competePhoneNumber);
                    intent.putExtra("whatToDo","updateData" );
                    startActivity(intent);
                    finish();
                    progressBar.setVisibility(View.GONE);
                } else
                    progressBar.setVisibility(View.GONE);
                phone.setError("no such user exist");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}