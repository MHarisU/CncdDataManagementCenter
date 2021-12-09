package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.cncd.first.R;
import com.cncd.first.Utils.GeneralUtils;
import com.github.gcacace.signaturepad.views.SignaturePad;

import java.util.ArrayList;

public class RecruitmentGeneralExclusionAndSpecificDiseaseActivity extends AppCompatActivity {

    LinearLayout layoutGlobalExclusion, layoutSelectCaseControl, layoutSelectCaseType, layoutParticipant, layoutNameAge;

    CardView consentCard;

    String disease;
    String type;

    SignaturePad mSignaturePad;
    boolean signCheck = false;

    EditText participantAgeEdit, participantNameEdit, participantAddressEdit;

    RadioButton radioMale, radioFemale;

    String participantName;
    String participantAge;
    String participantAddress;
    String participantGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruitment_general_exclusion_and_specific_disease);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        loadUI();
    }

    private void loadUI() {

        layoutGlobalExclusion = findViewById(R.id.layoutGlobalExclusion);
        layoutSelectCaseControl = findViewById(R.id.layoutSelectCaseControl);
        layoutSelectCaseType = findViewById(R.id.layoutSelectCaseType);
        layoutParticipant = findViewById(R.id.layoutParticipant);
        layoutNameAge = findViewById(R.id.layoutNameAge);
        consentCard = findViewById(R.id.consentCard);
        mSignaturePad = (SignaturePad) findViewById(R.id.signature_pad);
        mSignaturePad.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                signCheck = true;
                return false;
            }
        });

        participantNameEdit = findViewById(R.id.participantName);
        participantAgeEdit = findViewById(R.id.participantAgeEdit);
        participantAddressEdit = findViewById(R.id.participantAddress);

        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);


    }

    public void globalRecruitmentExclusionYes(View view) {
        GeneralUtils.alertDialogBoxSimpleCloseActivity(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, "Info", "This case can not be registered");
    }

    public void globalRecruitmentExclusionNo(View view) {

        layoutGlobalExclusion.setVisibility(View.GONE);
        layoutSelectCaseType.setVisibility(View.VISIBLE);
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);
        layoutSelectCaseType.startAnimation(slide_up);

    }

    public void CloseForm(View view) {
        finish();
    }


    public void selectCase(View view) {

        ArrayList<String> participantDetails = new ArrayList<>();
        participantDetails.add(participantName);
        participantDetails.add(participantAge);
        participantDetails.add(participantGender);
        participantDetails.add(participantAddress);

        Intent intent = null;


        if (disease.equals("MI")) {
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, MICaseExclusionInclusionCriteriaActivity.class);
        } else if (disease.equals("HF")) {
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, HfCaseExclusionInclusionCriteriaActivity.class);
        } else if (disease.equals("STR")) {
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, StrokeCaseExclusionInclusionCriteriaActivity.class);
        } else if (disease.equals("NAFLD")) {
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, NAFLDCaseExclusionInclusionCriteriaActivity.class);
        } else if (disease.equals("T2D")) {
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, TypeTwoDiabetesExclusionInclusionCriteriaActivity.class);
        }


        intent.putStringArrayListExtra("participantData", participantDetails);
        startActivity(intent);
        finish();
    }

    public void diseaseTypeMI(View view) {

        disease = "MI";

        layoutSelectCaseType.setVisibility(View.GONE);
        layoutSelectCaseControl.setVisibility(View.VISIBLE);
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);
        layoutSelectCaseControl.startAnimation(slide_up);
    }

    public void diseaseTypeHF(View view) {


        disease = "HF";

        layoutSelectCaseType.setVisibility(View.GONE);
        layoutSelectCaseControl.setVisibility(View.VISIBLE);
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);
        layoutSelectCaseControl.startAnimation(slide_up);

    }

    public void diseaseTypeStroke(View view) {

        disease = "STR";

        layoutSelectCaseType.setVisibility(View.GONE);
        layoutSelectCaseControl.setVisibility(View.VISIBLE);
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);
        layoutSelectCaseControl.startAnimation(slide_up);
    }

    public void diseaseTypeNAFLD(View view) {


        disease = "NAFLD";

        layoutSelectCaseType.setVisibility(View.GONE);
        layoutSelectCaseControl.setVisibility(View.VISIBLE);
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);
        layoutSelectCaseControl.startAnimation(slide_up);

    }

    public void diseaseTypeT2D(View view) {


        disease = "T2D";

        layoutSelectCaseType.setVisibility(View.GONE);
        layoutSelectCaseControl.setVisibility(View.VISIBLE);
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);
        layoutSelectCaseControl.startAnimation(slide_up);

    }

    public void selectControl(View view) {


        ArrayList<String> participantDetails = new ArrayList<>();
        participantDetails.add(participantName);
        participantDetails.add(participantAge);
        participantDetails.add(participantGender);
        participantDetails.add(participantAddress);

        Intent intent = null;
        if (disease.equals("MI")) {
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, MIControlExclusionInclusionCriteriaActivity.class);
        } else if (disease.equals("HF")) {
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, HfControlExclusionInclusionCriteriaActivity.class);
        } else if (disease.equals("STR")) {
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, StrokeControlExclusionInclusionCriteriaActivity.class);
        } else if (disease.equals("NAFLD")) {
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, NAFLDControlExclusionInclusionCriteriaActivity.class);
        } else if (disease.equals("T2D")) {
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, TypeTwoDiabetesControlExclusionInclusionCriteriaActivity.class);
        }

        intent.putStringArrayListExtra("participantData", participantDetails);
        startActivity(intent);
        finish();
    }

    public void clearPad(View view) {
        signCheck = false;

        mSignaturePad.clear();
    }

    public void participantNameAgeEntered(View view) {

        participantName = participantNameEdit.getText().toString();
        participantAge = participantAgeEdit.getText().toString();
        participantAddress = participantAddressEdit.getText().toString();
        participantGender = "Male";

        if (radioMale.isChecked()) {
            participantGender = "Male";
        } else if (radioFemale.isChecked()) {
            participantGender = "Female";
        }

        if (participantName != null && !participantName.equals("") &&
                participantAge != null && !participantAge.equals("") &&
                participantAddress != null && !participantAddress.equals("") &&
                participantGender != null && !participantGender.equals("")) {

            GeneralUtils.hideSoftKeyboard(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, participantAgeEdit);
            layoutNameAge.setVisibility(View.GONE);
            consentCard.setVisibility(View.VISIBLE);
            Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.slide_in_bottom);
            consentCard.startAnimation(slide_up);

           //Toast.makeText(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, participantName + "\n" + participantAge + "\n" + participantAddress + "\n" + participantGender + "\n", Toast.LENGTH_SHORT).show();
        } else {
            GeneralUtils.alertDialogBoxSimple(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, "Info", "Please fill all fields correctly");

        }


    }

    public void consentFormAgree(View view) {

        if (!signCheck){
            GeneralUtils.alertDialogBoxSimple(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, "Info", "Please sign to agree");

        }else {

            consentCard.setVisibility(View.GONE);
            layoutGlobalExclusion.setVisibility(View.VISIBLE);
            Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.slide_in_bottom);
            layoutGlobalExclusion.startAnimation(slide_up);
        }

    }
}