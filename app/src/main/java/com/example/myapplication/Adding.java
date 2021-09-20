package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Adding extends AppCompatActivity {

private Button cancel, add;
private EditText Number,Cvv,Exdate;
private DBHandler dbhandler;
private Context context;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);

        cancel = (Button)findViewById(R.id.cancel);
        Number = findViewById(R.id.Addnumber);
        Exdate = findViewById(R.id.addexdate);
        Cvv = findViewById(R.id.addcvv);
        add = findViewById(R.id.conadd);


        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                cancelActivity();
            }
        });


        context = this;
        dbhandler = new DBHandler(context) ;


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = Number.getText().toString();
                String ex = Exdate.getText().toString();
                String cvv = Cvv.getText().toString();

                CardModle add = new CardModle(num,ex,cvv);
                dbhandler.addNum(add);
                addActivity();

            }
        });
    }
    public void cancelActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void addActivity(){


        Intent intent = new Intent (this,MainActivity.class);
        startActivity(intent);
    }

}
