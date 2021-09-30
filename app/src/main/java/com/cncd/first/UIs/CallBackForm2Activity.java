package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.cncd.first.Models.FamilyModel.FamilyAdapter;
import com.cncd.first.Models.FamilyModel.FamilyList;
import com.cncd.first.Models.MedicationModel.MedicationAdapter;
import com.cncd.first.Models.MedicationModel.MedicationList;
import com.cncd.first.R;
import com.cncd.first.Utils.GeneralUtils;
import com.cncd.first.Utils.JsonArrayToList;
import com.cncd.first.Utils.JsonListToJsonArray;
import com.cncd.first.Utils.LoadListToMenu;

import java.util.ArrayList;
import java.util.List;

public class CallBackForm2Activity extends AppCompatActivity {

    LinearLayout layoutAddNewMed, layoutAddNewFamily;
    ImageView closeAddNewMed, closeAddNewFamily;

    RecyclerView medicationRecycler;
    ArrayList<MedicationList> medicationLists;


    RecyclerView familyRecycler;
    ArrayList<FamilyList> familyLists;

    EditText drugNameEdit, drugGenericEdit, drugDurationEdit;
    EditText specifyConditionEdit, ageDiagnosedEdit;
    TextView medConditionEdit, relationEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (GeneralUtils.getLanguage(CallBackForm2Activity.this).equals("ur"))
            GeneralUtils.changeIntoUrdu(CallBackForm2Activity.this);
        setContentView(R.layout.activity_call_back_form2);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        loadUIs();

        loadMedications();

        loadFamily();

    }

    private void loadUIs() {


        layoutAddNewMed = findViewById(R.id.layoutAddNewMed);
        closeAddNewMed = findViewById(R.id.closeAddNewMed);

        drugNameEdit = findViewById(R.id.drugNameEdit);
        drugGenericEdit = findViewById(R.id.drugGenericEdit);
        drugDurationEdit = findViewById(R.id.drugDurationEdit);


        layoutAddNewFamily = findViewById(R.id.layoutAddNewFamily);
        closeAddNewFamily = findViewById(R.id.closeAddNewFamily);

        medConditionEdit = findViewById(R.id.medConditionEdit);
        specifyConditionEdit = findViewById(R.id.specifyConditionEdit);
        relationEdit = findViewById(R.id.relationEdit);
        ageDiagnosedEdit = findViewById(R.id.ageDiagnosedEdit);
    }

    private void loadMedications() {
        medicationRecycler = findViewById(R.id.medicationRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        medicationRecycler.setLayoutManager(linearLayoutManager);
        medicationLists = new ArrayList<MedicationList>();

        /*medicationLists.add(new MedicationList("1.", "Norvac", "Amlodipine", "30"));
        medicationLists.add(new MedicationList("2.", "Gabica", "Pregablin", "30"));
        medicationLists.add(new MedicationList("3.", "ESSO 40mg", "Esomeperazol", "30"));*/

        MedicationAdapter adapter = new MedicationAdapter(medicationLists, CallBackForm2Activity.this);
        medicationRecycler.setAdapter(adapter);
    }

    private void loadFamily() {
        familyRecycler = findViewById(R.id.familyHistoryRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        familyRecycler.setLayoutManager(linearLayoutManager);
        familyLists = new ArrayList<FamilyList>();

        /*medicationLists.add(new MedicationList("1.", "Norvac", "Amlodipine", "30"));
        medicationLists.add(new MedicationList("2.", "Gabica", "Pregablin", "30"));
        medicationLists.add(new MedicationList("3.", "ESSO 40mg", "Esomeperazol", "30"));*/

        FamilyAdapter adapter = new FamilyAdapter(familyLists, CallBackForm2Activity.this);
        familyRecycler.setAdapter(adapter);
    }

    public void openAddMed(View view) {
        layoutAddNewMed.setVisibility(View.VISIBLE);
    }

    public void closeAddNewMedButton(View view) {

        layoutAddNewMed.setVisibility(View.GONE);


    }

    public void addMedication(View view) {
        String drugName = drugNameEdit.getText().toString();
        String drugGeneric = drugGenericEdit.getText().toString();
        String drugDuration = drugDurationEdit.getText().toString();

        if (
                drugName != null && !drugName.equals("")
                        && drugGeneric != null && !drugGeneric.equals("")
                        && drugDuration != null && !drugDuration.equals("")
        ) {

            if (medicationLists.size() > 0) {
                int size = medicationLists.size();
                size++;
                Log.d("CallBackForm",size + "."+" "+drugName+" "+drugGeneric+" "+drugDuration);
                medicationLists.add(new MedicationList(size + ".", drugName, drugGeneric, drugDuration));
            } else {
                medicationLists.add(new MedicationList("1.", drugName, drugGeneric, drugDuration));
                Log.d("CallBackForm","1."+" "+drugName+" "+drugGeneric+" "+drugDuration);

            }

            //medicationLists.notify();
            MedicationAdapter adapter = new MedicationAdapter(medicationLists, CallBackForm2Activity.this);
            medicationRecycler.setAdapter(adapter);

            GeneralUtils.hideSoftKeyboard(CallBackForm2Activity.this, drugDurationEdit);

            drugNameEdit.setText("");
            drugGenericEdit.setText("");
            drugDurationEdit.setText("");
            layoutAddNewMed.setVisibility(View.GONE);

            //GeneralUtils.hideSoftKeyboard(CallBackForm2Activity.this, drugDurationEdit);
            GeneralUtils.alertDialogBoxSimple(CallBackForm2Activity.this, "Info", "Medical History Added");


        } else {
            GeneralUtils.alertDialogBoxSimple(CallBackForm2Activity.this, "Alert", "Please fill all fields correctly");

        }
    }

    public void openAddFamilyHistory(View view) {
        layoutAddNewFamily.setVisibility(View.VISIBLE);

    }

    public void closeAddNewFamilyButton(View view) {

        layoutAddNewFamily.setVisibility(View.GONE);

    }

    public void addMedicalConditionName(View view) {


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(CallBackForm2Activity.this, "medical_conditions.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(CallBackForm2Activity.this, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(CallBackForm2Activity.this, list, view);


        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                medConditionEdit.setText(item.getTitle().toString());

               /* if (item.getTitle().equals("Edit Account")) {
                    Intent intent = new Intent(PatientProfileActivity.this, EditProfileActivity.class);
                    intent.putExtra("first_name", name);
                    intent.putExtra("last_name", last_name);
                    intent.putExtra("date", date_of_birth);
                    intent.putExtra("email", email);
                    intent.putExtra("phone", phone_number);
                    intent.putExtra("address", office_address);
                    startActivity(intent);

                }
                if (item.getTitle().equals("Change Profile")) {
                    Intent intent = new Intent(PatientProfileActivity.this, UploadProfileActivity.class);
                    intent.putExtra("image", user_image);
                    startActivity(intent);

                }
                if (item.getTitle().equals("Change Password")) {
                    Intent intent = new Intent(PatientProfileActivity.this, ChangePasswordActivity.class);
                    startActivity(intent);

                }*/

                return true;
            }
        });

        menu.show(); //showing popup menu
    }


    public void addRelation(View view) {

        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(CallBackForm2Activity.this, "relations.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(CallBackForm2Activity.this, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(CallBackForm2Activity.this, list, view);


        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                relationEdit.setText(item.getTitle().toString());

               /* if (item.getTitle().equals("Edit Account")) {
                    Intent intent = new Intent(PatientProfileActivity.this, EditProfileActivity.class);
                    intent.putExtra("first_name", name);
                    intent.putExtra("last_name", last_name);
                    intent.putExtra("date", date_of_birth);
                    intent.putExtra("email", email);
                    intent.putExtra("phone", phone_number);
                    intent.putExtra("address", office_address);
                    startActivity(intent);

                }
                if (item.getTitle().equals("Change Profile")) {
                    Intent intent = new Intent(PatientProfileActivity.this, UploadProfileActivity.class);
                    intent.putExtra("image", user_image);
                    startActivity(intent);

                }
                if (item.getTitle().equals("Change Password")) {
                    Intent intent = new Intent(PatientProfileActivity.this, ChangePasswordActivity.class);
                    startActivity(intent);

                }*/

                return true;
            }
        });

        menu.show(); //showing popup menu

    }

    public void addFamilyHistory(View view) {

        String medCondition = medConditionEdit.getText().toString();
        String specifyCondition = specifyConditionEdit.getText().toString();
        String relation = relationEdit.getText().toString();
        String ageDiag = ageDiagnosedEdit.getText().toString();

        if (
                medCondition != null && !medCondition.equals("")
                        && specifyCondition != null && !specifyCondition.equals("")
                        && relation != null && !relation.equals("")
                        && ageDiag != null && !ageDiag.equals("")
        ) {

            if (familyLists.size() > 0) {
                int size = familyLists.size();
                size++;
                familyLists.add(new FamilyList(size + ".", medCondition, specifyCondition, relation, ageDiag));
            } else {
                familyLists.add(new FamilyList("1.", medCondition, specifyCondition, relation, ageDiag));

            }

            //medicationLists.notify();
            FamilyAdapter adapter = new FamilyAdapter(familyLists, CallBackForm2Activity.this);
            familyRecycler.setAdapter(adapter);

            GeneralUtils.hideSoftKeyboard(CallBackForm2Activity.this, ageDiagnosedEdit);

            medConditionEdit.setText("");
            specifyConditionEdit.setText("");
            relationEdit.setText("");
            ageDiagnosedEdit.setText("");
            layoutAddNewFamily.setVisibility(View.GONE);

            GeneralUtils.alertDialogBoxSimple(CallBackForm2Activity.this, "Info", "Family History Added");


        } else {
            GeneralUtils.alertDialogBoxSimple(CallBackForm2Activity.this, "Alert", "Please fill all fields correctly");

        }

    }

    public void CloseForm(View view) {
        finish();
    }

    public void moveToThirdForm(View view) {
        startActivity(new Intent(CallBackForm2Activity.this, CallBackForm3Activity.class));
    }

    public void selectMaritalStatus(View view) {
        GeneralUtils.selectMaritalStatus(CallBackForm2Activity.this, view);

    }

    public void selectFirstSecondCousin(View view) {
        GeneralUtils.selectFirstSecondCousinStatus(CallBackForm2Activity.this, view);

    }

    public void selectSpouseRelation(View view) {
        GeneralUtils.selectSpousRelationStatus(CallBackForm2Activity.this, view);

    }

    public void selectEmployment(View view) {
        GeneralUtils.selectEmploymentStatus(CallBackForm2Activity.this, view);

    }
}