package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Delete extends AppCompatActivity {
    private Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        cancel = (Button)findViewById(R.id.cancel1);
        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                cancelActivity();
            }
        });
    }

    public void cancelActivity(){
        Intent intent = new Intent(this,PaymentHome.class);
        startActivity(intent);
    }
}