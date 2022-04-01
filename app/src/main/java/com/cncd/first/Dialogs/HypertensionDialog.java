package com.cncd.first.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;

import com.cncd.first.Models.DiseaseData.DiseaseList;
import com.cncd.first.R;
import com.cncd.first.Utils.ReturnValueFromDialog;

import java.util.ArrayList;

public class HypertensionDialog {


    Dialog dialog;
    Context context;

    public HypertensionDialog() {
    }

    public void showDialog(final Context activity) {
        ArrayList<DiseaseList> diseaseLists = new ArrayList<DiseaseList>();

        context = activity;
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.hypertension_dialog_layout);


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
                    hypertension data
                    */

                CheckBox hypertensionRecordSeen = (CheckBox) dialog.findViewById(R.id.hypertensionRecordSeen);
                EditText hypertensionAgeDiag = (EditText) dialog.findViewById(R.id.hypertensionAgeDiag);
                EditText hypertensionMedication = (EditText) dialog.findViewById(R.id.hypertensionMedication);
                EditText hypertensionDietary = (EditText) dialog.findViewById(R.id.hypertensionDietary);



                diseaseLists.add(new DiseaseList("record_seen", hypertensionRecordSeen.isChecked() ? "true" : "false"));
                diseaseLists.add(new DiseaseList("age_of_diagnosis", !hypertensionAgeDiag.getText().toString().equals("")
                        ? hypertensionAgeDiag.getText().toString() : "unknown"));
                diseaseLists.add(new DiseaseList("medication", !hypertensionMedication.getText().toString().equals("")
                        ? hypertensionMedication.getText().toString() : "none"));
                diseaseLists.add(new DiseaseList("dietary", !hypertensionDietary.getText().toString().equals("")
                        ? hypertensionDietary.getText().toString() : "none"));



                activity.onReturnHypertensionData("Hypertension Data Entered", diseaseLists);



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





        dialog.show();
        //Window window = dialog.getWindow();
        //window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

    }


}