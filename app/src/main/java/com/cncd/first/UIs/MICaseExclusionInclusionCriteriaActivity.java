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

public class MICaseExclusionInclusionCriteriaActivity extends AppCompatActivity {

    LinearLayout layoutMIExclusion, layoutMIInclusion;

    ArrayList<String> participantDetails = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micase_exclusion_inclusion_criteria);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);



        loadUI();
        loadParticipantData();
    }

    private void loadParticipantData() {
        Intent intent = getIntent();
        participantDetails = intent.getStringArrayListExtra("participantData");
        Toast.makeText(MICaseExclusionInclusionCriteriaActivity.this, ""+participantDetails.get(0).toString(), Toast.LENGTH_SHORT).show();
    }

    private void loadUI() {
        layoutMIExclusion = findViewById(R.id.layoutMIExclusion);
        layoutMIInclusion = findViewById(R.id.layoutMIInclusion);
    }

    public void CloseForm(View view) {
        finish();
    }

    public void mIExclusionYes(View view) {
        GeneralUtils.alertDialogBoxSimpleCloseActivity(MICaseExclusionInclusionCriteriaActivity.this, "Info", "This case can not be registered");
    }

    public void mIExclusionNo(View view) {
        layoutMIExclusion.setVisibility(View.GONE);
        layoutMIInclusion.setVisibility(View.VISIBLE);
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);
        layoutMIInclusion.startAnimation(slide_up);
    }
}