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
import com.cncd.first.Utils.ReturnValueFromDialog;

import java.util.ArrayList;

public class MyocardialInfarctionDialog {


    Dialog dialog;
    Context context;

    public MyocardialInfarctionDialog() {
    }

    public void showDialog(final Context activity) {
        ArrayList<DiseaseList> diseaseLists = new ArrayList<DiseaseList>();
        context = activity;
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.mi_dialog_layout);


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
                    Liver data
                    */

                CheckBox miRecordSeen = (CheckBox) dialog.findViewById(R.id.miRecordSeen);
                EditText miAgeDiag = (EditText) dialog.findViewById(R.id.miAgeDiag);
                EditText miMedication = (EditText) dialog.findViewById(R.id.miMedication);

                CheckBox miAngiography = (CheckBox) dialog.findViewById(R.id.miAngiography);
                CheckBox miAngioplasty = (CheckBox) dialog.findViewById(R.id.miAngioplasty);
                CheckBox miCabg = (CheckBox) dialog.findViewById(R.id.miCabg);
                EditText miAngiographyYear = (EditText) dialog.findViewById(R.id.miAngiographyYear);
                EditText miAngioplastyYear = (EditText) dialog.findViewById(R.id.miAngioplastyYear);
                EditText miCabgYear = (EditText) dialog.findViewById(R.id.miCabgYear);



                diseaseLists.add(new DiseaseList("record_seen", miRecordSeen.isChecked() ? "true" : "false"));
                diseaseLists.add(new DiseaseList("age_of_diagnosis", !miAgeDiag.getText().toString().equals("")
                        ? miAgeDiag.getText().toString() : "unknown"));
                diseaseLists.add(new DiseaseList("medication", !miMedication.getText().toString().equals("")
                        ? miMedication.getText().toString() : "none"));


                diseaseLists.add(new DiseaseList("angiography", miAngiography.isChecked() ? "true" : "false"));
                diseaseLists.add(new DiseaseList("angiography_year", !miAngiographyYear.getText().toString().equals("")
                        ? miAngiographyYear.getText().toString() : "0"));

                diseaseLists.add(new DiseaseList("angioplasty", miAngioplasty.isChecked() ? "true" : "false"));
                diseaseLists.add(new DiseaseList("angioplasty_year", !miAngioplastyYear.getText().toString().equals("")
                        ? miAngioplastyYear.getText().toString() : "0"));

                diseaseLists.add(new DiseaseList("cabg", miCabg.isChecked() ? "true" : "false"));
                diseaseLists.add(new DiseaseList("cabg_year", !miCabgYear.getText().toString().equals("")
                        ? miCabgYear.getText().toString() : "0"));





                activity.onReturnMIData("MI Data Entered", diseaseLists);



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