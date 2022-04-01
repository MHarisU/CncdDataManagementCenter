package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cncd.first.Models.BaseParticipant.ParticipantDataList;
import com.cncd.first.R;
import com.cncd.first.Utils.DatePicker;
import com.cncd.first.Utils.GeneralUtils;
import com.cncd.first.Utils.TimePicker;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BaselineQuestionnaireRecruitment4Activity extends AppCompatActivity {

    ParticipantDataList participantDataList;


    CardView notesLayout;
    EditText notesEdit;
    Boolean notesOpenCheck = false;

    EditText bmiEditBox, heightEditBox, weightEditBox;

    //Women UI
    TextView womenStateOfSubject, womenHadPeriodInLast12Months, womenWhyPeriodStopped, womenEverUsedHormoneReplacement, womenEverHadAbortion, womenEverHadEclampsia,
            womenEverHadGestationalDiabetesPregnancy, womenEverDeliveredPreamatureBaby;
    EditText womenWhenPeriodStopped, womenNumberOfAbortions ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseline_questionnaire_recruitment4);


        loadParticipantData();

        loadUI();

    }

    private void loadUI() {

        notesLayout = findViewById(R.id.notesLayout);
        notesEdit = findViewById(R.id.notesEdit);

        heightEditBox = findViewById(R.id.heightEditBox);
        weightEditBox = findViewById(R.id.weightEditBox);
        bmiEditBox = findViewById(R.id.bmiEditBox);


        weightEditBox.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                DecimalFormat df = new DecimalFormat("0.00");


                String height = heightEditBox.getText().toString();
                String weight = weightEditBox.getText().toString();
                if (height != null && !height.equals("") && s != null && !s.equals("")) {
                    try {

                        height = String.valueOf(Double.parseDouble(height) / 100);
                        height = String.valueOf(Double.parseDouble(height) * Double.parseDouble(height));
                        String bmi = String.valueOf(df.format(Double.parseDouble(weight) / Double.parseDouble(height)));
                        bmiEditBox.setText(bmi);

                    }catch (Exception e){
                        bmiEditBox.setText("0");
                        e.printStackTrace();
                    }
                }
            }
        });


        womenStateOfSubject = findViewById(R.id.womenStateOfSubject);
        womenHadPeriodInLast12Months = findViewById(R.id.womenHadPeriodInLast12Months);
        womenWhyPeriodStopped = findViewById(R.id.womenWhyPeriodStopped);
        womenEverUsedHormoneReplacement = findViewById(R.id.womenEverUsedHormoneReplacement);
        womenEverHadAbortion = findViewById(R.id.womenEverHadAbortion);
        womenEverHadEclampsia = findViewById(R.id.womenEverHadEclampsia);
        womenEverHadGestationalDiabetesPregnancy = findViewById(R.id.womenEverHadGestationalDiabetesPregnancy);
        womenEverDeliveredPreamatureBaby = findViewById(R.id.womenEverDeliveredPreamatureBaby);
        womenWhenPeriodStopped = findViewById(R.id.womenWhenPeriodStopped);
        womenNumberOfAbortions = findViewById(R.id.womenNumberOfAbortions);


    }

    //  ArrayList<String> participantDetails = new ArrayList<>();

    private void loadParticipantData() {
        Intent intent = getIntent();
        participantDataList = (ParticipantDataList) getIntent().getSerializableExtra("participantDataList");

        //  participantDetails = intent.getStringArrayListExtra("participantData");
        //Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, ""+participantDetails.get(0).toString(), Toast.LENGTH_SHORT).show();
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


        Intent intent = new Intent(BaselineQuestionnaireRecruitment4Activity.this, PdfReportActivity.class);
        intent.putExtra("participantDataList", participantDataList);
        // intent.putStringArrayListExtra("participantData", participantDetails);
        startActivity(intent);


        this.setResult(1);
        this.finish();
    }


    public void openNotes(View view) {

        if (notesOpenCheck) {
            notesLayout.setVisibility(View.GONE);
            notesOpenCheck = false;
        } else {
            notesLayout.setVisibility(View.VISIBLE);
            notesOpenCheck = true;
        }

    }
}