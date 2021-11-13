package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.cncd.first.Dialogs.DiabeteMellitusDialog;
import com.cncd.first.R;
import com.cncd.first.Utils.DatePicker;
import com.cncd.first.Utils.GeneralUtils;
import com.cncd.first.Utils.TimePicker;

public class BaselineQuestionnaireRecruitmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (GeneralUtils.getLanguage(BaselineQuestionnaireRecruitmentActivity.this).equals("ur"))
            GeneralUtils.changeIntoUrdu(BaselineQuestionnaireRecruitmentActivity.this);
        setContentView(R.layout.activity_baseline_questionnaire_recruitment);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

    }


    public void interviewDate(View view) {
        TextView interviewDateText = findViewById(R.id.interviewDateText);
        DatePicker datePicker = new DatePicker(BaselineQuestionnaireRecruitmentActivity.this, interviewDateText);
        String selected_date = datePicker.pickDate();
        // interviewDateText.setText("1. Date of Interview: "+selected_date);
    }

    public void lastMealTime(View view) {
        TextView lastMealTime = findViewById(R.id.lastMealTime);
        TimePicker timePicker = new TimePicker(BaselineQuestionnaireRecruitmentActivity.this, lastMealTime);
        timePicker.pickDate();
    }

    public void lastMealDate(View view) {
        TextView dateLastMeal = findViewById(R.id.dateLastMeal);
        DatePicker datePicker = new DatePicker(BaselineQuestionnaireRecruitmentActivity.this, dateLastMeal);
        String selected_date = datePicker.pickDate();

    }

    public void bloodSampleDate(View view) {
        TextView dateBloodSample = findViewById(R.id.dateBloodSample);
        DatePicker datePicker = new DatePicker(BaselineQuestionnaireRecruitmentActivity.this, dateBloodSample);
        String selected_date = datePicker.pickDate();

    }

    public void bloodSampleTime(View view) {
        TextView bloodsampleTime = findViewById(R.id.bloodsampleTime);
        TimePicker timePicker = new TimePicker(BaselineQuestionnaireRecruitmentActivity.this, bloodsampleTime);
        timePicker.pickDate();
    }

    public void moveToSecondForm(View view) {
        //startActivity(new Intent(CallBackFormActivity.this, CallBackForm2Activity.class));

        Intent intent = new Intent(this, BaselineQuestionnaireRecruitment2Activity.class);
        startActivityForResult(intent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == 1) {
            this.finish();
        }
    }

    public void selectYesNoNot(View view) {
        GeneralUtils.selectYesNoNotAnswered(BaselineQuestionnaireRecruitmentActivity.this, view);
    }

    public void CloseForm(View view) {
        finish();
    }

    public void DiabetesSelect(View view) {
        DiabeteMellitusDialog dialog = new DiabeteMellitusDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
    }
}