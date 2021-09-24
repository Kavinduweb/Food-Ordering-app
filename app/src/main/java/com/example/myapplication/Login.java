package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private Button logbtn;
    private EditText email , pass ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        logbtn = findViewById(R.id.log_btn);
        email = findViewById(R.id.emaillog);
        pass = (EditText)findViewById(R.id.log_pass);

        logbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                login();
            }
        });



    }

    public void login(){


        if(email.getText().toString().equals("admin") && pass.getText().toString().equals("admin"))
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }
        else{
            Toast toast = Toast.makeText(this,"Login Fail",Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}