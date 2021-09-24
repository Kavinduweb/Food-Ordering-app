package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RequestMainActivity extends AppCompatActivity {

    EditText editText_name, editText_email, editText_category, editText_type;
    Button button_add, button_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_main);

        editText_name = findViewById(R.id.edittext_name);
        editText_email = findViewById(R.id.edittext_email);
        editText_category = findViewById(R.id.edittext_category);
        editText_type = findViewById(R.id.edittext_type);
        button_add = findViewById(R.id.button_add);
        button_view = findViewById(R.id.button_view);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = editText_name.getText().toString();
                String stringEmail = editText_email.getText().toString();
                String stringCategory = editText_category.getText().toString();
                String stringType = editText_type.getText().toString();

                if (stringName.length() <= 0 || stringEmail.length() <= 0 || stringCategory.length() <= 0 || stringType.length() <= 0) {
                    Toast.makeText(RequestMainActivity.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                } else {
                    DatabaseRequestClass databaseRequestClass = new DatabaseRequestClass(RequestMainActivity.this);
                    RequestModelClass requestModelClass = new RequestModelClass(stringName, stringEmail, stringCategory, stringType);
                    databaseRequestClass.addRequest(requestModelClass);
                    Toast.makeText(RequestMainActivity.this, "Add Request Successfully", Toast.LENGTH_SHORT).show();

                    finish();
                    startActivity(getIntent());
                }
            }
        });

        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RequestMainActivity.this, ViewRequestActivity.class);
                startActivity(intent);
            }
        });
    }
}