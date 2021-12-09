package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cncd.first.R;
import com.cncd.first.Utils.GeneralUtils;

import java.util.ArrayList;

public class TypeTwoDiabetesControlExclusionInclusionCriteriaActivity extends AppCompatActivity {

    LinearLayout layoutT2DExclusion, layoutT2DInclusion;

    ArrayList<String> participantDetails = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_two_diabetes_control_exclu_inclu_criteria);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        loadUI();
        loadParticipantData();
    }

    private void loadParticipantData() {
        Intent intent = getIntent();
        participantDetails = intent.getStringArrayListExtra("participantData");
        Toast.makeText(TypeTwoDiabetesControlExclusionInclusionCriteriaActivity.this, ""+participantDetails.get(0).toString(), Toast.LENGTH_SHORT).show();
    }

    private void loadUI() {
        layoutT2DExclusion = findViewById(R.id.layoutT2DExclusion);
        layoutT2DInclusion = findViewById(R.id.layoutT2DInclusion);
    }
    public void CloseForm(View view) {
        finish();
    }

    public void T2DExclusionYes(View view) {
        GeneralUtils.alertDialogBoxSimpleCloseActivity(this, "Info", "This case can not be registered");

    }

    public void HfExclusionNo(View view) {

        layoutT2DExclusion.setVisibility(View.GONE);
        layoutT2DInclusion.setVisibility(View.VISIBLE);
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);
        layoutT2DInclusion.startAnimation(slide_up);
    }

    public void ContinueClick(View view) {
        Intent intent = new Intent(TypeTwoDiabetesControlExclusionInclusionCriteriaActivity.this, BaselineQuestionnaireRecruitmentActivity.class);
        intent.putStringArrayListExtra("participantData", participantDetails);
        startActivity(intent);
        finish();
    }
}