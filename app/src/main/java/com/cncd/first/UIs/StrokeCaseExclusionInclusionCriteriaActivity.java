package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.cncd.first.R;
import com.cncd.first.Utils.GeneralUtils;

public class StrokeCaseExclusionInclusionCriteriaActivity extends AppCompatActivity {

    LinearLayout layoutStrokeExclusion, layoutStrokeInclusion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroke_case_exclu_inclu_criteria);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        loadUI();


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
}