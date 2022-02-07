package com.cncd.first.Models.PhoneModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.cncd.first.R;

import java.util.ArrayList;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.PhoneHolder> {


    ArrayList<String> list;
    Context context;
    View view;

    public PhoneAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PhoneHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.phone_row, parent, false);


        return new PhoneHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneHolder holder, int position) {

        final String currentData = list.get(position);



        holder.numberTextView.setText(currentData);
        //holder.deleteButton.setText(drug_name);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PhoneHolder extends RecyclerView.ViewHolder {

        TextView numberTextView;
        CardView deleteButton;


        public PhoneHolder(@NonNull View itemView) {
            super(itemView);

            numberTextView = itemView.findViewById(R.id.numberTextView);
            deleteButton = itemView.findViewById(R.id.deleteButton);


        }
    }

}
