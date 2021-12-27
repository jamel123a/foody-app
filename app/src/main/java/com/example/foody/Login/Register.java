package com.example.foody.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foody.R;
import com.example.foody.WelcomeActivity2;
import com.example.foody.models1.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
   private  EditText editTextUsername;
    private EditText editTextPassword;
    private  EditText editTextPhoneNo;
    private   EditText editTextEmail;
    private  ProgressBar progressBar;

    private FirebaseAuth auth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);
        editTextUsername =(EditText) findViewById(R.id.editTextUsername);
        editTextPassword=(EditText) findViewById(R.id.editTextPassword);
        editTextPhoneNo =(EditText) findViewById(R.id.editTextTextPhone);
         editTextEmail =(EditText) findViewById(R.id.editTextTextEmail);


        progressBar= (ProgressBar)findViewById(R.id.progressBar);

        auth = FirebaseAuth.getInstance();


    }

    public  void login(View view){
        Intent intent =new Intent(Register.this,Login.class);
        startActivity(intent);
    }
    public  void back(View view){
        Intent intent = new Intent(Register.this, WelcomeActivity2.class);
        startActivity(intent);
    }
    public void RegisterUser (View v) {

        String txtUsename = editTextUsername.getText().toString().trim();
        String txtPassword = editTextPassword.getText().toString().trim();
        String txtPhoneNo = editTextPhoneNo.getText().toString().trim();
        String txtEmail = editTextEmail.getText().toString().trim();

        //virificationn
        if (txtUsename.isEmpty() ||(txtUsename.length() < 5)){
            editTextUsername.setError(" username is to short");
            editTextUsername.requestFocus();
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(txtEmail).matches()) {
            editTextEmail.setError("valide your email");
            editTextEmail.requestFocus();
        }
        if (txtPassword.isEmpty() || txtPassword.length()<6){
            editTextPassword.setError("please enter your containing alleast six chracters");
            editTextPassword.requestFocus();
        }
       if(txtPhoneNo.isEmpty()){
           editTextPhoneNo.setError(" please enter mobile phone");
           editTextPhoneNo.requestFocus();
       }
       progressBar.setVisibility(View.VISIBLE);
       //methode create user
       auth.createUserWithEmailAndPassword(txtEmail,txtPassword)
               .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()) {
                           User user = new User(txtUsename, txtPassword, txtPhoneNo,txtEmail);
                           FirebaseDatabase.getInstance().getReference("Users")
                                 .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                   .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                               @Override
                               public void onComplete(@NonNull Task<Void> task) {
                                   if (task.isSuccessful()) {
                                       Toast.makeText(Register.this, "User Registered succesfuly", Toast.LENGTH_LONG).show();
                                       progressBar.setVisibility(View.GONE);
                                   } else {
                                       Toast.makeText(Register.this, "User   Registered succesfuly", Toast.LENGTH_LONG).show();
                                       progressBar.setVisibility(View.GONE);
                                   }
                               }
                           });


                       } else {
                           Toast.makeText(Register.this, "User Registered  succesfuly", Toast.LENGTH_LONG).show();
                           progressBar.setVisibility(View.GONE);
                       }
                   }
               });

        }

    }




