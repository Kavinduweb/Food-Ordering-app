package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PaymentHome extends AppCompatActivity {
    private Button button ;
    private Button delete;
    private Button cancel;
    private Button edit;
    private Context context;
    private TextView ctext;
    private DBHandler dbhandler;
    private List<CardModle> modle;


    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_main);


        button = (Button) findViewById(R.id.add_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addActivity();
            }
        });

        delete =(Button) findViewById(R.id.delete_btn);
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                deleteActivity();
            }
        });

        edit = findViewById(R.id.edit1);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editActivity();
            }
        });

        ctext=findViewById(R.id.Youhave);
        list = findViewById(R.id.list_view);
        context = this;
        dbhandler = new DBHandler(context) ;
        int count1 = dbhandler.count();
        ctext.setText("You Added "+count1+" Cards");

        modle = new ArrayList<>();

        modle = dbhandler.getaallcard();

        Adapter adapter = new Adapter(context,R.layout.list,modle);


        list.setAdapter(adapter);




    }

    public void addActivity (){

        List<CardModle> value= dbhandler.getaallcard();
        if(value.isEmpty() == false){

            System.out.println(dbhandler.getaallcard());
            Toast toast = Toast.makeText(context,"You Have Added Card",Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            Intent intent = new Intent(this, Adding.class);
            startActivity(intent);
        }
    }
    public void deleteActivity(){
        List<CardModle> value= dbhandler.getaallcard();
        if(value.isEmpty() == true) {

            Toast toast = Toast.makeText(context,"No Card To delete",Toast.LENGTH_SHORT);
            toast.show();

        }else {
            dbhandler.del();
            Intent intent = new Intent(this, PaymentHome.class);

            startActivity(intent);
        }
    }
    public void editActivity(){

        List<CardModle> value= dbhandler.getaallcard();
        if(value.isEmpty() == true){

            System.out.println(dbhandler.getaallcard());
            Toast toast = Toast.makeText(context,"No  Card To Edit",Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            Intent intent = new Intent(context, Edit.class);
            intent.putExtra("id", String.valueOf(0));

            startActivity(intent);
        }
    }

}
