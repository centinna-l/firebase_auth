package com.example.firebaseauth;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class ApplicationStart extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_start);

//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        Intent intent;
//        if (user != null) {
//                if (user.getProviderData().equals("firebase")) {
//                    intent = new Intent(ApplicationStart.this, MainActivity.class);
//                    intent.putExtra("provider", "firebase");
//                    startActivity(intent);
//                    finish();
//                } else {
//                    intent = new Intent(ApplicationStart.this, MainActivity.class);
//                    intent.putExtra("provider", "google");
//                    startActivity(intent);
//                    finish();
//                }
//
//        } else {
////            startActivity(new Intent(ApplicationStart.this, LoginActivity.class));
//            finish();
//        }

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(ApplicationStart.this, MainActivity.class));
            finish();
        } else {
            startActivity(new Intent(ApplicationStart.this, LoginActivity.class));
            finish();
        }
    }
}