package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeliveryMainActivity extends AppCompatActivity {

    EditText editText_name,editText_address,editText_location,editText_number;
    Button button_add,button_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_delivery);

        editText_name = findViewById(R.id.edittext_name);
        editText_address = findViewById(R.id.edittext_address);
        editText_location = findViewById(R.id.edittext_location);
        editText_number = findViewById(R.id.edittext_number);
        button_add = findViewById(R.id.button_add);
        button_view = findViewById(R.id.button_view);


        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = editText_name.getText().toString();
                String stringAddress = editText_address.getText().toString();
                String stringLocation = editText_location.getText().toString();
                String stringNumber = editText_number.getText().toString();

                if (stringName.length() <=0 || stringNumber.length() <=0){

                    Toast.makeText(DeliveryMainActivity.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DeliveryMainActivity.this,com.example.myapplication.ViewDeliveryActivity.class);
                    startActivity(intent);
                }else {
                    DatabaseDeliveryClass databaseDeliveryClass = new DatabaseDeliveryClass(DeliveryMainActivity.this);
                    DeliveryModelClass deliveryModelClass = new DeliveryModelClass(stringName,stringAddress,stringLocation,stringNumber);
                    databaseDeliveryClass.addDelivery(deliveryModelClass);
                    Toast.makeText(DeliveryMainActivity.this, "Add Delivery Details Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });


        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryMainActivity.this, com.example.myapplication.ViewDeliveryActivity.class);
                startActivity(intent);
            }
        });


    }
}
