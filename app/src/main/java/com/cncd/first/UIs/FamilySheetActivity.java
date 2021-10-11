package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.cncd.first.Models.FamilyModel.FamilyAdapter;
import com.cncd.first.Models.FamilyModel.FamilyList;
import com.cncd.first.Models.ParticipantSubjectModel.ParticipantSubjectAdapter;
import com.cncd.first.Models.ParticipantSubjectModel.ParticipantSubjectList;
import com.cncd.first.R;
import com.cncd.first.Utils.DatePicker;
import com.cncd.first.Utils.GeneralUtils;

import java.util.ArrayList;

public class FamilySheetActivity extends AppCompatActivity {


    LinearLayout layoutAddNewSubjects;
    ImageView closeAddNewSubject, closeAddNewFamily;

    EditText searchParticipantIdEditText, subjectIDEdit, subjectNameEdit, subjectFatherHusbandEdit, subjectAge;
    TextView relationshipWithCallBack, relationshipWithSpouse;
    RadioButton radio1_s, radio2_s;


    RecyclerView subjectsRecycler;
    ArrayList<ParticipantSubjectList> subjectsLists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (GeneralUtils.getLanguage(FamilySheetActivity.this).equals("ur"))
            GeneralUtils.changeIntoUrdu(FamilySheetActivity.this);
        setContentView(R.layout.activity_family_sheet);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        loadUIs();

        loadFamily();

    }

    private void loadFamily() {
        subjectsRecycler = findViewById(R.id.subjectsRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        subjectsRecycler.setLayoutManager(linearLayoutManager);
        subjectsLists = new ArrayList<ParticipantSubjectList>();

        /*medicationLists.add(new MedicationList("1.", "Norvac", "Amlodipine", "30"));
        medicationLists.add(new MedicationList("2.", "Gabica", "Pregablin", "30"));
        medicationLists.add(new MedicationList("3.", "ESSO 40mg", "Esomeperazol", "30"));*/

        ParticipantSubjectAdapter adapter = new ParticipantSubjectAdapter(subjectsLists, FamilySheetActivity.this);
        subjectsRecycler.setAdapter(adapter);
    }

    private void loadUIs() {
        layoutAddNewSubjects = findViewById(R.id.layoutAddNewSubjects);
        closeAddNewSubject = findViewById(R.id.closeAddNewSubject);

        subjectIDEdit = findViewById(R.id.subjectIDEdit);
        subjectNameEdit = findViewById(R.id.subjectNameEdit);
        subjectFatherHusbandEdit = findViewById(R.id.subjectFatherHusbandEdit);
        subjectAge = findViewById(R.id.subjectAge);
        relationshipWithCallBack = findViewById(R.id.relationshipWithCallBack);
        relationshipWithSpouse = findViewById(R.id.relationshipWithSpouse);
        radio1_s = findViewById(R.id.radio1_s);
        radio2_s = findViewById(R.id.radio2_s);

        searchParticipantIdEditText = findViewById(R.id.searchParticipantIdEditText);
        searchParticipantIdEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String txt = searchParticipantIdEditText.getText().toString();
                if (txt.length() > 4) {
                    ProgressDialog dialog = new ProgressDialog(FamilySheetActivity.this);
                    dialog.setMessage("Please wait loading participant details");
                    dialog.setIndeterminate(true);
                    dialog.show();
                    GeneralUtils.hideSoftKeyboard(FamilySheetActivity.this, searchParticipantIdEditText);


                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dialog.dismiss();
                            LoadInfo();
                        }
                    },3000);


                }

            }
        });


    }

    private void LoadInfo() {
        TextView participantName = findViewById(R.id.participantName);
        TextView participantAddress = findViewById(R.id.participantAddress);
        TextView participantPhone = findViewById(R.id.participantPhone);
        TextView participantWhatsapp = findViewById(R.id.participantWhatsapp);
        TextView participantAge = findViewById(R.id.participantAge);
        TextView participantCnic = findViewById(R.id.participantCnic);

        participantName.setText("Ali Khan");
        participantAddress.setText("House No. 24/1, Defence View, Near Iqra University, Main Service Road, Karachi");
        participantPhone.setText("+923473647030");
        participantWhatsapp.setText("+923473647030");
        participantAge.setText("43 Years");
        participantCnic.setText("45403-2947846-2");

    }

    public void CloseForm(View view) {
        finish();
    }

    public void openAddSubject(View view) {
        layoutAddNewSubjects.setVisibility(View.VISIBLE);

    }

    public void dateSelect(View view) {
        TextView dateText = findViewById(R.id.dateText);
        DatePicker datePicker = new DatePicker(FamilySheetActivity.this, dateText);
        String selected_date = datePicker.pickDate();
    }

    public void closeAddNewSubjectLayout(View view) {
        layoutAddNewSubjects.setVisibility(View.GONE);
    }

    public void addSubject(View view) {


        String subjectID = subjectIDEdit.getText().toString();
        String subjectName = subjectNameEdit.getText().toString();
        String subjectFatherHusband = subjectFatherHusbandEdit.getText().toString();
        String subjectAgeString = subjectAge.getText().toString();
        String gender = null;
        String subjectRelationWithCallback = relationshipWithCallBack.getText().toString();
        String subjectRelationWithSpouse = relationshipWithSpouse.getText().toString();

        if (radio1_s.isChecked()) {
            gender = "Male";
        } else if (radio2_s.isChecked()) {
            gender = "Female";
        }


        if (
                subjectID != null && !subjectID.equals("")
                        && subjectName != null && !subjectName.equals("")
                        && subjectFatherHusband != null && !subjectFatherHusband.equals("")
                        && subjectAgeString != null && !subjectAgeString.equals("")
                        && gender != null && !gender.equals("")
                        && subjectRelationWithCallback != null && !subjectRelationWithCallback.equals("")
                        && subjectRelationWithSpouse != null && !subjectRelationWithSpouse.equals("")
        ) {

            subjectsLists.add(new ParticipantSubjectList(subjectID, subjectName, subjectFatherHusband, subjectAgeString, gender, subjectRelationWithCallback, subjectRelationWithSpouse));


            //medicationLists.notify();
            ParticipantSubjectAdapter adapter = new ParticipantSubjectAdapter(subjectsLists, FamilySheetActivity.this);
            subjectsRecycler.setAdapter(adapter);

            GeneralUtils.hideSoftKeyboard(FamilySheetActivity.this, subjectAge);

            subjectIDEdit.setText("");
            subjectNameEdit.setText("");
            subjectFatherHusbandEdit.setText("");
            subjectAge.setText("");
            relationshipWithCallBack.setText("");
            relationshipWithSpouse.setText("");
            layoutAddNewSubjects.setVisibility(View.GONE);

            GeneralUtils.alertDialogBoxSimple(FamilySheetActivity.this, "Info", "Subject Added");


        } else {
            GeneralUtils.alertDialogBoxSimple(FamilySheetActivity.this, "Alert", "Please fill all fields correctly");

        }
    }

    public void submitFamilySheet(View view) {
    }

    public void selectRelationWithParticipant(View view) {
        GeneralUtils.selectRelationExtra(FamilySheetActivity.this, view);

    }

    public void selectRelationshipSpouse(View view) {
        GeneralUtils.selectRelationWithSpouse(FamilySheetActivity.this, view);

    }
}