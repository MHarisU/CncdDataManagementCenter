package com.cncd.first.Models.ParticipantSubjectModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cncd.first.R;

import java.util.ArrayList;

public class ParticipantSubjectAdapter extends RecyclerView.Adapter<ParticipantSubjectAdapter.ParticipantSubjectHolder> {


    ArrayList<ParticipantSubjectList> list;
    Context context;
    View view;

    public ParticipantSubjectAdapter(ArrayList<ParticipantSubjectList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ParticipantSubjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.participant_subject_row, parent, false);


        return new ParticipantSubjectHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParticipantSubjectHolder holder, int position) {

        final ParticipantSubjectList currentData = list.get(position);


        String subject_id = currentData.getSubject_id();
        String subject_name = currentData.getSubject_name();
        String subject_father_husband = currentData.getSubject_father_husband();
        String subject_age = currentData.getSubject_age();
        String subject_gender = currentData.getSubject_gender();
        String subject_relation_with_participant = currentData.getSubject_relationship_with_participant();
        String subject_relationship_with_spouse = currentData.getSubject_relationship_with_spouse();

        holder.subjectIdView.setText(subject_id);
        holder.subjectNameView.setText(subject_name);
        holder.subjectFatherHusbandView.setText(subject_father_husband);
        holder.subjectAgeView.setText(subject_age);
        holder.subjectGenderView.setText(subject_gender);
        holder.relationshipWithCallBackView.setText(subject_relation_with_participant);
        holder.relationshipWithSpouseView.setText(subject_relationship_with_spouse);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ParticipantSubjectHolder extends RecyclerView.ViewHolder {

        TextView subjectIdView;
        TextView subjectNameView;
        TextView subjectFatherHusbandView;
        TextView subjectAgeView;
        TextView subjectGenderView;
        TextView relationshipWithCallBackView;
        TextView relationshipWithSpouseView;



        public ParticipantSubjectHolder(@NonNull View itemView) {
            super(itemView);

            subjectIdView = itemView.findViewById(R.id.subjectIdView);
            subjectNameView = itemView.findViewById(R.id.subjectNameView);
            subjectFatherHusbandView = itemView.findViewById(R.id.subjectFatherHusbandView);
            subjectAgeView = itemView.findViewById(R.id.subjectAgeView);
            subjectGenderView = itemView.findViewById(R.id.subjectGenderView);
            relationshipWithCallBackView = itemView.findViewById(R.id.relationshipWithCallBackView);
            relationshipWithSpouseView = itemView.findViewById(R.id.relationshipWithSpouseView);


        }
    }

}
