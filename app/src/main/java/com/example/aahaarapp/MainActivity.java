package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {


    CardView history,generateQR;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        history = findViewById(R.id.cardHistory);


        generateQR = findViewById(R.id.generateQR);
        fAuth= FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser() ==null){
            Intent intent = new Intent(MainActivity.this, landingpage.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }



        history.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserdataActivity.class);
                startActivity(intent);
            }
        });
       generateQR.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
               startActivity(intent);
           }
       });

    }
}
