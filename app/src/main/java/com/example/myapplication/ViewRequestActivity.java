package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewRequestActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_request);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseRequestClass databaseRequestClass = new DatabaseRequestClass(this);
        List<RequestModelClass> requestModelClasses = databaseRequestClass.getRequestList();

        if (requestModelClasses.size() > 0) {
            RequestAdapterClass requestAdapterClass = new RequestAdapterClass(requestModelClasses, ViewRequestActivity.this);
            recyclerView.setAdapter(requestAdapterClass);
        }else {
            Toast.makeText(this, "There is no requests in the database", Toast.LENGTH_SHORT).show();
        }
    }
}