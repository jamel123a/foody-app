package com.example.foody.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.example.foody.MainActivity;
import com.example.foody.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.core.view.View;

import java.util.concurrent.TimeUnit;

public class VerietyOTP extends AppCompatActivity {
     PinView  pinfromuser;
     String codeBySystem,whatToDo;
    String _phoneNO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veriety_otp);


        // hooks
        pinfromuser =findViewById(R.id.pin_view);

         _phoneNO =getIntent().getStringExtra("phoneNo");
        whatToDo=getIntent().getStringExtra("whatToDo");
         sendVerificationCodeToUser(_phoneNO);

    }
    private  void sendVerificationCodeToUser (String _phoneNo){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                _phoneNo,
                60,
                TimeUnit.SECONDS,
                (Activity) TaskExecutors.MAIN_THREAD,
                mCallbacks
        );

    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks=
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                @Override
                public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                    super.onCodeSent(s, forceResendingToken);
                    codeBySystem =s;
                }

                @Override
                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                         String code =phoneAuthCredential.getSmsCode();
                         if (code!=null){
                             pinfromuser.setText(code);
                             verifycode(code);
                         }
                }

                @Override
                public void onVerificationFailed(@NonNull FirebaseException e) {

                    Toast.makeText(VerietyOTP.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            };


    private void verifycode(String code) {
            PhoneAuthCredential credentail =PhoneAuthProvider.getCredential(codeBySystem,code);
             signInWithPhoneAuthCredential(credentail);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            storeNewUserData();

                           if (whatToDo.equals("updateData")){
                               updateOldUserData();

                           }else{
                               storeNewUserData();
                           }
                        /*    Toast.makeText(VerietyOTP.this,"Verifaction  Completed",Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(VerietyOTP.this, MainActivity.class);
                            startActivity(intent);*/

                        /*} else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                    Toast.makeText(VerietyOTP.this,"verifacation not completed! try again",Toast.LENGTH_SHORT);
                            }*/

                            }else {
                                if (task.getException()instanceof FirebaseAuthInvalidCredentialsException){
                                    Toast.makeText(VerietyOTP.this,"Verificatoin not complete try again",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                });
    }

    private void  updateOldUserData() {
        Intent intent =new Intent(getApplicationContext(),SetNewPassword.class);
        intent.putExtra("phoneNo",_phoneNO);
        startActivity(intent);
        finish();
    }

    private void storeNewUserData() {
    }

    public  void callNextScreenFromOTP(View view){
        String code =pinfromuser.getText().toString();
        if(!code.isEmpty()){
            verifycode(code);
        }
     }

}