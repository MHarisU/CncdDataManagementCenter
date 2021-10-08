package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.cncd.first.R;
import com.cncd.first.Utils.GeneralUtils;

public class RecruitmentGeneralExclusionAndSpecificDiseaseActivity extends AppCompatActivity {

    LinearLayout layoutGlobalExclusion, layoutSelectCaseControl, layoutSelectCaseType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruitment_general_exclusion_and_specific_disease);


        loadUI();
    }

    private void loadUI() {

        layoutGlobalExclusion = findViewById(R.id.layoutGlobalExclusion);
        layoutSelectCaseControl = findViewById(R.id.layoutSelectCaseControl);
        layoutSelectCaseType = findViewById(R.id.layoutSelectCaseType);

    }

    public void globalRecruitmentExclusionYes(View view) {
        GeneralUtils.alertDialogBoxSimpleCloseActivity(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, "Info", "This case can not be registered");
    }

    public void globalRecruitmentExclusionNo(View view) {

        layoutGlobalExclusion.setVisibility(View.GONE);
        layoutSelectCaseControl.setVisibility(View.VISIBLE);
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);
        layoutSelectCaseControl.startAnimation(slide_up);

    }

    public void CloseForm(View view) {
        finish();
    }

    public void diseaseTypeCase(View view) {
        layoutSelectCaseControl.setVisibility(View.GONE);
        layoutSelectCaseType.setVisibility(View.VISIBLE);
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);
        layoutSelectCaseType.startAnimation(slide_up);
    }

    public void selectMICase(View view) {
        startActivity(new Intent(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this, MICaseExclusionInclusionCriteriaActivity.class));
        finish();
    }
}