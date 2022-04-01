package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.Toast;

import com.cncd.first.Models.BaseParticipant.ParticipantDataList;
import com.cncd.first.Models.DiseaseData.DiseaseList;
import com.cncd.first.Models.FamilyModel.FamilyAdapter;
import com.cncd.first.Models.FamilyModel.FamilyList;
import com.cncd.first.Models.MedicationModel.MedicationAdapter;
import com.cncd.first.Models.MedicationModel.MedicationList;
import com.cncd.first.Network.ApiPostRequest;
import com.cncd.first.Network.BaseUrl;
import com.cncd.first.R;
import com.cncd.first.Utils.GeneralUtils;
import com.cncd.first.Utils.JsonArrayToList;
import com.cncd.first.Utils.JsonListToJsonArray;
import com.cncd.first.Utils.LoadListToMenu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BaselineQuestionnaireRecruitment2Activity extends AppCompatActivity {


    LinearLayout layoutAddNewMed, layoutAddNewFamily;
    ImageView closeAddNewMed, closeAddNewFamily;

    RecyclerView medicationRecycler;
    ArrayList<MedicationList> medicationLists;


    RecyclerView familyRecycler;
    ArrayList<FamilyList> familyLists;

    EditText drugNameEdit, drugGenericEdit, drugDurationEdit;
    EditText specifyConditionEdit, ageDiagnosedEdit;
    TextView medConditionEdit, relationEdit;

    ParticipantDataList participantDataList;


    CardView notesLayout;
    EditText notesEdit;
    Boolean notesOpenCheck = false;


    EditText ethnicityEditView, castEditView, numberOfChildrenEditView, yearsOfEducationEditView, occupationOfSubjectEditView;
    TextView maritalStatusView, fatherMotherCousinView, fatherMotherRelationView, spouseCousinView, spouseRelationView, jobsOfSubjectView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (GeneralUtils.getLanguage(BaselineQuestionnaireRecruitment2Activity.this).equals("ur"))
            GeneralUtils.changeIntoUrdu(BaselineQuestionnaireRecruitment2Activity.this);
        setContentView(R.layout.activity_baseline_questionnaire_recruitment2);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        loadUIs();

        loadMedications();

        loadFamily();

        loadParticipantData();

    }

    // ArrayList<String> participantDetails = new ArrayList<>();

    private void loadParticipantData() {
        Intent intent = getIntent();

        participantDataList = (ParticipantDataList) getIntent().getSerializableExtra("participantDataList");
        // participantDetails = intent.getStringArrayListExtra("participantData");
        //Toast.makeText(BaselineQuestionnaireRecruitment2Activity.this, ""+participantDataList.getName(), Toast.LENGTH_SHORT).show();
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


        notesLayout = findViewById(R.id.notesLayout);
        notesEdit = findViewById(R.id.notesEdit);

        ethnicityEditView = findViewById(R.id.ethnicityEditView);
        castEditView = findViewById(R.id.castEditView);
        numberOfChildrenEditView = findViewById(R.id.numberOfChildrenEditView);
        yearsOfEducationEditView = findViewById(R.id.yearsOfEducationEditView);
        occupationOfSubjectEditView = findViewById(R.id.occupationOfSubjectEditView);
        maritalStatusView = findViewById(R.id.maritalStatusView);
        fatherMotherCousinView = findViewById(R.id.fatherMotherCousinView);
        fatherMotherRelationView = findViewById(R.id.fatherMotherRelationView);
        spouseCousinView = findViewById(R.id.spouseCousinView);
        spouseRelationView = findViewById(R.id.spouseRelationView);
        jobsOfSubjectView = findViewById(R.id.jobsOfSubjectView);


    }

    private void loadMedications() {
        medicationRecycler = findViewById(R.id.medicationRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        medicationRecycler.setLayoutManager(linearLayoutManager);
        medicationLists = new ArrayList<MedicationList>();

        /*medicationLists.add(new MedicationList("1.", "Norvac", "Amlodipine", "30"));
        medicationLists.add(new MedicationList("2.", "Gabica", "Pregablin", "30"));
        medicationLists.add(new MedicationList("3.", "ESSO 40mg", "Esomeperazol", "30"));*/

        MedicationAdapter adapter = new MedicationAdapter(medicationLists, BaselineQuestionnaireRecruitment2Activity.this);
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

        FamilyAdapter adapter = new FamilyAdapter(familyLists, BaselineQuestionnaireRecruitment2Activity.this);
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
                Log.d("CallBackForm", size + "." + " " + drugName + " " + drugGeneric + " " + drugDuration);
                medicationLists.add(new MedicationList(size + ".", drugName, drugGeneric, drugDuration));
            } else {
                medicationLists.add(new MedicationList("1.", drugName, drugGeneric, drugDuration));
                Log.d("CallBackForm", "1." + " " + drugName + " " + drugGeneric + " " + drugDuration);

            }

            //medicationLists.notify();
            MedicationAdapter adapter = new MedicationAdapter(medicationLists, BaselineQuestionnaireRecruitment2Activity.this);
            medicationRecycler.setAdapter(adapter);

            GeneralUtils.hideSoftKeyboard(BaselineQuestionnaireRecruitment2Activity.this, drugDurationEdit);

            drugNameEdit.setText("");
            drugGenericEdit.setText("");
            drugDurationEdit.setText("");
            layoutAddNewMed.setVisibility(View.GONE);

            //GeneralUtils.hideSoftKeyboard(BaselineQuestionnaireRecruitment2Activity.this, drugDurationEdit);
            GeneralUtils.alertDialogBoxSimple(BaselineQuestionnaireRecruitment2Activity.this, "Info", "Medical History Added");
            //addMedicationAPI(drugName, drugGeneric, drugDuration);


        } else {
            GeneralUtils.alertDialogBoxSimple(BaselineQuestionnaireRecruitment2Activity.this, "Alert", "Please fill all fields correctly");

        }
    }

    private void addMedicationAPI(String drugName, String drugGeneric, String drugDuration) {
        /*

{
"study_id": "ABC123",
"drug_name": "Amoxil",
"drug_generic": "AMoxilate",
"duration_month": "22-10-2020"
}
*/
        JSONObject orderJsonObject = new JSONObject();
        try {
            //   orderJsonObject.put("token", new SessionManager(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this).getToken());
            orderJsonObject.put("study_id", participantDataList.getStudy_id());
            orderJsonObject.put("drug_name", drugName);
            orderJsonObject.put("drug_generic", drugGeneric);
            orderJsonObject.put("duration_month", drugDuration);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        final String requestBody = orderJsonObject.toString();
        Log.d("requestBody", requestBody);

        new ApiPostRequest(
                BaselineQuestionnaireRecruitment2Activity.this,
                new BaseUrl().getBaseUrl() + "api/Participantmedication",
                requestBody,
                new ApiPostRequest.AsyncApiResponse() {
                    @Override
                    public void processFinish(String response) {


                        Log.d("response", response);

                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response);
                        } catch (JSONException jsonException) {
                            jsonException.printStackTrace();
                        }

                        try {
                            // JSONObject jsonResponse = jsonObject.getJSONObject("Response");
                            String successResponse = jsonObject.getString("success");

                            if (successResponse.equals("true")) {
                                // JSONArray jsonDataArray = jsonObject.getJSONArray("data");


                                String message = jsonObject.getString("message");
                                if (message.equals("Medication Added Successfully."))
                                    Toast.makeText(BaselineQuestionnaireRecruitment2Activity.this, "Medication added Online", Toast.LENGTH_SHORT).show();

                                JSONObject jsonData = jsonObject.getJSONObject("data");
                                //String jsonToken = jsonData.getString("token");

                                //study_id = jsonData.getString("study_id");
                                //Log.d("response", study_id);


                            } else {

                                final AlertDialog.Builder aDialog = new AlertDialog.Builder(BaselineQuestionnaireRecruitment2Activity.this, R.style.DialogTheme)
                                        .setTitle("")
                                        .setMessage("Invalid request please login or try again later")
                                        .setCancelable(false)
                                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                            }
                                        });
                                aDialog.show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(BaselineQuestionnaireRecruitment2Activity.this, "Json Error.", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );


    }

    private void addFamilyHistoryAPI() {
        /*

"{
""study_id"": ""ABC123"",
""relations"":[
    {
""relationship_to_participant"": ""Brother"",
""disease"": ""Strock"",
""specify_condition"": ""Heart Attack"",
""age"":""56""},
{
""relationship_to_participant"": ""Brother"",
""disease"": ""Strock"",
""specify_condition"": ""Heart Attack"",
""age"":""56""}
]

}
"
*/


        JSONObject orderJsonObject = new JSONObject();
        try {
            //   orderJsonObject.put("token", new SessionManager(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this).getToken());
            orderJsonObject.put("study_id", participantDataList.getStudy_id());

            JSONArray jsonArray = new JSONArray();
            JSONObject relationObject = new JSONObject();
            for (FamilyList familyList : familyLists) {
                relationObject.put("relationship_to_participant", familyList.getRelation_name());
                relationObject.put("disease", familyList.getMedical_condition_name());
                relationObject.put("specify_condition", familyList.getSpecify_condition_name());
                relationObject.put("age", familyList.getAge_diagnosed());
                jsonArray.put(relationObject);

            }

            orderJsonObject.put("relations", jsonArray);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        final String requestBody = orderJsonObject.toString();
        Log.d("requestBody", requestBody);

        new ApiPostRequest(
                BaselineQuestionnaireRecruitment2Activity.this,
                new BaseUrl().getBaseUrl() + "api/Participantfamilyhistory",
                requestBody,
                new ApiPostRequest.AsyncApiResponse() {
                    @Override
                    public void processFinish(String response) {


                        Log.d("response", response);

                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response);
                        } catch (JSONException jsonException) {
                            jsonException.printStackTrace();
                        }

                        try {
                            // JSONObject jsonResponse = jsonObject.getJSONObject("Response");
                            String successResponse = jsonObject.getString("success");

                            if (successResponse.equals("true")) {
                                // JSONArray jsonDataArray = jsonObject.getJSONArray("data");


                                String message = jsonObject.getString("message");
                                if (message.equals("Family History Added Successfully."))
                                    Toast.makeText(BaselineQuestionnaireRecruitment2Activity.this, "Family history added Online", Toast.LENGTH_SHORT).show();

                                JSONObject jsonData = jsonObject.getJSONObject("data");
                                //String jsonToken = jsonData.getString("token");

                                //study_id = jsonData.getString("study_id");
                                //Log.d("response", study_id);


                            } else {

                                final AlertDialog.Builder aDialog = new AlertDialog.Builder(BaselineQuestionnaireRecruitment2Activity.this, R.style.DialogTheme)
                                        .setTitle("")
                                        .setMessage("Invalid request please login or try again later")
                                        .setCancelable(false)
                                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                            }
                                        });
                                aDialog.show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(BaselineQuestionnaireRecruitment2Activity.this, "Json Error.", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );


    }


    private void addDemographicDataAPI() {
        /*
   "study_id":"ABC123",
   "ethnicity":"Islam",
   "cast":"Rangar",
   "marital_status":"1",
   "number_of_children":"5",
   "subjects_father_mother_cousin":"1",
   "father_mother_relation":"1",
   "subject_spouse_cousin":"0",
   "subject_spouse_relation":"0",
   "total_jobs_of _subject":"1",
   "years_of_education":"14",
   "occupation_of_subject":"1"
*/
        //occupationOfSubjectEditView = findViewById(R.id.occupationOfSubjectEditView);
        //maritalStatusView = findViewById(R.id.maritalStatusView);
        fatherMotherCousinView = findViewById(R.id.fatherMotherCousinView);
        fatherMotherRelationView = findViewById(R.id.fatherMotherRelationView);
        spouseCousinView = findViewById(R.id.spouseCousinView);
        spouseRelationView = findViewById(R.id.spouseRelationView);
        jobsOfSubjectView = findViewById(R.id.jobsOfSubjectView);

        String maritalSting = maritalStatusView.getText().toString();
        int maritalInt = 6;
        switch (maritalSting) {
            case "Single":
                maritalInt = 1;
                break;
            case "Married":
                maritalInt = 2;
                break;
            case "Divorced":
                maritalInt = 3;
                break;
            case "Separated":
                maritalInt = 4;
                break;
            case "Widow":
                maritalInt = 5;
                break;
            case "Not Answered":
                maritalInt = 6;
                break;
        }

        JSONObject orderJsonObject = new JSONObject();
        try {
            //   orderJsonObject.put("token", new SessionManager(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this).getToken());
            orderJsonObject.put("study_id", participantDataList.getStudy_id());
            orderJsonObject.put("ethnicity", ethnicityEditView.getText().toString().equals("") ? "" : ethnicityEditView.getText().toString());
            orderJsonObject.put("cast", castEditView.getText().toString().equals("") ? "" : castEditView.getText().toString());
            orderJsonObject.put("marital_status", maritalInt);
            orderJsonObject.put("number_of_children", numberOfChildrenEditView.getText().toString().equals("") ? "0" : numberOfChildrenEditView.getText().toString());
            orderJsonObject.put("subjects_father_mother_cousin", "1");
            orderJsonObject.put("father_mother_relation", "1");
            orderJsonObject.put("subject_spouse_cousin", "1");
            orderJsonObject.put("subject_spouse_relation", "1");
            orderJsonObject.put("total_jobs_of _subject", "1");
            orderJsonObject.put("years_of_education", yearsOfEducationEditView.getText().toString().equals("") ? "0" : yearsOfEducationEditView.getText().toString());
            orderJsonObject.put("occupation_of_subject", "1");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        final String requestBody = orderJsonObject.toString();
        Log.d("requestBody", requestBody);

        new ApiPostRequest(
                BaselineQuestionnaireRecruitment2Activity.this,
                new BaseUrl().getBaseUrl() + "api/Participantdemographicdata",
                requestBody,
                new ApiPostRequest.AsyncApiResponse() {
                    @Override
                    public void processFinish(String response) {


                        Log.d("response", response);

                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response);
                        } catch (JSONException jsonException) {
                            jsonException.printStackTrace();
                        }

                        try {
                            // JSONObject jsonResponse = jsonObject.getJSONObject("Response");
                            String successResponse = jsonObject.getString("success");

                            if (successResponse.equals("true")) {
                                // JSONArray jsonDataArray = jsonObject.getJSONArray("data");


                                String message = jsonObject.getString("message");
                                if (message.equals("Demographic Data Added Successfully."))
                                    Toast.makeText(BaselineQuestionnaireRecruitment2Activity.this, "Demographic added Online", Toast.LENGTH_SHORT).show();

                                JSONObject jsonData = jsonObject.getJSONObject("data");
                                //String jsonToken = jsonData.getString("token");

                                //study_id = jsonData.getString("study_id");
                                //Log.d("response", study_id);


                            } else {

                                final AlertDialog.Builder aDialog = new AlertDialog.Builder(BaselineQuestionnaireRecruitment2Activity.this, R.style.DialogTheme)
                                        .setTitle("")
                                        .setMessage("Invalid request please login or try again later")
                                        .setCancelable(false)
                                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                            }
                                        });
                                aDialog.show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(BaselineQuestionnaireRecruitment2Activity.this, "Json Error.", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );


    }


    public void openAddFamilyHistory(View view) {
        layoutAddNewFamily.setVisibility(View.VISIBLE);

    }

    public void closeAddNewFamilyButton(View view) {

        layoutAddNewFamily.setVisibility(View.GONE);

    }

    public void addMedicalConditionName(View view) {


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(BaselineQuestionnaireRecruitment2Activity.this, "medical_conditions.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(BaselineQuestionnaireRecruitment2Activity.this, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(BaselineQuestionnaireRecruitment2Activity.this, list, view);

        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                medConditionEdit.setText(item.getTitle().toString());


                return true;
            }
        });

        menu.show(); //showing popup menu
    }

    public void addRelation(View view) {

        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(BaselineQuestionnaireRecruitment2Activity.this, "relations.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(BaselineQuestionnaireRecruitment2Activity.this, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(BaselineQuestionnaireRecruitment2Activity.this, list, view);


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
            FamilyAdapter adapter = new FamilyAdapter(familyLists, BaselineQuestionnaireRecruitment2Activity.this);
            familyRecycler.setAdapter(adapter);

            GeneralUtils.hideSoftKeyboard(BaselineQuestionnaireRecruitment2Activity.this, ageDiagnosedEdit);

            medConditionEdit.setText("");
            specifyConditionEdit.setText("");
            relationEdit.setText("");
            ageDiagnosedEdit.setText("");
            layoutAddNewFamily.setVisibility(View.GONE);

            GeneralUtils.alertDialogBoxSimple(BaselineQuestionnaireRecruitment2Activity.this, "Info", "Family History Added");


        } else {
            GeneralUtils.alertDialogBoxSimple(BaselineQuestionnaireRecruitment2Activity.this, "Alert", "Please fill all fields correctly");

        }

    }

    public void CloseForm(View view) {
        finish();
    }


    public void selectFirstSecondCousin(View view) {
        GeneralUtils.selectFirstSecondCousinStatus(BaselineQuestionnaireRecruitment2Activity.this, view);

    }

    public void selectSpouseRelation(View view) {
        GeneralUtils.selectSpousRelationStatus(BaselineQuestionnaireRecruitment2Activity.this, view);

    }

    public void selectEmployment(View view) {
        GeneralUtils.selectEmploymentStatus(BaselineQuestionnaireRecruitment2Activity.this, view);

    }

    public void selectMaritalStatus(View view) {
        GeneralUtils.selectMaritalStatus(BaselineQuestionnaireRecruitment2Activity.this, view);

    }

    public void moveToThirdForm(View view) {
        //startActivity(new Intent(CallBackForm2Activity.this, CallBackForm3Activity.class));
        //startActivity(new Intent(CallBackFormActivity.this, CallBackForm2Activity.class));
        if (familyLists.size() > 0) {
            //addFamilyHistoryAPI();
        }

        //addDemographicDataAPI();

        Intent intent = new Intent(BaselineQuestionnaireRecruitment2Activity.this, BaselineQuestionnaireRecruitment3Activity.class);
        intent.putExtra("participantDataList", participantDataList);
        startActivityForResult(intent, 1);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 1) {
            this.setResult(1);
            this.finish();
        }
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