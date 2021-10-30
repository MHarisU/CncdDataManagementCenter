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

public class HfControlExcIncCriteriaActivity extends AppCompatActivity {

    LinearLayout layoutHFExclusion, layoutHFInclusion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hf_control_exc_inc_criteria);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        loadUI();


    }

    private void loadUI() {
        layoutHFExclusion = findViewById(R.id.layoutHFExclusion);
        layoutHFInclusion = findViewById(R.id.layoutHFInclusion);
    }


    public void CloseForm(View view) {
        finish();
    }


    public void HfExclusionYes(View view) {
        GeneralUtils.alertDialogBoxSimpleCloseActivity(HfControlExcIncCriteriaActivity.this, "Info", "This case can not be registered");

    }

    public void HfExclusionNo(View view) {

        layoutHFExclusion.setVisibility(View.GONE);
        layoutHFInclusion.setVisibility(View.VISIBLE);
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);
        layoutHFInclusion.startAnimation(slide_up);
    }

}