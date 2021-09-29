package com.cncd.first.Models.FamilyModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cncd.first.R;

import java.util.ArrayList;

public class FamilyAdapter extends RecyclerView.Adapter<FamilyAdapter.FamilyHolder> {


    ArrayList<FamilyList> list;
    Context context;
    View view;

    public FamilyAdapter(ArrayList<FamilyList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public FamilyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.family_row, parent, false);


        return new FamilyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FamilyHolder holder, int position) {

        final FamilyList currentData = list.get(position);


        String family_id = currentData.getFamily_id();
        String condition_name = currentData.getMedical_condition_name();
        String specify_condition = currentData.getSpecify_condition_name();
        String relation_name = currentData.getRelation_name();
        String age_diagnosed = currentData.getAge_diagnosed();

        holder.familyIdText.setText(family_id);
        holder.medicalConditionText.setText(condition_name);
        holder.specifyConditionText.setText(specify_condition);
        holder.relationText.setText(relation_name);
        holder.ageDiagnosedText.setText(age_diagnosed);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FamilyHolder extends RecyclerView.ViewHolder {

        TextView familyIdText;
        TextView medicalConditionText;
        TextView specifyConditionText;
        TextView relationText;
        TextView ageDiagnosedText;


        public FamilyHolder(@NonNull View itemView) {
            super(itemView);

            familyIdText = itemView.findViewById(R.id.familyIdText);
            medicalConditionText = itemView.findViewById(R.id.medicalConditionText);
            specifyConditionText = itemView.findViewById(R.id.specifyConditionText);
            relationText = itemView.findViewById(R.id.relationText);
            ageDiagnosedText = itemView.findViewById(R.id.ageDiagnosedText);


        }
    }

}
