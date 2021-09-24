package com.example.myapplication;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditFeedback extends AppCompatActivity {

    private EditText editmessage;
    private Button edit;
    private FeedbackDBHandler feedbackDbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_feedback);
        setTitle("Edit FeedBack");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context=this;
        feedbackDbHandler =new FeedbackDBHandler(context);

        editmessage=findViewById(R.id.edit_feedbackMzg);
        edit=findViewById(R.id.feedback_edit_button);

        final String id = getIntent().getStringExtra("id");

        FeedBack feedBack = feedbackDbHandler.getSingleFeedBack(Integer.parseInt(id));
        editmessage.setText(feedBack.getFeedbackMzg());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message= editmessage.getText().toString();
                FeedBack feedBack1=new FeedBack(Integer.parseInt(id),message);
                feedbackDbHandler.updateSingleToDo(feedBack1);
                startActivity(new Intent(context, com.example.feedback.FeedbackMainActivity.class));
            }
        });
    }
}