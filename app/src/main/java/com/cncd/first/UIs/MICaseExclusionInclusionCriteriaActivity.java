package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cncd.first.Network.ApiPostRequest;
import com.cncd.first.Network.BaseUrl;
import com.cncd.first.R;
import com.cncd.first.Utils.GeneralUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MICaseExclusionInclusionCriteriaActivity extends AppCompatActivity {

    LinearLayout layoutMIExclusion, layoutMIInclusion;

    ArrayList<String> participantDetails = new ArrayList<>();

    TextView firstAcuteMIEdit, stElevationEdit, troponinPositiveEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micase_exclusion_inclusion_criteria);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        loadUI();
        loadParticipantData();
    }

    private void loadParticipantData() {
        Intent intent = getIntent();
        participantDetails = intent.getStringArrayListExtra("participantData");
        Toast.makeText(MICaseExclusionInclusionCriteriaActivity.this, "" + participantDetails.get(0).toString(), Toast.LENGTH_SHORT).show();
    }

    private void loadUI() {
        layoutMIExclusion = findViewById(R.id.layoutMIExclusion);
        layoutMIInclusion = findViewById(R.id.layoutMIInclusion);

        firstAcuteMIEdit = findViewById(R.id.firstAcuteMIEdit);
        stElevationEdit = findViewById(R.id.stElevationEdit);
        troponinPositiveEdit = findViewById(R.id.troponinPositiveEdit);

    }

    public void CloseForm(View view) {
        finish();
    }

    public void mIExclusionYes(View view) {
        GeneralUtils.alertDialogBoxSimpleCloseActivity(MICaseExclusionInclusionCriteriaActivity.this, "Info", "This case can not be registered");
    }

    public void mIExclusionNo(View view) {
        layoutMIExclusion.setVisibility(View.GONE);
        layoutMIInclusion.setVisibility(View.VISIBLE);
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);
        layoutMIInclusion.startAnimation(slide_up);
    }

    public void ContinueClick(View view) {

        String firstMI = firstAcuteMIEdit.getText().toString();
        String stElevation = stElevationEdit.getText().toString();
        String troponinPositive = troponinPositiveEdit.getText().toString();

        if (firstMI.equals("Yes") || stElevation.equals("Yes") || troponinPositive.equals("Yes")) {

            //callDiseaseInclusionAPI();
            Intent intent = new Intent(MICaseExclusionInclusionCriteriaActivity.this, BaselineQuestionnaireRecruitmentActivity.class);
            intent.putStringArrayListExtra("participantData", participantDetails);
            startActivity(intent);
            finish();
        }else {
            GeneralUtils.alertDialogBoxSimple(MICaseExclusionInclusionCriteriaActivity.this, "Info","At least one inclusion criteria should be Yes to proceed");
        }


    }


    private void callDiseaseInclusionAPI() {



        /*
        "{
        {

"study_id":"ABC123",
"disease_inclusion_reason":
       {
        "Q1": "NO",
        "Q2": "NO",
        "Q3": "Yes",
        "Q4":"NO"
        }

}
*/
        JSONObject orderJsonObject = new JSONObject();
        try {
            //   orderJsonObject.put("token", new SessionManager(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this).getToken());
            orderJsonObject.put("study_id",participantDetails.get(6) );

            JSONObject questionObjects = new JSONObject();
            questionObjects.put("Q1", firstAcuteMIEdit.getText().toString().equals("No")?"No":"Yes");
            questionObjects.put("Q2", stElevationEdit.getText().toString().equals("No")?"No":"Yes");
            questionObjects.put("Q3", troponinPositiveEdit.getText().toString().equals("No")?"No":"Yes");
            questionObjects.put("Q4", firstAcuteMIEdit.getText().toString().equals("No")?"No":"Yes");

            orderJsonObject.put("disease_inclusion_reason", questionObjects);

            ///////

        } catch (JSONException e) {
            e.printStackTrace();
        }

        final String requestBody = orderJsonObject.toString();

        new ApiPostRequest(
                MICaseExclusionInclusionCriteriaActivity.this,
                new BaseUrl().getBaseUrl() + "api/Participantinclusion",
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
                                JSONObject jsonData = jsonObject.getJSONObject("data");
                                //String jsonToken = jsonData.getString("token");

                                //study_id = jsonData.getString("study_id");
                                //Log.d("response", study_id);


                            } else {

                                final AlertDialog.Builder aDialog = new AlertDialog.Builder(MICaseExclusionInclusionCriteriaActivity.this, R.style.DialogTheme)
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
                            Toast.makeText(MICaseExclusionInclusionCriteriaActivity.this, "Json Error.", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );


    }


    public void selectYesNoNot(View view) {
        GeneralUtils.selectYesNoNotAnswered(MICaseExclusionInclusionCriteriaActivity.this, view);

    }
}