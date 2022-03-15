package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.cncd.first.Dialogs.DiabeteMellitusDialog;
import com.cncd.first.Dialogs.DyslipidemiaDialog;
import com.cncd.first.Dialogs.HypertensionDialog;
import com.cncd.first.Dialogs.LiverDiseaseDialog;
import com.cncd.first.Dialogs.MyocardialInfarctionDialog;
import com.cncd.first.Dialogs.SeizuresDialog;
import com.cncd.first.Dialogs.ThyroidDiseaseDialog;
import com.cncd.first.Dialogs.ValvularHeartDiseaseDialog;
import com.cncd.first.Models.BaseParticipant.ParticipantDataList;
import com.cncd.first.R;
import com.cncd.first.Utils.DatePicker;
import com.cncd.first.Utils.GeneralUtils;
import com.cncd.first.Utils.ReturnValueFromDialog;
import com.cncd.first.Utils.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BaselineQuestionnaireRecruitmentActivity extends AppCompatActivity implements ReturnValueFromDialog {

    ArrayList<String> participantDetails = new ArrayList<>();

    TextView interviewDateText, dateLastMeal, dateBloodSample, lastMealTime, bloodsampleTime;
    EditText interviewInitialsEdit, refTargetEdit, participantNameEdit, participantFatherHusbandEdit, participantAddressEdit, participantTelephoneEdit, participantWhatsappEdit;
    EditText participantAgeEdit, participantCnicEdit;
    RadioButton radioMale, radioFemale;


    ParticipantDataList participantDataList;


    TextView diabetesTextView, thyroidTextView, valvularTextView, dyslipidemiaTextView, hypertensionTextView, liverTextView, miTextView, seizureTextView;

    //Note Views
    CardView notesLayout;
    EditText notesEdit;
    Boolean notesOpenCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (GeneralUtils.getLanguage(BaselineQuestionnaireRecruitmentActivity.this).equals("ur"))
            GeneralUtils.changeIntoUrdu(BaselineQuestionnaireRecruitmentActivity.this);
        setContentView(R.layout.activity_baseline_questionnaire_recruitment);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        loadUI();

        loadCurrentDate();
        loadParticipantData();
    }

    private void loadCurrentDate() {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);
        if (GeneralUtils.getLanguage(BaselineQuestionnaireRecruitmentActivity.this).equals("ur")) {
            interviewDateText.setText(formattedDate + "انٹرویو کی تاریخ: ");

        } else {
            interviewDateText.setText("1. Date of Interview: " + formattedDate);

        }
    }

    private void loadUI() {
        interviewDateText = findViewById(R.id.interviewDateText);
        interviewInitialsEdit = findViewById(R.id.interviewInitialsEdit);
        //refTargetEdit = findViewById(R.id.refTargetEdit);

        participantNameEdit = findViewById(R.id.participantNameEdit);
        participantFatherHusbandEdit = findViewById(R.id.participantFatherHusbandEdit);
        participantAddressEdit = findViewById(R.id.participantAddressEdit);
        participantTelephoneEdit = findViewById(R.id.participantTelephoneEdit);
        participantWhatsappEdit = findViewById(R.id.participantWhatsappEdit);

        participantAgeEdit = findViewById(R.id.participantAgeEdit);
        participantCnicEdit = findViewById(R.id.participantCnicEdit);

        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);

        dateLastMeal = findViewById(R.id.dateLastMeal);
        dateBloodSample = findViewById(R.id.dateBloodSample);
        lastMealTime = findViewById(R.id.lastMealTime);
        bloodsampleTime = findViewById(R.id.bloodsampleTime);

        notesLayout = findViewById(R.id.notesLayout);
        notesEdit = findViewById(R.id.notesEdit);


        diabetesTextView = findViewById(R.id.diabetesTextView);
        thyroidTextView = findViewById(R.id.thyroidTextView);
        valvularTextView = findViewById(R.id.valvularTextView);
        dyslipidemiaTextView = findViewById(R.id.dyslipidemiaTextView);
        hypertensionTextView = findViewById(R.id.hypertensionTextView);
        liverTextView = findViewById(R.id.liverTextView);
        miTextView = findViewById(R.id.miTextView);
        seizureTextView = findViewById(R.id.seizureTextView);

    }

    private void loadParticipantData() {
        Intent intent = getIntent();
        try {


            participantDetails = intent.getStringArrayListExtra("participantData");
            participantNameEdit.setText(participantDetails.get(0).toString());
            participantAgeEdit.setText(participantDetails.get(1));
            if (participantDetails.get(2).equals("Male")) {
                radioMale.setChecked(true);
                radioFemale.setChecked(false);
            } else if (participantDetails.get(2).equals("Female")) {
                radioMale.setChecked(false);
                radioFemale.setChecked(true);
            }
            participantAddressEdit.setText(participantDetails.get(3));
            participantTelephoneEdit.setText(participantDetails.get(4));
            participantWhatsappEdit.setText(participantDetails.get(5));
            //Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, ""+participantDetails.get(0).toString(), Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void interviewDate(View view) {
        TextView interviewDateText = findViewById(R.id.interviewDateText);
        DatePicker datePicker = new DatePicker(BaselineQuestionnaireRecruitmentActivity.this, interviewDateText);
        String selected_date = datePicker.pickDate();
        // interviewDateText.setText("1. Date of Interview: "+selected_date);
    }

    public void lastMealTime(View view) {
        TimePicker timePicker = new TimePicker(BaselineQuestionnaireRecruitmentActivity.this, lastMealTime);
        timePicker.pickDate();
    }

    public void lastMealDate(View view) {

        DatePicker datePicker = new DatePicker(BaselineQuestionnaireRecruitmentActivity.this, dateLastMeal);
        String selected_date = datePicker.pickDate();

    }

    public void bloodSampleDate(View view) {
        DatePicker datePicker = new DatePicker(BaselineQuestionnaireRecruitmentActivity.this, dateBloodSample);
        String selected_date = datePicker.pickDate();

    }

    public void bloodSampleTime(View view) {
        TimePicker timePicker = new TimePicker(BaselineQuestionnaireRecruitmentActivity.this, bloodsampleTime);
        timePicker.pickDate();
    }

    public void moveToSecondForm(View view) {
        //startActivity(new Intent(CallBackFormActivity.this, CallBackForm2Activity.class));

        try {


            participantDataList = new ParticipantDataList("KL54862", participantDetails.get(0).toString(), participantFatherHusbandEdit.getText().toString(), participantDetails.get(3),
                    participantDetails.get(2), participantDetails.get(1), participantCnicEdit.getText().toString(), participantDetails.get(4), participantDetails.get(5),
                    dateLastMeal.getText().toString(), lastMealTime.getText().toString(), dateBloodSample.getText().toString(), bloodsampleTime.getText().toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(BaselineQuestionnaireRecruitmentActivity.this, BaselineQuestionnaireRecruitment2Activity.class);
        intent.putStringArrayListExtra("participantData", participantDetails);
        intent.putExtra("participantDataList", participantDataList);
        startActivityForResult(intent, 1);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 1) {
            this.finish();
        }
    }

    public void selectYesNoNot(View view) {
        GeneralUtils.selectYesNoNotAnswered(BaselineQuestionnaireRecruitmentActivity.this, view);
    }

    public void CloseForm(View view) {
        finish();
    }

    public void selectTypeOfMI(View view) {
        GeneralUtils.selectTypeOfMIView(BaselineQuestionnaireRecruitmentActivity.this, view);

    }

    public void DiabetesSelect(View view) {
        // Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "API Error.", Toast.LENGTH_SHORT).show();
        DiabeteMellitusDialog dialog = new DiabeteMellitusDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
    }

    public void ThyroidDiseaseSelect(View view) {
        // Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "API Error.", Toast.LENGTH_SHORT).show();
        ThyroidDiseaseDialog dialog = new ThyroidDiseaseDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
    }

    public void ValvularHeartDiseaseSelect(View view) {

        //Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "API Error.", Toast.LENGTH_SHORT).show();
        ValvularHeartDiseaseDialog dialog = new ValvularHeartDiseaseDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
    }


    public void dyslipidemiaSelect(View view) {

        //Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "API Error.", Toast.LENGTH_SHORT).show();

        DyslipidemiaDialog dialog = new DyslipidemiaDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
    }

    public void hypertensionSelect(View view) {

        //Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "API Error.", Toast.LENGTH_SHORT).show();


        HypertensionDialog dialog = new HypertensionDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
    }

    public void liverDiseaseSelect(View view) {

        //Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "API Error.", Toast.LENGTH_SHORT).show();


        LiverDiseaseDialog dialog = new LiverDiseaseDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
    }

    public void miDiseaseSelect(View view) {

        // Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "API Error.", Toast.LENGTH_SHORT).show();


        MyocardialInfarctionDialog dialog = new MyocardialInfarctionDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
    }

    public void seizuresSelect(View view) {

        //Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "API Error.", Toast.LENGTH_SHORT).show();


        SeizuresDialog dialog = new SeizuresDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
    }

    public void openNotes(View view) {
        if (notesOpenCheck) {
            notesLayout.setVisibility(View.GONE);
            notesOpenCheck = false;
        } else {
            notesLayout.setVisibility(View.VISIBLE);
            notesOpenCheck = true;
        }
    }

//    TextView diabetesTextView, thyroidTextView, valvularTextView, dyslipidemiaTextView, hypertensionTextView, liverTextView, miTextView, seizureTextView;

    @Override
    public void onReturnDiabetesData(String data) {
        diabetesTextView.setText(data);
    }

    @Override
    public void onReturnThyroidData(String data) {
        thyroidTextView.setText(data);
    }

    @Override
    public void onReturnValvularData(String data) {
        valvularTextView.setText(data);

    }

    @Override
    public void onReturnDyslipidemiaData(String data) {
        dyslipidemiaTextView.setText(data);

    }

    @Override
    public void onReturnHypertensionData(String data) {
        hypertensionTextView.setText(data);

    }

    @Override
    public void onReturnLiverData(String data) {
        liverTextView.setText(data);

    }

    @Override
    public void onReturnMIData(String data) {
        miTextView.setText(data);

    }

    @Override
    public void onReturnSeizureData(String data) {
        seizureTextView.setText(data);

    }
}