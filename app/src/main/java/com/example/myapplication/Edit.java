package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit extends AppCompatActivity {
private Button cancel;
private EditText num,ex,cv;
private Button btn;
private DBHandler dbHandler;
private Context context;
private long updatedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        cancel = (Button)findViewById(R.id.cancel3);
        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                cancelActivity();
            }
        });

        context=(this);
        dbHandler = new DBHandler(context);


        btn= findViewById(R.id.conf_edit);
        num = findViewById(R.id.Editnum);
        ex = findViewById(R.id.EditDate);
        cv = findViewById(R.id.EditCvv);

        final String id = getIntent().getStringExtra("id");

        System.out.println("ida");
        CardModle cards =  dbHandler.getSingle(Integer.parseInt(id));

        num.setText(cards.getNumber());
        ex.setText(cards.getExdate());
        cv.setText(cards.getCvv());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Number = num.getText().toString();
                String Ex = ex.getText().toString();
                String Cv = cv.getText().toString();

                CardModle cards = new CardModle(Integer.parseInt(id),Number,Ex,Cv);
                int state = dbHandler.update(cards);
                System.out.println(state);
                startActivity(new Intent(context,PaymentHome.class));


            }
        });



    }



    public void cancelActivity(){
        Intent intent = new Intent(this,PaymentHome.class);
        startActivity(intent);
    }
}