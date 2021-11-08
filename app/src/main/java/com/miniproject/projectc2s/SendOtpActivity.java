package com.miniproject.projectc2s;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SendOtpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_otp);
         EditText inputMobile=findViewById(R.id.inputMobile);

        Button buttonGetOtp=findViewById(R.id.buttonGetOtp);

         ProgressBar progressBar=findViewById(R.id.progressBar);
        buttonGetOtp.setOnClickListener(view -> {
            if(inputMobile.getText().toString().trim().isEmpty()){
                Toast.makeText(SendOtpActivity.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                return;
            }

            progressBar.setVisibility(View.VISIBLE);
            buttonGetOtp.setVisibility(View.INVISIBLE);
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                    "+91"+inputMobile.getText().toString(),
                    60,
                    TimeUnit.SECONDS,
                    SendOtpActivity.this,
                    new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){


                        @Override
                        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                            progressBar.setVisibility(View .GONE);
                            buttonGetOtp.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onVerificationFailed(@NonNull FirebaseException e) {
                          progressBar.setVisibility(View .GONE);
                          buttonGetOtp.setVisibility(View.VISIBLE);
                            Toast.makeText(SendOtpActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                            progressBar.setVisibility(View.GONE);
                            buttonGetOtp.setVisibility(View.VISIBLE);
                            Intent intent=new Intent(getApplicationContext(),VerifyOtpActivity.class);
                            intent.putExtra("mobile",inputMobile.getText().toString());
                            intent.putExtra("verificationId",verificationId);
                            startActivity(intent);
                        }
                    }
            );

        });
    }
}