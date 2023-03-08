package com.example.firebaseauth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText signupEmail, signupPassword;
    private TextView loginRedirect;
    private Button signupButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        auth = FirebaseAuth.getInstance();
        signupEmail = (EditText) findViewById(R.id.signup_email);
        signupPassword = (EditText) findViewById(R.id.signup_password);
        signupButton = (Button) findViewById(R.id.signup_button);
        loginRedirect = (TextView) findViewById(R.id.loginRedirectText);


        loginRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SIGNUP Activity", "text Clicked");
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SIGN UP", "BUtton clicked");
                String email = signupEmail.getText().toString().toLowerCase().trim();
                String password = signupPassword.getText().toString().toLowerCase().trim();

                if (email.isEmpty()) {
                    signupEmail.setError("Email cannot be empty");
                }
                if (password.isEmpty()) {
                    signupPassword.setError("Password cannot be empty");
                }
                if (password.length() < 5) {
                    signupPassword.setError("Password should contain more than 5 characters");
                } else {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "Sign Up Successfull", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                                finish();
                            } else {
                                Toast.makeText(SignUpActivity.this, "Sign Up Successfull", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }


            }
        });

    }
}