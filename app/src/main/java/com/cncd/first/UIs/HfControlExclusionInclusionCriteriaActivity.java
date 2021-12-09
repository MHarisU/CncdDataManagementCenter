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

public class HfControlExclusionInclusionCriteriaActivity extends AppCompatActivity {

    LinearLayout layoutHFExclusion, layoutHFInclusion;

    ArrayList<String> participantDetails = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hf_control_exc_inc_criteria);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        loadUI();
        loadParticipantData();
    }

    private void loadParticipantData() {
        Intent intent = getIntent();
        participantDetails = intent.getStringArrayListExtra("participantData");
        Toast.makeText(HfControlExclusionInclusionCriteriaActivity.this, ""+participantDetails.get(0).toString(), Toast.LENGTH_SHORT).show();
    }

    private void loadUI() {
        layoutHFExclusion = findViewById(R.id.layoutHFExclusion);
        layoutHFInclusion = findViewById(R.id.layoutHFInclusion);
    }


    public void CloseForm(View view) {
        finish();
    }


    public void HfExclusionYes(View view) {
        GeneralUtils.alertDialogBoxSimpleCloseActivity(HfControlExclusionInclusionCriteriaActivity.this, "Info", "This case can not be registered");

    }

    public void HfExclusionNo(View view) {

        layoutHFExclusion.setVisibility(View.GONE);
        layoutHFInclusion.setVisibility(View.VISIBLE);
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);
        layoutHFInclusion.startAnimation(slide_up);
    }

    public void ContinueClick(View view) {
        Intent intent = new Intent(HfControlExclusionInclusionCriteriaActivity.this, BaselineQuestionnaireRecruitmentActivity.class);
        intent.putStringArrayListExtra("participantData", participantDetails);
        startActivity(intent);
        finish();
    }
}