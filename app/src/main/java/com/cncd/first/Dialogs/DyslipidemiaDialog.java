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

public class DyslipidemiaDialog {


    Dialog dialog;
    Context context;

    public DyslipidemiaDialog() {
    }

    public void showDialog(final Context activity) {
        ArrayList<DiseaseList> diseaseLists = new ArrayList<DiseaseList>();
        context = activity;
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dyslipidemia_dialog_layout);


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
                    Dyslipidemia data
                    */

                CheckBox dyslipidemiaRecordSeen = (CheckBox) dialog.findViewById(R.id.dyslipidemiaRecordSeen);
                EditText dyslipidemiaAgeDiag = (EditText) dialog.findViewById(R.id.dyslipidemiaAgeDiag);
                EditText dyslipidemiaMedication = (EditText) dialog.findViewById(R.id.dyslipidemiaMedication);



                diseaseLists.add(new DiseaseList("record_seen", dyslipidemiaRecordSeen.isChecked() ? "true" : "false"));
                diseaseLists.add(new DiseaseList("age_of_diagnosis", !dyslipidemiaAgeDiag.getText().toString().equals("")
                        ? dyslipidemiaAgeDiag.getText().toString() : "unknown"));
                diseaseLists.add(new DiseaseList("medication", !dyslipidemiaMedication.getText().toString().equals("")
                        ? dyslipidemiaMedication.getText().toString() : "none"));



                activity.onReturnDyslipidemiaData("Dyslipidemia Data Entered", diseaseLists);


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