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

public class ThyroidDiseaseDialog {


    Dialog dialog;
    Context context;

    public ThyroidDiseaseDialog() {
    }

    public void showDialog(final Context activity) {
        ArrayList<DiseaseList> diseaseLists = new ArrayList<DiseaseList>();

        final String[] thyroid_type = new String[1];
        context = activity;
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.thyroid_disease_dialog_layout);


        LinearLayout YesNoLayout, typeLayout, diabetesType1Layout, diabetesType2Layout, diabetesGestationalLayout, submitLayout;
        YesNoLayout = (LinearLayout) dialog.findViewById(R.id.YesNoLayout);
        typeLayout = (LinearLayout) dialog.findViewById(R.id.typeLayout);
        diabetesType1Layout = (LinearLayout) dialog.findViewById(R.id.diabetesType1Layout);
        diabetesType2Layout = (LinearLayout) dialog.findViewById(R.id.diabetesType2Layout);
        diabetesGestationalLayout = (LinearLayout) dialog.findViewById(R.id.diabetesGestationalLayout);
        submitLayout = (LinearLayout) dialog.findViewById(R.id.submitLayout);

        CardView diabetesYes, diabetesNo, hypothyroidismType, diabetesType2, diabetesGestational, submitButton;
        submitButton = (CardView) dialog.findViewById(R.id.submitButton);
        diabetesYes = (CardView) dialog.findViewById(R.id.diabetesYes);

        diabetesNo = (CardView) dialog.findViewById(R.id.diabetesNo);
        hypothyroidismType = (CardView) dialog.findViewById(R.id.hypothyroidismType);
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
                    thyroid data
                    */

                CheckBox hypoRecordSeen = (CheckBox) dialog.findViewById(R.id.hypoRecordSeen);
                CheckBox hypoOral = (CheckBox) dialog.findViewById(R.id.hypoOral);
                EditText hypoAgeDiag = (EditText) dialog.findViewById(R.id.hypoAgeDiag);

                CheckBox hyperRecordSeen = (CheckBox) dialog.findViewById(R.id.hyperRecordSeen);
                CheckBox hyperOral = (CheckBox) dialog.findViewById(R.id.hyperOral);
                CheckBox hyperThyrotox = (CheckBox) dialog.findViewById(R.id.hyperThyrotox);
                EditText hyperAgeDiag = (EditText) dialog.findViewById(R.id.hyperAgeDiag);

                CheckBox goitreThyroidec = (CheckBox) dialog.findViewById(R.id.goitreThyroidec);
                EditText goitreAgeDiag = (EditText) dialog.findViewById(R.id.goitreAgeDiag);


                diseaseLists.add(new DiseaseList("type", thyroid_type[0]));

                if (thyroid_type[0].equals("hypothyroidism")) {
                    diseaseLists.add(new DiseaseList("record_seen", hypoRecordSeen.isChecked() ? "true" : "false"));
                    diseaseLists.add(new DiseaseList("oral_medication", hypoOral.isChecked() ? "true" : "false"));
                    diseaseLists.add(new DiseaseList("age_of_diagnosis", !hypoAgeDiag.getText().toString().equals("")
                            ? hypoAgeDiag.getText().toString() : "unknown"));


                }
                else if (thyroid_type[0].equals("hyperthyroidism")) {
                    diseaseLists.add(new DiseaseList("record_seen", hyperRecordSeen.isChecked() ? "true" : "false"));
                    diseaseLists.add(new DiseaseList("oral_medication", hyperOral.isChecked() ? "true" : "false"));
                    diseaseLists.add(new DiseaseList("thyrotoxicosis", hyperThyrotox.isChecked() ? "true" : "false"));
                    diseaseLists.add(new DiseaseList("age_of_diagnosis", !hyperAgeDiag.getText().toString().equals("")
                            ? hyperAgeDiag.getText().toString() : "unknown"));

                }
                else if (thyroid_type[0].equals("goitre")) {
                    diseaseLists.add(new DiseaseList("thyroidectomy", goitreThyroidec.isChecked() ? "true" : "false"));
                    diseaseLists.add(new DiseaseList("age_of_diagnosis", !goitreAgeDiag.getText().toString().equals("")
                            ? goitreAgeDiag.getText().toString() : "unknown"));

                }


                activity.onReturnThyroidData("Thyroid Data Entered", diseaseLists);
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
                typeLayout.setVisibility(View.VISIBLE);

            }
        });


        hypothyroidismType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                diabetesType1Layout.setVisibility(View.VISIBLE);
                submitLayout.setVisibility(View.VISIBLE);

                thyroid_type[0] = "hypothyroidism";
                typeLayout.setVisibility(View.GONE);

            }
        });

        diabetesType2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                diabetesType2Layout.setVisibility(View.VISIBLE);
                submitLayout.setVisibility(View.VISIBLE);
                thyroid_type[0] = "hyperthyroidism";

                typeLayout.setVisibility(View.GONE);

            }
        });

        diabetesGestational.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                diabetesGestationalLayout.setVisibility(View.VISIBLE);
                submitLayout.setVisibility(View.VISIBLE);
                thyroid_type[0] = "goitre";

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