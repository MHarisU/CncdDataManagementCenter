package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.cncd.first.R;
import com.cncd.first.Utils.GeneralUtils;
import com.github.gcacace.signaturepad.views.SignaturePad;

public class RecruitmentGeneralExclusionAndSpecificDiseaseActivity extends AppCompatActivity {

    LinearLayout layoutGlobalExclusion, layoutSelectCaseControl, layoutSelectCaseType, layoutParticipant, layoutNameAge;

    CardView consentCard;

    String disease;
    String type;

    SignaturePad mSignaturePad;

    EditText participantAgeEdit;


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

        participantAgeEdit = findViewById(R.id.participantAgeEdit);


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
        Intent intent = null;
        if (disease.equals("MI")){
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, MICaseExclusionInclusionCriteriaActivity.class);
        }
        else if (disease.equals("HF")){
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, HfCaseExcIncCriteriaActivity.class);
        }
        else if (disease.equals("STR")){
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, StrokeCaseExcluIncluCriteriaActivity.class);
        }
        else if (disease.equals("NAFLD")){
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, NAFLDCaseExcluIncluCriteriaActivity.class);
        }
        else if (disease.equals("T2D")){
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, TypeTwoDiabetesExcluIncluCriteriaActivity.class);
        }


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
        Intent intent = null;
        if (disease.equals("MI")){
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, MIControlExclusionInclusionCriteriaActivity.class);
        }
        else if (disease.equals("HF")){
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, HfControlExcIncCriteriaActivity.class);
        }
        else if (disease.equals("STR")){
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, StrokeControlExcluIncluCriteriaActivity.class);
        }
        else if (disease.equals("NAFLD")){
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, NAFLDControlExcluIncluCriteriaActivity.class);
        }
        else if (disease.equals("T2D")){
            intent = new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, TypeTwoDiabetesControlExcluIncluCriteriaActivity.class);
        }


        startActivity(intent);
        finish();
    }

    public void clearPad(View view) {
        mSignaturePad.clear();
    }

    public void participantNameAgeEntered(View view) {

        GeneralUtils.hideSoftKeyboard(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, participantAgeEdit);
        layoutNameAge.setVisibility(View.GONE);
        consentCard.setVisibility(View.VISIBLE);
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);
        consentCard.startAnimation(slide_up);

    }

    public void consentFormAgree(View view) {


        consentCard.setVisibility(View.GONE);
        layoutGlobalExclusion.setVisibility(View.VISIBLE);
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);
        layoutGlobalExclusion.startAnimation(slide_up);

    }
}