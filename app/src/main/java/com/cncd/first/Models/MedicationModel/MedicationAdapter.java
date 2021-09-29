package com.cncd.first.Models.MedicationModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cncd.first.R;

import java.util.ArrayList;

public class MedicationAdapter extends RecyclerView.Adapter<MedicationAdapter.MedicationHolder> {


    ArrayList<MedicationList> list;
    Context context;
    View view;

    public MedicationAdapter(ArrayList<MedicationList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MedicationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.medication_row, parent, false);


        return new MedicationHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicationHolder holder, int position) {

        final MedicationList currentData = list.get(position);


        String drug_id = currentData.getDrug_id();
        String drug_name = currentData.getDrug_name();
        String drug_generic = currentData.getGeneric_name();
        String drug_duration = currentData.getDuration_months();

        holder.drugIdText.setText(drug_id);
        holder.drugNameText.setText(drug_name);
        holder.drugGenericNameText.setText(drug_generic);
        holder.drugDurationText.setText(drug_duration);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MedicationHolder extends RecyclerView.ViewHolder {

        TextView drugIdText;
        TextView drugNameText;
        TextView drugGenericNameText;
        TextView drugDurationText;


        public MedicationHolder(@NonNull View itemView) {
            super(itemView);

            drugIdText = itemView.findViewById(R.id.drugIdText);
            drugNameText = itemView.findViewById(R.id.drugNameText);
            drugGenericNameText = itemView.findViewById(R.id.drugGenericNameText);
            drugDurationText = itemView.findViewById(R.id.drugDurationText);


        }
    }

}
