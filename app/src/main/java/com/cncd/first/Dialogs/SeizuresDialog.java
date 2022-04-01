package com.cncd.first.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.cncd.first.Models.DiseaseData.DiseaseList;
import com.cncd.first.R;
import com.cncd.first.Utils.GeneralUtils;
import com.cncd.first.Utils.ReturnValueFromDialog;

import java.util.ArrayList;

public class SeizuresDialog {


    Dialog dialog;
    Context context;

    public SeizuresDialog() {
    }

    public void showDialog(final Context activity) {
        ArrayList<DiseaseList> diseaseLists = new ArrayList<DiseaseList>();
        context = activity;
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.seizures_dialog_layout);


        LinearLayout YesNoLayout,  diseaseLayout1;
        YesNoLayout = (LinearLayout) dialog.findViewById(R.id.YesNoLayout);
        diseaseLayout1 = (LinearLayout) dialog.findViewById(R.id.diseaseLayout1);

        CardView diseaseYes,diseaseNo, submitButton;
        submitButton = (CardView) dialog.findViewById(R.id.submitButton);
        diseaseYes = (CardView) dialog.findViewById(R.id.diseaseYes);

        diseaseNo = (CardView) dialog.findViewById(R.id.diseaseNo);
      //  hypothyroidismType = (CardView) dialog.findViewById(R.id.hypothyroidismType);


        ImageView closeButton = (ImageView) dialog.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                ReturnValueFromDialog activity = (ReturnValueFromDialog) context;



                    /*
                    Seizure data
                    */

                CheckBox seizureRecordSeen = (CheckBox) dialog.findViewById(R.id.seizureRecordSeen);
                EditText seizureAge = (EditText) dialog.findViewById(R.id.seizureAge);
                EditText seizureLast = (EditText) dialog.findViewById(R.id.seizureLast);
                EditText seizureDuration = (EditText) dialog.findViewById(R.id.seizureDuration);
                EditText seizureMedication = (EditText) dialog.findViewById(R.id.seizureMedication);
                TextView seizureFrequency = (TextView) dialog.findViewById(R.id.seizureFrequency);
                TextView seizureDiagnosis = (TextView) dialog.findViewById(R.id.seizureDiagnosis);



                diseaseLists.add(new DiseaseList("record_seen", seizureRecordSeen.isChecked() ? "true" : "false"));
                diseaseLists.add(new DiseaseList("first_seizure_age", !seizureAge.getText().toString().equals("")
                        ? seizureAge.getText().toString() : "unknown"));

                diseaseLists.add(new DiseaseList("last_seizure", !seizureLast.getText().toString().equals("")
                        ? seizureLast.getText().toString() : "unknown"));

                diseaseLists.add(new DiseaseList("seizure_duration", !seizureDuration.getText().toString().equals("")
                        ? seizureDuration.getText().toString() : "unknown"));

                diseaseLists.add(new DiseaseList("medication", !seizureMedication.getText().toString().equals("")
                        ? seizureMedication.getText().toString() : "none"));

                diseaseLists.add(new DiseaseList("frequency", seizureFrequency.getText().toString()));
                diseaseLists.add(new DiseaseList("seizure_diagnosis", seizureDiagnosis.getText().toString()));



                activity.onReturnSeizureData("Seizure Data Entered", diseaseLists);


            }
        });



        diseaseNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();

            }
        });

        diseaseYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                YesNoLayout.setVisibility(View.GONE);
               // typeLayout.setVisibility(View.VISIBLE);
                diseaseLayout1.setVisibility(View.VISIBLE);


            }
        });


        TextView seizureFrequency = (TextView) dialog.findViewById(R.id.seizureFrequency);
        seizureFrequency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GeneralUtils.selectSeizureFrequency(context, view);


            }
        });

        TextView seizureDiagnosis = (TextView) dialog.findViewById(R.id.seizureDiagnosis);
        seizureDiagnosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GeneralUtils.selectSeizureDiagnosis(context, view);


            }
        });



        dialog.show();
        //Window window = dialog.getWindow();
        //window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

    }


}