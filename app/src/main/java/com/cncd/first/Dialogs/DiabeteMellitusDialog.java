package com.cncd.first.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import com.cncd.first.Models.DiseaseData.DiseaseList;
import com.cncd.first.R;
import com.cncd.first.UIs.BaselineQuestionnaireRecruitmentActivity;
import com.cncd.first.UIs.CallBackFormActivity;
import com.cncd.first.UIs.FamilySheetActivity;
import com.cncd.first.UIs.RecruitmentGeneralExclusionAndSpecificDiseaseActivity;
import com.cncd.first.Utils.GeneralUtils;
import com.cncd.first.Utils.ReturnValueFromDialog;

import java.util.ArrayList;

public class DiabeteMellitusDialog {


    Dialog dialog;
    Context context;

    public DiabeteMellitusDialog() {
    }

    public void showDialog(final Context activity) {
        ArrayList<DiseaseList> diseaseLists = new ArrayList<DiseaseList>();

        context = activity;
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.diabetes_mellitus_dialog_layout);


        LinearLayout diabetesYesNoLayout, diabetesTypeLayout, diabetesType1Layout, diabetesType2Layout, diabetesGestationalLayout, submitlayoutLayout;
        diabetesYesNoLayout = (LinearLayout) dialog.findViewById(R.id.diabetesYesNoLayout);
        diabetesTypeLayout = (LinearLayout) dialog.findViewById(R.id.diabetesTypeLayout);
        diabetesType1Layout = (LinearLayout) dialog.findViewById(R.id.diabetesType1Layout);
        diabetesType2Layout = (LinearLayout) dialog.findViewById(R.id.diabetesType2Layout);
        diabetesGestationalLayout = (LinearLayout) dialog.findViewById(R.id.diabetesGestationalLayout);
        submitlayoutLayout = (LinearLayout) dialog.findViewById(R.id.submitlayoutLayout);


        final int[] backCheck = {0};

        CardView diabetesYes, diabetesNo, diabetesType1, diabetesType2, diabetesGestational, type1Continue, type2Continue, gasSubmit, diabetesSubmit;
        diabetesYes = (CardView) dialog.findViewById(R.id.diabetesYes);
        type1Continue = (CardView) dialog.findViewById(R.id.type1Continue);
        type2Continue = (CardView) dialog.findViewById(R.id.type2Continue);
        gasSubmit = (CardView) dialog.findViewById(R.id.gasSubmit);
        diabetesSubmit = (CardView) dialog.findViewById(R.id.diabetesSubmit);

        diabetesNo = (CardView) dialog.findViewById(R.id.diabetesNo);
        diabetesType1 = (CardView) dialog.findViewById(R.id.diabetesType1);
        diabetesType2 = (CardView) dialog.findViewById(R.id.diabetesType2);
        diabetesGestational = (CardView) dialog.findViewById(R.id.diabetesGestational);

        ImageView backToYesNoButton, backToTypeDiabetesType1, backToTypeDiabetesType2, backToTypeDiabetesGestational, backToDiabetes;
        backToYesNoButton = (ImageView) dialog.findViewById(R.id.backToYesNoButton);
        backToTypeDiabetesType1 = (ImageView) dialog.findViewById(R.id.backToTypeDiabetesType1);
        backToTypeDiabetesType2 = (ImageView) dialog.findViewById(R.id.backToTypeDiabetesType2);
        backToTypeDiabetesGestational = (ImageView) dialog.findViewById(R.id.backToTypeDiabetesGestational);
        backToDiabetes = (ImageView) dialog.findViewById(R.id.backToDiabetes);


        ImageView closeButton = (ImageView) dialog.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        gasSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                ReturnValueFromDialog activity = (ReturnValueFromDialog) context;
                //ArrayList<DiseaseList>  diseaseLists = new ArrayList<DiseaseList>();


                    /*
                    Gestational diabetes data
                    */

                CheckBox gesRecordSeen = (CheckBox) dialog.findViewById(R.id.gesRecordSeen);
                CheckBox gesOral = (CheckBox) dialog.findViewById(R.id.gesOral);
                CheckBox gesDietary = (CheckBox) dialog.findViewById(R.id.gesDietary);
                EditText gesAgeOfDiagnosis = (EditText) dialog.findViewById(R.id.gesAgeOfDiagnosis);

                diseaseLists.add(new DiseaseList("type", "gestational"));
                diseaseLists.add(new DiseaseList("record_seen", gesRecordSeen.isChecked() ? "true" : "false"));
                diseaseLists.add(new DiseaseList("oral_hypogylcemic", gesOral.isChecked() ? "true" : "false"));
                diseaseLists.add(new DiseaseList("dietary_changes", gesDietary.isChecked() ? "true" : "false"));
                diseaseLists.add(new DiseaseList("age_of_diagnosis", !gesAgeOfDiagnosis.getText().toString().equals("")
                        ? gesAgeOfDiagnosis.getText().toString() : "unknown"));
                activity.onReturnDiabetesData("Gestational Data Entered", diseaseLists);
            }
        });

        diabetesSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                ReturnValueFromDialog activity = (ReturnValueFromDialog) context;
                if (backCheck[0] == 1) {

                    /*
                    Type 1 diabetes data
                    */
                    CheckBox type1RecordSeen = (CheckBox) dialog.findViewById(R.id.type1RecordSeen);
                    CheckBox type1Insulin = (CheckBox) dialog.findViewById(R.id.type1Insulin);
                    EditText type1AgeDiag = (EditText) dialog.findViewById(R.id.type1AgeDiag);

                    TextView type1ComplicationButton = (TextView) dialog.findViewById(R.id.type1ComplicationButton);
                    CheckBox type1ComplicationRecordSeen = (CheckBox) dialog.findViewById(R.id.complicationRecordSeen);
                    EditText complicationAgeDiag = (EditText) dialog.findViewById(R.id.complicationAgeDiag);

                    Toast.makeText(context, ""+complicationAgeDiag.getText().toString(), Toast.LENGTH_SHORT).show();

                    diseaseLists.add(new DiseaseList("type", "type1"));
                    diseaseLists.add(new DiseaseList("record_seen", type1RecordSeen.isChecked() ? "true" : "false"));
                    diseaseLists.add(new DiseaseList("insulin", type1Insulin.isChecked() ? "true" : "false"));
                    diseaseLists.add(new DiseaseList("age_of_diagnosis", !type1AgeDiag.getText().toString().equals("")
                            ? type1AgeDiag.getText().toString() : "unknown"));

                    diseaseLists.add(new DiseaseList("complication", type1ComplicationButton.getText().toString()));
                    diseaseLists.add(new DiseaseList("complication_record_seen", type1ComplicationRecordSeen.isChecked() ? "true" : "false"));
                    diseaseLists.add(new DiseaseList("age_of_diagnosis", !complicationAgeDiag.getText().toString().equals("")
                            ? complicationAgeDiag.getText().toString() : "unknown"));

                    activity.onReturnDiabetesData("Diabetes Type 1 Data Entered", diseaseLists);

                } else if (backCheck[0] == 2) {


                    /*
                    Type 2 diabetes data
                    */


                    CheckBox type2RecordSeen = (CheckBox) dialog.findViewById(R.id.type2RecordSeen);
                    CheckBox type2Insulin = (CheckBox) dialog.findViewById(R.id.type2Insulin);
                    CheckBox type2Oral = (CheckBox) dialog.findViewById(R.id.type2Oral);
                    EditText type2AgeDiag = (EditText) dialog.findViewById(R.id.type2AgeDiag);

                    TextView type1ComplicationButton = (TextView) dialog.findViewById(R.id.type1ComplicationButton);
                    CheckBox type1ComplicationRecordSeen = (CheckBox) dialog.findViewById(R.id.complicationRecordSeen);
                    EditText complicationAgeDiag = (EditText) dialog.findViewById(R.id.complicationAgeDiag);


                    diseaseLists.add(new DiseaseList("type", "type2"));
                    diseaseLists.add(new DiseaseList("record_seen", type2RecordSeen.isChecked() ? "true" : "false"));
                    diseaseLists.add(new DiseaseList("insulin", type2Insulin.isChecked() ? "true" : "false"));
                    diseaseLists.add(new DiseaseList("oral_hypogylcemic", type2Oral.isChecked() ? "true" : "false"));
                    diseaseLists.add(new DiseaseList("age_of_diagnosis", !type2AgeDiag.getText().toString().equals("")
                            ? type2AgeDiag.getText().toString() : "unknown"));

                    diseaseLists.add(new DiseaseList("complication", type1ComplicationButton.getText().toString()));
                    diseaseLists.add(new DiseaseList("complication_record_seen", type1ComplicationRecordSeen.isChecked() ? "true" : "false"));
                    diseaseLists.add(new DiseaseList("age_of_diagnosis", !complicationAgeDiag.getText().toString().equals("")
                            ? complicationAgeDiag.getText().toString() : "unknown"));




                    activity.onReturnDiabetesData("Diabetes Type 2 Data Entered", diseaseLists);
                }
            }
        });


        backToYesNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                diabetesYesNoLayout.setVisibility(View.VISIBLE);
                diabetesTypeLayout.setVisibility(View.GONE);

            }
        });

        backToTypeDiabetesType1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                diabetesType1Layout.setVisibility(View.GONE);
                diabetesTypeLayout.setVisibility(View.VISIBLE);

            }
        });

        backToTypeDiabetesType2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                diabetesType2Layout.setVisibility(View.GONE);
                diabetesTypeLayout.setVisibility(View.VISIBLE);

            }
        });

        backToTypeDiabetesGestational.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                diabetesGestationalLayout.setVisibility(View.GONE);
                diabetesTypeLayout.setVisibility(View.VISIBLE);

            }
        });
        TextView type1ComplicationButton = (TextView) dialog.findViewById(R.id.type1ComplicationButton);
        type1ComplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GeneralUtils.selectDiabetesType1Complications(context, view);


            }
        });
/*
        TextView type2ComplicationButton = (TextView) dialog.findViewById(R.id.type2ComplicationButton);
        type2ComplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GeneralUtils.selectDiabetesType1Complications(context, view);


            }
        });*/

        diabetesNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();

            }
        });

        diabetesYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                diabetesYesNoLayout.setVisibility(View.GONE);
                diabetesTypeLayout.setVisibility(View.VISIBLE);

            }
        });


        diabetesType1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                diabetesType1Layout.setVisibility(View.VISIBLE);
                diabetesTypeLayout.setVisibility(View.GONE);

            }
        });

        diabetesType2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                diabetesType2Layout.setVisibility(View.VISIBLE);
                diabetesTypeLayout.setVisibility(View.GONE);

            }
        });

        diabetesGestational.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                diabetesGestationalLayout.setVisibility(View.VISIBLE);
                diabetesTypeLayout.setVisibility(View.GONE);

            }
        });

        type1Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                submitlayoutLayout.setVisibility(View.VISIBLE);
                diabetesType1Layout.setVisibility(View.GONE);
                backCheck[0] = 1;

            }
        });

        type2Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                submitlayoutLayout.setVisibility(View.VISIBLE);
                diabetesType2Layout.setVisibility(View.GONE);
                backCheck[0] = 2;

            }
        });

        backToDiabetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                submitlayoutLayout.setVisibility(View.GONE);

                if (backCheck[0] == 1) {
                    diabetesType1Layout.setVisibility(View.VISIBLE);
                } else if (backCheck[0] == 2) {

                    diabetesType2Layout.setVisibility(View.VISIBLE);

                }
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