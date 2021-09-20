package com.example.myapplication;

import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter extends ArrayAdapter<CardModle> {

    private Context context;
    private int resourse;
    List<CardModle> modle;

    Adapter (Context context,int resourse, List<CardModle> modle){

        super(context,resourse,modle);

        this.context=context;
        this.resourse=resourse;
        this.modle=modle;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resourse,parent,false);

        TextView number =  row.findViewById(R.id.numberdis);

        CardModle modles = modle.get(position);
        number.setText(modles.getNumber());

        return row;
    }


}
