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

public class ValvularHeartDiseaseDialog {


    Dialog dialog;
    Context context;

    public ValvularHeartDiseaseDialog() {
    }

    public void showDialog(final Context activity) {
        ArrayList<DiseaseList> diseaseLists = new ArrayList<DiseaseList>();

        context = activity;
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.valvular_heart_disease_dialog_layout);


        LinearLayout YesNoLayout, typeLayout, diabetesType1Layout, diabetesType2Layout, diabetesGestationalLayout;
        YesNoLayout = (LinearLayout) dialog.findViewById(R.id.YesNoLayout);
        typeLayout = (LinearLayout) dialog.findViewById(R.id.typeLayout);
        diabetesType1Layout = (LinearLayout) dialog.findViewById(R.id.diabetesType1Layout);
        diabetesType2Layout = (LinearLayout) dialog.findViewById(R.id.diabetesType2Layout);
        diabetesGestationalLayout = (LinearLayout) dialog.findViewById(R.id.diabetesGestationalLayout);

        CardView diabetesYes, diabetesNo, diabetesType2, diabetesGestational, submitButton;
        submitButton = (CardView) dialog.findViewById(R.id.submitButton);
        diabetesYes = (CardView) dialog.findViewById(R.id.diabetesYes);

        diabetesNo = (CardView) dialog.findViewById(R.id.diabetesNo);
        //  hypothyroidismType = (CardView) dialog.findViewById(R.id.hypothyroidismType);
        diabetesType2 = (CardView) dialog.findViewById(R.id.diabetesType2);
        diabetesGestational = (CardView) dialog.findViewById(R.id.diabetesGestational);


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
                    Valvular data
                    */

                CheckBox valvularRecordSeen = (CheckBox) dialog.findViewById(R.id.valvularRecordSeen);
                EditText valvularAgeDiag = (EditText) dialog.findViewById(R.id.valvularAgeDiag);
                EditText valvularMedication = (EditText) dialog.findViewById(R.id.valvularMedication);
                TextView type1ComplicationButton = (TextView) dialog.findViewById(R.id.type1ComplicationButton);
                TextView surgicalManagementButton = (TextView) dialog.findViewById(R.id.surgicalManagementButton);



                diseaseLists.add(new DiseaseList("record_seen", valvularRecordSeen.isChecked() ? "true" : "false"));
                diseaseLists.add(new DiseaseList("age_of_diagnosis", !valvularAgeDiag.getText().toString().equals("")
                        ? valvularAgeDiag.getText().toString() : "unknown"));
                diseaseLists.add(new DiseaseList("medication", !valvularMedication.getText().toString().equals("")
                        ? valvularMedication.getText().toString() : "none"));

                diseaseLists.add(new DiseaseList("type",type1ComplicationButton.getText().toString()));
                diseaseLists.add(new DiseaseList("surgical_management",surgicalManagementButton.getText().toString()));


                activity.onReturnValvularData("Valvular Data Entered", diseaseLists);
            }
        });


        TextView type1ComplicationButton = (TextView) dialog.findViewById(R.id.type1ComplicationButton);
        type1ComplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GeneralUtils.selectTypeOfValvularHeartDisease(context, view);


            }
        });

        TextView surgicalManagementButton = (TextView) dialog.findViewById(R.id.surgicalManagementButton);
        surgicalManagementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GeneralUtils.selectSurgicalManagement(context, view);


            }
        });


        TextView type2ComplicationButton = (TextView) dialog.findViewById(R.id.type2ComplicationButton);
        type2ComplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GeneralUtils.selectDiabetesType1Complications(context, view);


            }
        });

        diabetesNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();

            }
        });

        diabetesYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                YesNoLayout.setVisibility(View.GONE);
                // typeLayout.setVisibility(View.VISIBLE);
                diabetesType1Layout.setVisibility(View.VISIBLE);


            }
        });


       /* hypothyroidismType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                diabetesType1Layout.setVisibility(View.VISIBLE);
                typeLayout.setVisibility(View.GONE);

            }
        });*/

        diabetesType2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                diabetesType2Layout.setVisibility(View.VISIBLE);
                typeLayout.setVisibility(View.GONE);

            }
        });

        diabetesGestational.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                diabetesGestationalLayout.setVisibility(View.VISIBLE);
                typeLayout.setVisibility(View.GONE);

            }
        });

/*

        LinearLayout buttonCallBackForm = (LinearLayout) dialog.findViewById(R.id.buttonCallBackForm);
        buttonCallBackForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, CallBackFormActivity.class));
                dialog.dismiss();

            }
        });



        LinearLayout buttonFamilySheet = (LinearLayout) dialog.findViewById(R.id.buttonFamilySheet);
        buttonFamilySheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, FamilySheetActivity.class));
                dialog.dismiss();

            }
        });




        LinearLayout buttonRecruitment = (LinearLayout) dialog.findViewById(R.id.buttonHospitalRecruitment);
        buttonRecruitment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, RecruitmentGeneralExclusionAndSpecificDiseaseActivity.class));
                dialog.dismiss();

            }
        });

*/


        dialog.show();
        //Window window = dialog.getWindow();
        //window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

    }


}