package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cncd.first.R;
import com.cncd.first.Utils.DatePicker;
import com.cncd.first.Utils.GeneralUtils;
import com.cncd.first.Utils.TimePicker;

public class BaselineQuestionnaireRecruitment4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseline_questionnaire_recruitment4);
    }



    public void CloseForm(View view) {
        finish();
    }

    public void selectStateOfSubject(View view) {
        GeneralUtils.selectStateOfWomenSubject(BaselineQuestionnaireRecruitment4Activity.this, view);

    }

    public void selectYesNoNot(View view) {
        GeneralUtils.selectYesNoNotAnswered(BaselineQuestionnaireRecruitment4Activity.this, view);

    }

    public void selectWhyDidMenstrualStop(View view) {
        GeneralUtils.selectWhyDidPeriodsStop(BaselineQuestionnaireRecruitment4Activity.this, view);

    }

    public void testDate(View view) {
        TextView dateTest = findViewById(R.id.dateTest);
        DatePicker datePicker = new DatePicker(BaselineQuestionnaireRecruitment4Activity.this, dateTest);
        String selected_date = datePicker.pickDate();
    }

    public void testTime(View view) {
        TextView testTime = findViewById(R.id.lastMealTime);
        TimePicker timePicker = new TimePicker(BaselineQuestionnaireRecruitment4Activity.this, testTime);
        timePicker.pickDate();
    }

    public void selectBodyType(View view) {
        GeneralUtils.selectBodyType(BaselineQuestionnaireRecruitment4Activity.this, view);

    }



    public void submitForm(View view) {
        this.setResult(1);
        this.finish();
    }
}