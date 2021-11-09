package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.cncd.first.R;

public class BaselineQuestionnaireRecruitmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseline_questionnaire_recruitment);
    }

    public void CloseForm(View view) {
        finish();
    }
}