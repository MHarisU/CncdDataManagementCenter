package com.cncd.first.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.cncd.first.R;
import com.cncd.first.UIs.BaselineQuestionnaireRecruitmentActivity;
import com.cncd.first.UIs.CallBackFormActivity;
import com.cncd.first.UIs.FamilySheetActivity;
import com.cncd.first.UIs.RecruitmentGeneralExclusionAndSpecificDiseaseActivity;
import com.cncd.first.Utils.GeneralUtils;

public class DiabeteMellitusDialog {


    Dialog dialog;
    Context context;

    public DiabeteMellitusDialog() {
    }

    public void showDialog(final Context activity) {
        context = activity;
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.diabetes_mellitus_dialog_layout);


        LinearLayout diabetesYesNoLayout, diabetesTypeLayout, diabetesType1Layout, diabetesType2Layout,  diabetesGestationalLayout;
        diabetesYesNoLayout = (LinearLayout) dialog.findViewById(R.id.diabetesYesNoLayout);
        diabetesTypeLayout = (LinearLayout) dialog.findViewById(R.id.diabetesTypeLayout);
        diabetesType1Layout = (LinearLayout) dialog.findViewById(R.id.diabetesType1Layout);
        diabetesType2Layout = (LinearLayout) dialog.findViewById(R.id.diabetesType2Layout);
        diabetesGestationalLayout = (LinearLayout) dialog.findViewById(R.id.diabetesGestationalLayout);

        CardView diabetesYes,diabetesNo, diabetesType1, diabetesType2, diabetesGestational;
        diabetesYes = (CardView) dialog.findViewById(R.id.diabetesYes);

        diabetesNo = (CardView) dialog.findViewById(R.id.diabetesNo);
        diabetesType1 = (CardView) dialog.findViewById(R.id.diabetesType1);
        diabetesType2 = (CardView) dialog.findViewById(R.id.diabetesType2);
        diabetesGestational = (CardView) dialog.findViewById(R.id.diabetesGestational);


        ImageView closeButton = (ImageView) dialog.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        TextView type1ComplicationButton = (TextView) dialog.findViewById(R.id.type1ComplicationButton);
        type1ComplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GeneralUtils.selectDiabetesType1Complications(context, view);


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