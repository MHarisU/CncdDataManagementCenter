package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cncd.first.Models.BaseParticipant.ParticipantDataList;
import com.cncd.first.R;
import com.cncd.first.Utils.DatePicker;
import com.cncd.first.Utils.GeneralUtils;
import com.cncd.first.Utils.TimePicker;

import java.util.ArrayList;

public class BaselineQuestionnaireRecruitment4Activity extends AppCompatActivity {

    ParticipantDataList participantDataList;



    CardView notesLayout;
    EditText notesEdit;
    Boolean notesOpenCheck = false;

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

        if (notesOpenCheck){
            notesLayout.setVisibility(View.GONE);
            notesOpenCheck = false;
        }else {
            notesLayout.setVisibility(View.VISIBLE);
            notesOpenCheck = true;
        }

    }
}