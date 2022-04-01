package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.cncd.first.Dialogs.DiabeteMellitusDialog;
import com.cncd.first.Dialogs.DyslipidemiaDialog;
import com.cncd.first.Dialogs.HypertensionDialog;
import com.cncd.first.Dialogs.LiverDiseaseDialog;
import com.cncd.first.Dialogs.MyocardialInfarctionDialog;
import com.cncd.first.Dialogs.SeizuresDialog;
import com.cncd.first.Dialogs.ThyroidDiseaseDialog;
import com.cncd.first.Dialogs.ValvularHeartDiseaseDialog;
import com.cncd.first.Models.BaseParticipant.ParticipantDataList;
import com.cncd.first.Models.DiseaseData.DiseaseList;
import com.cncd.first.Network.ApiPostRequest;
import com.cncd.first.Network.BaseUrl;
import com.cncd.first.R;
import com.cncd.first.Utils.DatePicker;
import com.cncd.first.Utils.GeneralUtils;
import com.cncd.first.Utils.ReturnValueFromDialog;
import com.cncd.first.Utils.TimePicker;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BaselineQuestionnaireRecruitmentActivity extends AppCompatActivity implements ReturnValueFromDialog {

    ArrayList<String> participantDetails = new ArrayList<>();

    TextView interviewDateText, dateLastMeal, dateBloodSample, lastMealTime, bloodsampleTime, studyIDView;
    EditText interviewInitialsEdit, refTargetEdit, participantNameEdit, participantFatherHusbandEdit, participantAddressEdit, participantTelephoneEdit, participantWhatsappEdit;
    EditText participantAgeEdit, participantCnicEdit;
    RadioButton radioMale, radioFemale;


    ParticipantDataList participantDataList;
    String study_id;


    TextView diabetesTextView, thyroidTextView, valvularTextView, dyslipidemiaTextView, hypertensionTextView, liverTextView, miTextView, seizureTextView;

    //Note Views
    CardView notesLayout;
    EditText notesEdit;
    Boolean notesOpenCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (GeneralUtils.getLanguage(BaselineQuestionnaireRecruitmentActivity.this).equals("ur"))
            GeneralUtils.changeIntoUrdu(BaselineQuestionnaireRecruitmentActivity.this);
        setContentView(R.layout.activity_baseline_questionnaire_recruitment);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        loadUI();

        loadCurrentDate();
        loadParticipantData();
    }

    private void loadCurrentDate() {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);
        if (GeneralUtils.getLanguage(BaselineQuestionnaireRecruitmentActivity.this).equals("ur")) {
            interviewDateText.setText(formattedDate + "انٹرویو کی تاریخ: ");

        } else {
            interviewDateText.setText("1. Date of Interview: " + formattedDate);

        }
    }

    private void loadUI() {
        studyIDView = findViewById(R.id.studyIDView);
        interviewDateText = findViewById(R.id.interviewDateText);
        interviewInitialsEdit = findViewById(R.id.interviewInitialsEdit);
        //refTargetEdit = findViewById(R.id.refTargetEdit);

        participantNameEdit = findViewById(R.id.participantNameEdit);
        participantFatherHusbandEdit = findViewById(R.id.participantFatherHusbandEdit);
        participantAddressEdit = findViewById(R.id.participantAddressEdit);
        participantTelephoneEdit = findViewById(R.id.participantTelephoneEdit);
        participantWhatsappEdit = findViewById(R.id.participantWhatsappEdit);

        participantAgeEdit = findViewById(R.id.participantAgeEdit);
        participantCnicEdit = findViewById(R.id.participantCnicEdit);

        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);

        dateLastMeal = findViewById(R.id.dateLastMeal);
        dateBloodSample = findViewById(R.id.dateBloodSample);
        lastMealTime = findViewById(R.id.lastMealTime);
        bloodsampleTime = findViewById(R.id.bloodsampleTime);

        notesLayout = findViewById(R.id.notesLayout);
        notesEdit = findViewById(R.id.notesEdit);


        diabetesTextView = findViewById(R.id.diabetesTextView);
        thyroidTextView = findViewById(R.id.thyroidTextView);
        valvularTextView = findViewById(R.id.valvularTextView);
        dyslipidemiaTextView = findViewById(R.id.dyslipidemiaTextView);
        hypertensionTextView = findViewById(R.id.hypertensionTextView);
        liverTextView = findViewById(R.id.liverTextView);
        miTextView = findViewById(R.id.miTextView);
        seizureTextView = findViewById(R.id.seizureTextView);

    }

    private void loadParticipantData() {
        Intent intent = getIntent();
        try {

            participantDetails = intent.getStringArrayListExtra("participantData");
            study_id = participantDetails.get(6);
            studyIDView.setText(study_id);

            participantNameEdit.setText(participantDetails.get(0).toString());
            participantAgeEdit.setText(participantDetails.get(1));
            if (participantDetails.get(2).equals("Male")) {
                radioMale.setChecked(true);
                radioFemale.setChecked(false);
            } else if (participantDetails.get(2).equals("Female")) {
                radioMale.setChecked(false);
                radioFemale.setChecked(true);
            }
            participantAddressEdit.setText(participantDetails.get(3));
            participantTelephoneEdit.setText(participantDetails.get(4));
            participantWhatsappEdit.setText(participantDetails.get(5));
            //Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, ""+participantDetails.get(0).toString(), Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void interviewDate(View view) {
        TextView interviewDateText = findViewById(R.id.interviewDateText);
        DatePicker datePicker = new DatePicker(BaselineQuestionnaireRecruitmentActivity.this, interviewDateText);
        String selected_date = datePicker.pickDate();
        // interviewDateText.setText("1. Date of Interview: "+selected_date);
    }

    public void lastMealTime(View view) {
        TimePicker timePicker = new TimePicker(BaselineQuestionnaireRecruitmentActivity.this, lastMealTime);
        timePicker.pickDate();
    }

    public void lastMealDate(View view) {

        DatePicker datePicker = new DatePicker(BaselineQuestionnaireRecruitmentActivity.this, dateLastMeal);
        String selected_date = datePicker.pickDate();

    }

    public void bloodSampleDate(View view) {
        DatePicker datePicker = new DatePicker(BaselineQuestionnaireRecruitmentActivity.this, dateBloodSample);
        String selected_date = datePicker.pickDate();

    }

    public void bloodSampleTime(View view) {
        TimePicker timePicker = new TimePicker(BaselineQuestionnaireRecruitmentActivity.this, bloodsampleTime);
        timePicker.pickDate();
    }

    public void moveToSecondForm(View view) {
        //startActivity(new Intent(CallBackFormActivity.this, CallBackForm2Activity.class));

        try {


            participantDataList = new ParticipantDataList(study_id, participantDetails.get(0).toString(), participantFatherHusbandEdit.getText().toString(), participantDetails.get(3),
                    participantDetails.get(2), participantDetails.get(1), participantCnicEdit.getText().toString(), participantDetails.get(4), participantDetails.get(5),
                    dateLastMeal.getText().toString(), lastMealTime.getText().toString(), dateBloodSample.getText().toString(), bloodsampleTime.getText().toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(BaselineQuestionnaireRecruitmentActivity.this, BaselineQuestionnaireRecruitment2Activity.class);
        intent.putStringArrayListExtra("participantData", participantDetails);
        intent.putExtra("participantDataList", participantDataList);
        startActivityForResult(intent, 1);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 1) {
            this.finish();
        }
    }

    public void selectYesNoNot(View view) {
        GeneralUtils.selectYesNoNotAnswered(BaselineQuestionnaireRecruitmentActivity.this, view);
    }

    public void CloseForm(View view) {
        finish();
    }

    public void selectTypeOfMI(View view) {
        GeneralUtils.selectTypeOfMIView(BaselineQuestionnaireRecruitmentActivity.this, view);

    }

    public void DiabetesSelect(View view) {
        // Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "API Error.", Toast.LENGTH_SHORT).show();
        DiabeteMellitusDialog dialog = new DiabeteMellitusDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
    }

    public void ThyroidDiseaseSelect(View view) {
        // Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "API Error.", Toast.LENGTH_SHORT).show();
        ThyroidDiseaseDialog dialog = new ThyroidDiseaseDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
    }

    public void ValvularHeartDiseaseSelect(View view) {

        //Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "API Error.", Toast.LENGTH_SHORT).show();
        ValvularHeartDiseaseDialog dialog = new ValvularHeartDiseaseDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
    }


    public void dyslipidemiaSelect(View view) {

        //Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "API Error.", Toast.LENGTH_SHORT).show();

        DyslipidemiaDialog dialog = new DyslipidemiaDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
    }

    public void hypertensionSelect(View view) {

        //Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "API Error.", Toast.LENGTH_SHORT).show();


        HypertensionDialog dialog = new HypertensionDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
    }

    public void liverDiseaseSelect(View view) {

        //Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "API Error.", Toast.LENGTH_SHORT).show();


        LiverDiseaseDialog dialog = new LiverDiseaseDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
    }

    public void miDiseaseSelect(View view) {

        // Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "API Error.", Toast.LENGTH_SHORT).show();


        MyocardialInfarctionDialog dialog = new MyocardialInfarctionDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
    }

    public void seizuresSelect(View view) {

        //Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "API Error.", Toast.LENGTH_SHORT).show();


        SeizuresDialog dialog = new SeizuresDialog();
        dialog.showDialog(BaselineQuestionnaireRecruitmentActivity.this);
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

//    TextView diabetesTextView, thyroidTextView, valvularTextView, dyslipidemiaTextView, hypertensionTextView, liverTextView, miTextView, seizureTextView;

    @Override
    public void onReturnDiabetesData(String data, ArrayList<DiseaseList> diseaseLists) {
        diabetesTextView.setText(data);
        Log.d("diseaseData", diseaseLists.toString());
       // callDiseaseAPI("diabetes", diseaseLists);
    }


    @Override
    public void onReturnThyroidData(String data, ArrayList<DiseaseList> diseaseLists) {
        thyroidTextView.setText(data);
        Log.d("diseaseData", diseaseLists.toString());
        //callDiseaseAPI("thyroid", diseaseLists);
    }

    @Override
    public void onReturnValvularData(String data, ArrayList<DiseaseList> diseaseLists) {
        valvularTextView.setText(data);
        Log.d("diseaseData", diseaseLists.toString());
        //callDiseaseAPI("valvular", diseaseLists);
    }

    @Override
    public void onReturnDyslipidemiaData(String data, ArrayList<DiseaseList> diseaseLists) {
        dyslipidemiaTextView.setText(data);
        Log.d("diseaseData", diseaseLists.toString());
        //callDiseaseAPI("dyslipidemia", diseaseLists);

    }

    @Override
    public void onReturnHypertensionData(String data, ArrayList<DiseaseList> diseaseLists) {
        hypertensionTextView.setText(data);
        Log.d("diseaseData", diseaseLists.toString());
        //callDiseaseAPI("hypertension", diseaseLists);

    }

    @Override
    public void onReturnLiverData(String data, ArrayList<DiseaseList> diseaseLists) {
        liverTextView.setText(data);
        Log.d("diseaseData", diseaseLists.toString());
        //callDiseaseAPI("liver", diseaseLists);

    }

    @Override
    public void onReturnMIData(String data, ArrayList<DiseaseList> diseaseLists) {
        miTextView.setText(data);
        Log.d("diseaseData", diseaseLists.toString());
        //callDiseaseAPI("mi", diseaseLists);

    }

    @Override
    public void onReturnSeizureData(String data, ArrayList<DiseaseList> diseaseLists) {
        seizureTextView.setText(data);
        Log.d("diseaseData", diseaseLists.toString());
        //callDiseaseAPI("seizures", diseaseLists);

    }

    public void saveNotes(View view) {
        //saveNotesAPI();
    }

    private void saveNotesAPI() {



        /*
       "{
    ""study_id"":""ABC123"",
    ""notes"":""Test notes.""
        }"

*/
        JSONObject orderJsonObject = new JSONObject();
        try {
            //   orderJsonObject.put("token", new SessionManager(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this).getToken());
            orderJsonObject.put("study_id", participantDetails.get(6));


            orderJsonObject.put("notes", notesEdit.getText().toString());

            ///////

        } catch (JSONException e) {
            e.printStackTrace();
        }

        final String requestBody = orderJsonObject.toString();

        new ApiPostRequest(
                BaselineQuestionnaireRecruitmentActivity.this,
                new BaseUrl().getBaseUrl() + "api/Participantformnotes",
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
                                /*
                                {
    "success": true,
    "data": {
        "notes": "Test notes."
    },
    "message": "Notes Added Successfully"
}
                                */

                                String message = jsonObject.getString("message");
                                if (message.equals("Notes Added Successfully"))
                                    Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "Notes Saved", Toast.LENGTH_SHORT).show();

                                JSONObject jsonData = jsonObject.getJSONObject("data");
                                //String jsonToken = jsonData.getString("token");

                                //study_id = jsonData.getString("study_id");
                                //Log.d("response", study_id);


                            } else {

                                final AlertDialog.Builder aDialog = new AlertDialog.Builder(BaselineQuestionnaireRecruitmentActivity.this, R.style.DialogTheme)
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
                            Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "Json Error.", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );


    }

    private void callDiseaseAPI_(String disease, ArrayList<DiseaseList> diseaseLists) {



        /*
{

"study_id":"ABC123",
"disease_name":"diabetes",
"disease_data":
{
"type": "1",
"complication": "diabetic retinopathy",
"record_seen":"true",
"insulin":"true",
"age":"55"
}

}

*/
        JSONObject orderJsonObject = new JSONObject();
        try {
            //   orderJsonObject.put("token", new SessionManager(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this).getToken());
            orderJsonObject.put("study_id", participantDetails.get(6));
            orderJsonObject.put("disease_name", disease);

            Log.d("requestBody", diseaseLists.size()+"");

            JSONObject diseasesObject = new JSONObject();
            for (int i = 0; i < diseaseLists.size(); i++) {
                DiseaseList diseaseList = diseaseLists.get(i);
                diseasesObject.put(diseaseList.getData_name(), diseaseList.getData_value());
                Log.d("items", i+" "+diseaseList.getData_name());
            }

            orderJsonObject.put("disease_data", diseasesObject);

            ///////

        } catch (JSONException e) {
            e.printStackTrace();
        }

        final String requestBody = orderJsonObject.toString();
        Log.d("requestBody", requestBody);

        new ApiPostRequest(
                BaselineQuestionnaireRecruitmentActivity.this,
                new BaseUrl().getBaseUrl() + "api/Participantdisease",
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
                                /*
{
    "success": true,
    "data": {
        "disease_result": "Disease Added Successfully."
    },
    "message": "Disease Added Successfully."
}
                                */

                                String message = jsonObject.getString("message");
                                if (message.equals("Disease Added Successfully."))
                                    Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "Disease Saved", Toast.LENGTH_SHORT).show();

                                JSONObject jsonData = jsonObject.getJSONObject("data");
                                //String jsonToken = jsonData.getString("token");

                                //study_id = jsonData.getString("study_id");
                                //Log.d("response", study_id);


                            } else {

                                final AlertDialog.Builder aDialog = new AlertDialog.Builder(BaselineQuestionnaireRecruitmentActivity.this, R.style.DialogTheme)
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
                            Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, "Json Error.", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );


    }

}