package com.example.myapplication;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class FeedbackMainActivity extends AppCompatActivity {

    private Button add;
    private ListView listView;
    private TextView count;
    Context context;
    private FeedbackDBHandler feedbackDbHandler;
    private List<FeedBack> feedBacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("All FeedBacks");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        add =findViewById(R.id.add);
        listView=findViewById(R.id.feedbacklist);
        count=findViewById(R.id.feedbackcount);
        context=this;
        feedBacks=new ArrayList<>();
        feedbackDbHandler =new FeedbackDBHandler(this);

        feedBacks= feedbackDbHandler.getAllFeedbacks();

        FeedBackAdapter adapter=new FeedBackAdapter(context,R.layout.singlefeedback,feedBacks);
        listView.setAdapter(adapter);

        //get_feedback counts from the table
        int countFeedback = feedbackDbHandler.countFeedback();
        count.setText("You Send "+countFeedback+" Feedbacks");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, com.example.feedback.AddFeedBack.class));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                FeedBack feedBack = feedBacks.get(i);

                AlertDialog.Builder builder =new AlertDialog.Builder(context);
                builder.setTitle(feedBack.getFeedbackMzg());
                builder.setMessage(feedBack.getFeedbackMzg());


                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        feedbackDbHandler.delteFeedBack(feedBack.getId());
                        startActivity(new Intent(context, FeedbackMainActivity.class));
                    }
                });

                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(context,EditFeedback.class);
                        intent.putExtra("id",String.valueOf(feedBack.getId()));
                        startActivity(intent);
                    }
                });

                builder.show();

            }
        });

    }
}