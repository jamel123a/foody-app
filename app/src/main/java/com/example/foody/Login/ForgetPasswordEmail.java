package com.example.foody.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.foody.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPasswordEmail extends AppCompatActivity {

    ///les variable
     EditText editTextEmail;
     FirebaseAuth auth;
     ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_email);
         ////// put id to virable
        editTextEmail=(EditText) findViewById(R.id.email_forget);
        auth=FirebaseAuth.getInstance();
        progressBar=(ProgressBar) findViewById(R.id.progressBar3);

    }
    public  void next(View v){
         resetPassword();
    }

    private void resetPassword() {
        String textEmail=editTextEmail.getText().toString().trim();
        //virification est ce qui email exist
        if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()){
            editTextEmail.setError(("please enter your email"));
            editTextEmail.requestFocus();
            return;
        }
        // methode porget password email
        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(textEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgetPasswordEmail.this, "please check your email", Toast.LENGTH_LONG).show();
                    Intent intent =new Intent(ForgetPasswordEmail.this,forgetSuccessMessage.class);
                    startActivity(intent);
                    progressBar.setVisibility(View.GONE);
                }
                else{
                    Toast.makeText(ForgetPasswordEmail.this, "failled to reset  email", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}