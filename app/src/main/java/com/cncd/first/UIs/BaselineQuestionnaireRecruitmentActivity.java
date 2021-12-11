package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.cncd.first.Dialogs.DiabeteMellitusDialog;
import com.cncd.first.Dialogs.ThyroidDiseaseDialog;
import com.cncd.first.Dialogs.ValvularHeartDiseaseDialog;
import com.cncd.first.R;
import com.cncd.first.Utils.DatePicker;
import com.cncd.first.Utils.GeneralUtils;
import com.cncd.first.Utils.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BaselineQuestionnaireRecruitmentActivity extends AppCompatActivity {

    ArrayList<String> participantDetails = new ArrayList<>();

    TextView interviewDateText, dateLastMeal, dateBloodSample;
    EditText interviewInitialsEdit, refTargetEdit, participantNameEdit, participantFatherHusbandEdit, participantAddressEdit, participantTelephoneEdit, participantWhatsappEdit;
    EditText participantAgeEdit, participantCnicEdit;
    RadioButton radioMale, radioFemale;

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
        interviewDateText.setText("1. Date of Interview: "+formattedDate);
    }

    private void loadUI() {
        interviewDateText = findViewById(R.id.interviewDateText);
        interviewInitialsEdit = findViewById(R.id.interviewInitialsEdit);
        refTargetEdit = findViewById(R.id.refTargetEdit);

        participantNameEdit = findViewById(R.id.participantNameEdit);
        participantFatherHusbandEdit = findViewById(R.id.participantFatherHusbandEdit);
        participantAddressEdit = findViewById(R.id.participantAddressEdit);
        participantTelephoneEdit = findViewById(R.id.participantTelephoneEdit);
        participantWhatsappEdit = findViewById(R.id.participantWhatsappEdit);

        participantAgeEdit = findViewById(R.id.participantAgeEdit);
        participantCnicEdit = findViewById(R.id.participantCnicEdit);

        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);

    }

    private void loadParticipantData() {
        Intent intent = getIntent();
        participantDetails = intent.getStringArrayListExtra("participantData");
        participantNameEdit.setText(participantDetails.get(0).toString());
        participantAgeEdit.setText(participantDetails.get(1));
        if (participantDetails.get(2).equals("Male")){
            radioMale.setChecked(true);
            radioFemale.setChecked(false);
        }else if (participantDetails.get(2).equals("Female")){
            radioMale.setChecked(false);
            radioFemale.setChecked(true);
        }
        participantAddressEdit.setText(participantDetails.get(3));
        //Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, ""+participantDetails.get(0).toString(), Toast.LENGTH_SHORT).show();
    }

    public void interviewDate(View view) {
        TextView interviewDateText = findViewById(R.id.interviewDateText);
        DatePicker datePicker = new DatePicker(BaselineQuestionnaireRecruitmentActivity.this, interviewDateText);
        String selected_date = datePicker.pickDate();
        // interviewDateText.setText("1. Date of Interview: "+selected_date);
    }

    public void lastMealTime(View view) {
        TextView lastMealTime = findViewById(R.id.lastMealTime);
        TimePicker timePicker = new TimePicker(BaselineQuestionnaireRecruitmentActivity.this, lastMealTime);
        timePicker.pickDate();
    }

    public void lastMealDate(View view) {

        dateLastMeal = findViewById(R.id.dateLastMeal);
        DatePicker datePicker = new DatePicker(BaselineQuestionnaireRecruitmentActivity.this, dateLastMeal);
        String selected_date = datePicker.pickDate();

    }

    public void bloodSampleDate(View view) {
        dateBloodSample = findViewById(R.id.dateBloodSample);
        DatePicker datePicker = new DatePicker(BaselineQuestionnaireRecruitmentActivity.this, dateBloodSample);
        String selected_date = datePicker.pickDate();

    }

    public void bloodSampleTime(View view) {
        TextView bloodsampleTime = findViewById(R.id.bloodsampleTime);
        TimePicker timePicker = new TimePicker(BaselineQuestionnaireRecruitmentActivity.this, bloodsampleTime);
        timePicker.pickDate();
    }

    public void moveToSecondForm(View view) {
        //startActivity(new Intent(CallBackFormActivity.this, CallBackForm2Activity.class));

        Intent intent = new Intent(this, BaselineQuestionnaireRecruitment2Activity.class);
        startActivityForResult(intent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == 1) {
            this.finish();
        }
    }

    public void selectYesNoNot(View view) {
        GeneralUtils.selectYesNoNotAnswered(BaselineQuestionnaireRecruitmentActivity.this, view);
    }

    public void CloseForm(View view) {
        finish();
    }

    public void DiabetesSelect(View view) {
        DiabeteMellitusDialog dialog = new DiabeteMellitusDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
    }

    public void ThyroidDiseaseSelect(View view) {

        ThyroidDiseaseDialog dialog = new ThyroidDiseaseDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
    }

    public void ValvularHeartDiseaseSelect(View view) {

        ValvularHeartDiseaseDialog dialog = new ValvularHeartDiseaseDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
    }

}