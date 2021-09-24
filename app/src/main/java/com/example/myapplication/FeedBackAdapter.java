package com.example.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FeedBackAdapter extends ArrayAdapter<FeedBack> {

    private Context context;
    private int resource;
    List<FeedBack> feedBacks;

    FeedBackAdapter(Context context, int resource, List<FeedBack> feedBacks){
        super(context,resource,feedBacks);
        this.context=context;
        this.resource=resource;
        this.feedBacks=feedBacks;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView feedbackMsz = row.findViewById(R.id.feedbackMzg);


        // feedbacks [obj1]
        FeedBack feedBack = feedBacks.get(position);
        feedbackMsz.setText(feedBack.getFeedbackMzg());
        return row;
    }
}
