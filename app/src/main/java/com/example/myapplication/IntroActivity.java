package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ConstraintLayout startBtn = findViewById(R.id.startbtn);
       // startBtn.setOnClickListener(view -> startActivity(new Intent(IntroActivity.this, com.example.myapplication.MainActivity.class)));
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(IntroActivity.this,Login.class);
                startActivity(intent);
            }
        });

    }
}