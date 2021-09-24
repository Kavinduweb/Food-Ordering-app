package com.example.myapplication;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddFeedBack extends AppCompatActivity {

    private EditText feedbackmzg;
    private Button add;
    private FeedbackDBHandler feedbackDbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_feed_back);
        setTitle("Add FeedBack");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        feedbackmzg=findViewById(R.id.add_feedbackMzg);
        add=findViewById(R.id.add_button);

        context=this;

        feedbackDbHandler =new FeedbackDBHandler(context);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userfeedback=feedbackmzg.getText().toString();

                FeedBack feedBack=new FeedBack(userfeedback);
                feedbackDbHandler.addFeedBack(feedBack);

                startActivity(new Intent(context, MainActivity.class));
            }
        });
    }
}