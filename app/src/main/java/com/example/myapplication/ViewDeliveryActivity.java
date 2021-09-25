package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewDeliveryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_delivery);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseDeliveryClass databaseDeliveryClass = new DatabaseDeliveryClass(this);
        List<DeliveryModelClass> deliveryModelClasses = databaseDeliveryClass.getDeliveryList();

        if (deliveryModelClasses.size() > 0){
            DeliveryAdapterClass deliveryadapterclass = new DeliveryAdapterClass(deliveryModelClasses, ViewDeliveryActivity.this);
            recyclerView.setAdapter(deliveryadapterclass);
        }else {
            Toast.makeText(this, "There is no delivery details in the database", Toast.LENGTH_SHORT).show();
        }
        

    }
}
