package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DeliveryAdapterClass extends RecyclerView.Adapter<DeliveryAdapterClass.ViewDeliveryHolder> {

    List<DeliveryModelClass> delivery;
    Context context;
    com.example.myapplication.DatabaseDeliveryClass databaseDeliveryClass;

    public DeliveryAdapterClass(List<DeliveryModelClass> delivery, Context context) {
        this.delivery = delivery;
        this.context = context;
        databaseDeliveryClass = new com.example.myapplication.DatabaseDeliveryClass(context);
    }
    private Button PAYBTN;

    @NonNull
    @Override
    public ViewDeliveryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.delivery_item_list,parent,false);
        ViewDeliveryHolder viewDeliveryHolder = new ViewDeliveryHolder(view);



        return viewDeliveryHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewDeliveryHolder holder, final int position) {
        final DeliveryModelClass deliveryModelClass = delivery.get(position);

        holder.textViewID.setText(Integer.toString(deliveryModelClass.getId()));
        holder.editText_Name.setText(deliveryModelClass.getName());
        holder.editText_Address.setText(deliveryModelClass.getAddress());
        holder.editText_Location.setText(deliveryModelClass.getLocation());
        holder.editText_Number.setText(deliveryModelClass.getNumber());

        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = holder.editText_Name.getText().toString();
                String stringAddress = holder.editText_Address.getText().toString();
                String stringLocation = holder.editText_Location.getText().toString();
                String stringNumber = holder.editText_Number.getText().toString();

                databaseDeliveryClass.updateDelivery(new DeliveryModelClass(deliveryModelClass.getId(),stringName,stringAddress,stringLocation,stringNumber));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseDeliveryClass.deleteDelivery(deliveryModelClass.getId());
                delivery.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return delivery.size();
    }

    public class ViewDeliveryHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        EditText editText_Name;
        EditText editText_Address;
        EditText editText_Location;
        EditText editText_Number;
        Button button_Edit;
        Button button_delete;

        public ViewDeliveryHolder(@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.text_id);
            editText_Name = itemView.findViewById(R.id.edittext_name);
            editText_Address = itemView.findViewById(R.id.edittext_address);
            editText_Location = itemView.findViewById(R.id.edittext_location);
            editText_Number = itemView.findViewById(R.id.edittext_number);
            button_delete = itemView.findViewById(R.id.button_delete);
            button_Edit = itemView.findViewById(R.id.button_edit);

        }
    }
}
