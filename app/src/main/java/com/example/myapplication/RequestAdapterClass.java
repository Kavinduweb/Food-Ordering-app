package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RequestAdapterClass extends RecyclerView.Adapter <RequestAdapterClass.ViewHolder> {

    List<RequestModelClass> request;
    Context context;
    DatabaseRequestClass databaseRequestClass;

    public RequestAdapterClass(List<RequestModelClass> request, Context context) {
        this.request = request;
        this.context = context;
        databaseRequestClass = new DatabaseRequestClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.request_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final RequestModelClass requestModelClass = request.get(position);

        holder.textViewID.setText(Integer.toString(requestModelClass.getId()));
        holder.editText_Name.setText(requestModelClass.getName());
        holder.editText_Email.setText(requestModelClass.getEmail());
        holder.editText_Category.setText(requestModelClass.getCategory());
        holder.editText_Type.setText(requestModelClass.getType());

        holder.button_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringName = holder.editText_Name.getText().toString();
                String stringEmail = holder.editText_Email.getText().toString();
                String stringCategory = holder.editText_Category.getText().toString();
                String stringType = holder.editText_Type.getText().toString();

                databaseRequestClass.updateRequest(new RequestModelClass(requestModelClass.getId(),stringName,stringEmail,stringCategory,stringType));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseRequestClass.deleteRequest(requestModelClass.getId());
                request.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return request.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewID;
        EditText editText_Name;
        EditText editText_Email;
        EditText editText_Category;
        EditText editText_Type;
        Button button_edit;
        Button button_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.text_id);
            editText_Name = itemView.findViewById(R.id.edittext_name);
            editText_Email = itemView.findViewById(R.id.edittext_email);
            editText_Category = itemView.findViewById(R.id.edittext_category);
            editText_Type = itemView.findViewById(R.id.edittext_type);
            button_edit = itemView.findViewById(R.id.button_edit);
            button_delete = itemView.findViewById(R.id.button_delete);
        }
    }
}
