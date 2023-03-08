package com.example.firebaseauth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

//    TextView userName;
//    Button logout;
//    GoogleSignInClient gClient;
//    GoogleSignInOptions gOptions;
//    FirebaseAuth auth;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        auth = FirebaseAuth.getInstance();
//        gOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
//        gClient = GoogleSignIn.getClient(this, gOptions);
//        logout = findViewById(R.id.logout);
//        userName = findViewById(R.id.userName);
//
//        String user;
//        user = FirebaseAuth.getInstance().getCurrentUser().getProviderId().toString();
//
//        Intent intent = getIntent();
//        String provider = intent.getStringExtra("provider").toString();
//        Log.d("MAIN ACTIITY", auth.getCurrentUser().getProviderId());
//
//        if (provider.equals("firebase")) {
//            userName.setText("EMAIL and Password");
//            logout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
//        } else {
//            GoogleSignInAccount gAccount = GoogleSignIn.getLastSignedInAccount(this);
//            if (gAccount != null) {
//                String gName = gAccount.getDisplayName();
//                userName.setText(gName);
//            }
//        }
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (provider.equals("firebase")) {
//                    FirebaseAuth.getInstance().signOut();
//                    startActivity(new Intent(MainActivity.this, ApplicationStart.class));
//                    finish();
//                } else {
//                    gClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            finish();
//                            startActivity(new Intent(MainActivity.this, LoginActivity.class));
//                        }
//                    });
//                    //
//
//                }
//
//            }
//        });
//
//
////
////
//
//    }

    private FirebaseAuth auth;
    private TextView name;
    private Button logout;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
//        name = (TextView) findViewById(R.id.name);
        logout = (Button) findViewById(R.id.logout);
//        fab = (FloatingActionButton) findViewById(R.id.fab_add);

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, UploadActivity.class));
//            }
//        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                startActivity(new Intent(MainActivity.this, ApplicationStart.class));
                finish();
            }
        });
    }
}