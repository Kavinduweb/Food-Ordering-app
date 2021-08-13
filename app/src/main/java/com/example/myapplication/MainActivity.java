package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button ;
    private Button delete;
    private Button cancel;
    private Button edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.add_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addActivity();
            }
        });

        delete =(Button) findViewById(R.id.delete_btn);
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                deleteActivity();
            }
        });

        edit =(Button) findViewById(R.id.edit1);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editActivity();
            }
        });



    }

    public void addActivity (){

        Intent intent = new Intent(this,Adding.class);
        startActivity(intent);

    }
    public void deleteActivity(){
        Intent intent =new Intent(this,Delete.class);
        startActivity(intent);

    }
    public void editActivity(){
        Intent intent =new Intent(this,Edit.class);
                startActivity(intent);
    }

}
