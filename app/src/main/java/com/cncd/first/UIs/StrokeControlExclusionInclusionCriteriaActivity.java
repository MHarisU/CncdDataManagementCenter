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

public class StrokeControlExclusionInclusionCriteriaActivity extends AppCompatActivity {

    LinearLayout layoutStrokeExclusion, layoutStrokeInclusion;

    ArrayList<String> participantDetails = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroke_control_exclu_inclu_criteria);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        loadUI();
        loadParticipantData();
    }

    private void loadParticipantData() {
        Intent intent = getIntent();
        participantDetails = intent.getStringArrayListExtra("participantData");
        Toast.makeText(StrokeControlExclusionInclusionCriteriaActivity.this, ""+participantDetails.get(0).toString(), Toast.LENGTH_SHORT).show();
    }

    private void loadUI() {
        layoutStrokeExclusion = findViewById(R.id.layoutStrokeExclusion);
        layoutStrokeInclusion = findViewById(R.id.layoutStrokeInclusion);
    }

    public void CloseForm(View view) {
        finish();
    }

    public void StrokeExclusionYes(View view) {
        GeneralUtils.alertDialogBoxSimpleCloseActivity(this, "Info", "This case can not be registered");

    }

    public void StrokeExclusionNo(View view) {

        layoutStrokeExclusion.setVisibility(View.GONE);
        layoutStrokeInclusion.setVisibility(View.VISIBLE);
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);
        layoutStrokeInclusion.startAnimation(slide_up);
    }

    public void ContinueClick(View view) {
        Intent intent = new Intent(StrokeControlExclusionInclusionCriteriaActivity.this, BaselineQuestionnaireRecruitmentActivity.class);
        intent.putStringArrayListExtra("participantData", participantDetails);
        startActivity(intent);
        finish();
    }
}