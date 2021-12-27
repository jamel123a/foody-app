package com.example.foody.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foody.MainActivity;
import com.example.foody.R;
import com.example.foody.WelcomeActivity2;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText username , password;
    TextView ForgetPaswword , register;
    ProgressBar progressBar;

    FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText) findViewById(R.id.editTextName);
        password=(EditText)findViewById(R.id.editTextPassword);
        progressBar=(ProgressBar) findViewById(R.id.progressBar2);

        auth=FirebaseAuth.getInstance();


    }


  public void LoginUser(View view){
       String userEmail =username.getText().toString().trim();
      String userPassword=password.getText().toString().trim();
      // verification
      if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
          username.setError("please valid your email  ");
          username.requestFocus();
      }
      if(password.length()<6){
          password.setError("please enter password containig atleast 6 caractere");
          password.requestFocus();
      }
     progressBar.setVisibility(View.VISIBLE);
      auth.signInWithEmailAndPassword(userEmail,userPassword)
              .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                        /// c'est existe
                        if (task.isSuccessful()){
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(Login.this, "user sucessfully signet in ", Toast.LENGTH_LONG).show();
                            Intent intent =new Intent(Login.this, MainActivity.class);
                            startActivity(intent);
                        }
                        // ce non
                        else{
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(Login.this, " user nooo sucessfully signet in", Toast.LENGTH_LONG).show();
                         /*   Intent intent =new Intent(Login.this, MainActivity.class);
                            startActivity(intent);*/

                        }
                    }
              });




    }
    /// call anather class
    public  void register(View view){
        Intent intent =new Intent(Login.this,Register.class);
        startActivity(intent);
    }
    public  void forget_password(View view){
        Intent intent = new Intent(Login.this,MakSelection.class);
        startActivity(intent);
    }
    public  void back(View view){
        Intent intent = new Intent(Login.this, WelcomeActivity2.class);
        startActivity(intent);
    }
 }
