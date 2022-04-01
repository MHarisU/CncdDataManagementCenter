package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.cncd.first.Models.BaseParticipant.ParticipantDataList;
import com.cncd.first.Network.ApiPostRequest;
import com.cncd.first.Network.BaseUrl;
import com.cncd.first.R;
import com.cncd.first.Utils.GeneralUtils;
import com.cncd.first.Utils.JsonArrayToList;
import com.cncd.first.Utils.JsonListToJsonArray;
import com.cncd.first.Utils.LoadListToMenu;
import com.cncd.first.Utils.TextViewTextChangeListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaselineQuestionnaireRecruitment3Activity extends AppCompatActivity implements TextViewTextChangeListener {

    TextView sheeshUsedText, tobaccoUsageButtonView, alcoholEverUsed;
    ParticipantDataList participantDataList;
    LinearLayout allTobaccoCheckLayout, cigarettesLayout, huqaLayout, sheeshaLayout, paanLayout, gutkaLayout, supariLayout, naswarLayout, gulLayout, naasLayout;

    CardView notesLayout;
    EditText notesEdit;
    Boolean notesOpenCheck = false;


    CheckBox cigarettesCheck, beediesCheck, huqaCheck, sheeshaCheck, naswarCheck, paanCheck, gutkaCheck, supariCheck, gulCheck, naasCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (GeneralUtils.getLanguage(BaselineQuestionnaireRecruitment3Activity.this).equals("ur"))
            GeneralUtils.changeIntoUrdu(BaselineQuestionnaireRecruitment3Activity.this);
        setContentView(R.layout.activity_baseline_questionnaire_recruitment3);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        loadUI();

        loadParticipantData();

    }

    // ArrayList<String> participantDetails = new ArrayList<>();

    private void loadParticipantData() {
        Intent intent = getIntent();
        participantDataList = (ParticipantDataList) getIntent().getSerializableExtra("participantDataList");

        // participantDetails = intent.getStringArrayListExtra("participantData");
        //Toast.makeText(BaselineQuestionnaireRecruitmentActivity.this, ""+participantDetails.get(0).toString(), Toast.LENGTH_SHORT).show();
    }

    private void loadUI() {
        sheeshUsedText = findViewById(R.id.sheeshUsedText);
        alcoholEverUsed = findViewById(R.id.alcoholEverUsed);


        notesLayout = findViewById(R.id.notesLayout);
        notesEdit = findViewById(R.id.notesEdit);

        tobaccoUsageButtonView = findViewById(R.id.tobaccoUsageButtonView);
        allTobaccoCheckLayout = findViewById(R.id.allTobaccoCheckLayout);


        cigarettesLayout = findViewById(R.id.cigarettesLayout);
        huqaLayout = findViewById(R.id.huqaLayout);
        sheeshaLayout = findViewById(R.id.sheeshaLayout);
        paanLayout = findViewById(R.id.paanLayout);
        gutkaLayout = findViewById(R.id.gutkaLayout);
        supariLayout = findViewById(R.id.supariLayout);
        naswarLayout = findViewById(R.id.naswarLayout);
        gulLayout = findViewById(R.id.gulLayout);
        naasLayout = findViewById(R.id.naasLayout);

        cigarettesCheck = findViewById(R.id.cigarettesCheck);
        cigarettesCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cigarettesLayout.setVisibility(View.VISIBLE);
                } else {
                    cigarettesLayout.setVisibility(View.GONE);
                }
            }
        });
        beediesCheck = findViewById(R.id.beediesCheck);
        beediesCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cigarettesLayout.setVisibility(View.VISIBLE);
                } else {
                    cigarettesLayout.setVisibility(View.GONE);
                }
            }
        });
        huqaCheck = findViewById(R.id.huqaCheck);
        huqaCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    huqaLayout.setVisibility(View.VISIBLE);
                } else {
                    huqaLayout.setVisibility(View.GONE);
                }
            }
        });
        sheeshaCheck = findViewById(R.id.sheeshaCheck);
        sheeshaCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sheeshaLayout.setVisibility(View.VISIBLE);
                } else {
                    sheeshaLayout.setVisibility(View.GONE);
                }
            }
        });
        naswarCheck = findViewById(R.id.naswarCheck);
        naswarCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    naswarLayout.setVisibility(View.VISIBLE);
                } else {
                    naswarLayout.setVisibility(View.GONE);
                }
            }
        });
        paanCheck = findViewById(R.id.paanCheck);
        paanCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    paanLayout.setVisibility(View.VISIBLE);
                } else {
                    paanLayout.setVisibility(View.GONE);
                }
            }
        });
        gutkaCheck = findViewById(R.id.gutkaCheck);
        gutkaCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    gutkaLayout.setVisibility(View.VISIBLE);
                } else {
                    gutkaLayout.setVisibility(View.GONE);
                }
            }
        });
        supariCheck = findViewById(R.id.supariCheck);
        supariCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    supariLayout.setVisibility(View.VISIBLE);
                } else {
                    supariLayout.setVisibility(View.GONE);
                }
            }
        });
        gulCheck = findViewById(R.id.gulCheck);
        gulCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    gulLayout.setVisibility(View.VISIBLE);
                } else {
                    gulLayout.setVisibility(View.GONE);
                }
            }
        });
        naasCheck = findViewById(R.id.naasCheck);
        naasCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    naasLayout.setVisibility(View.VISIBLE);
                } else {
                    naasLayout.setVisibility(View.GONE);
                }
            }
        });


    }

    public void CloseForm(View view) {
        finish();
    }


    public void selectHowOftenUsed(View view) {


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(BaselineQuestionnaireRecruitment3Activity.this, "how_often_used.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(BaselineQuestionnaireRecruitment3Activity.this, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(BaselineQuestionnaireRecruitment3Activity.this, list, view);


        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                alcoholEverUsed.setText(item.getTitle().toString());

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

    public void selectUsageTobacco(View view) {
        GeneralUtils.selectUsageTobacco(BaselineQuestionnaireRecruitment3Activity.this, view);

    }

    public void selectExercise(View view) {
        GeneralUtils.selectExercise(BaselineQuestionnaireRecruitment3Activity.this, view);

    }


    public void selectLeisureTime(View view) {
        GeneralUtils.selectLeisureTime(BaselineQuestionnaireRecruitment3Activity.this, view);

    }


    public void selectDailyCommuting(View view) {
        GeneralUtils.selectDailyCommuting(BaselineQuestionnaireRecruitment3Activity.this, view);

    }


    public void selectAtWorkOptions(View view) {
        GeneralUtils.selectAtWork(BaselineQuestionnaireRecruitment3Activity.this, view);

    }

    public void selectYesNoNot(View view) {
        GeneralUtils.selectYesNoNotAnswered(BaselineQuestionnaireRecruitment3Activity.this, view);
    }

    public void selectFilterNonFilter(View view) {
        GeneralUtils.selectFilteredNonFiltered(BaselineQuestionnaireRecruitment3Activity.this, view);

    }

    public void selectTambakoNonTambako(View view) {
        GeneralUtils.selectTambakoNonTambako(BaselineQuestionnaireRecruitment3Activity.this, view);
    }

    public void selectTypeOfNaswar(View view) {
        GeneralUtils.selectTypeOfNaswar(BaselineQuestionnaireRecruitment3Activity.this, view);

    }

    public void selectExposedToOtherSmoke(View view) {
        GeneralUtils.selectExposedToOtherSmoke(BaselineQuestionnaireRecruitment3Activity.this, view);
    }

    public void moveToFourthForm(View view) {
        //startActivity(new Intent(CallBackForm3Activity.this, CallBackForm4Activity.class));
        //startActivity(new Intent(CallBackFormActivity.this, CallBackForm2Activity.class));

        ArrayList<TobaccoList> tobaccoLists = new ArrayList<>();

        tobaccoLists = getTobaccoData();

        if (tobaccoLists.size() > 0) {

            for (TobaccoList tobaccoList : tobaccoLists) {
                //addTobaccoAPI(tobaccoList);

            }
        }

        if (alcoholEverUsed.getText().toString().equals("Not Answered") || alcoholEverUsed.getText().toString().equals("never")) {
        } else {
            //addAlcoholAPI();
        }

        Intent intent = new Intent(BaselineQuestionnaireRecruitment3Activity.this, BaselineQuestionnaireRecruitment4Activity.class);
        intent.putExtra("participantDataList", participantDataList);
        //  intent.putStringArrayListExtra("participantData", participantDetails);
        startActivityForResult(intent, 1);

    }

    private void addAlcoholAPI() {
        /*
{

   "study_id":"ABC123",
   "ever_had_alcohol":"1",
   "how_often_used":"Regular",
   "age_at_start":"1",
   "age_at_quit":"5"

}
*/

        EditText alcoholStart = findViewById(R.id.alcoholStart);
        EditText alcoholQuit = findViewById(R.id.alcoholQuit);


        JSONObject orderJsonObject = new JSONObject();
        try {
            //   orderJsonObject.put("token", new SessionManager(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this).getToken());
            //orderJsonObject.put("study_id", participantDataList.getStudy_id());
            orderJsonObject.put("study_id", "kl123");
            orderJsonObject.put("ever_had_alcohol", "1");
            orderJsonObject.put("how_often_used", alcoholEverUsed.getText().toString());
            orderJsonObject.put("age_at_start", alcoholStart.getText().toString());
            orderJsonObject.put("age_at_quit", alcoholQuit.getText().toString());


        } catch (JSONException e) {
            e.printStackTrace();
        }

        final String requestBody = orderJsonObject.toString();
        Log.d("requestBody", requestBody);

        new ApiPostRequest(
                BaselineQuestionnaireRecruitment3Activity.this,
                new BaseUrl().getBaseUrl() + "api/Participantalcoholconsumtion",
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
                                if (message.equals("Alcohol History Added Successfully."))
                                    Toast.makeText(BaselineQuestionnaireRecruitment3Activity.this, "Alcohol added Online", Toast.LENGTH_SHORT).show();

                                JSONObject jsonData = jsonObject.getJSONObject("data");
                                //String jsonToken = jsonData.getString("token");

                                //study_id = jsonData.getString("study_id");
                                //Log.d("response", study_id);


                            } else {

                                final AlertDialog.Builder aDialog = new AlertDialog.Builder(BaselineQuestionnaireRecruitment3Activity.this, R.style.DialogTheme)
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
                            Toast.makeText(BaselineQuestionnaireRecruitment3Activity.this, "Json Error.", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );


    }


    private void addTobaccoAPI(TobaccoList tobaccoLists) {
        /*
{
    "study_id":"ABC123",
    "history_of_tobacco":"Biri",
    "tobacco_products":{
"start_age": "22",
"end_age": "none",
"how_many_per_day": "20",
"tambako_type": "tambako"
}
}
*/

        JSONObject orderJsonObject = new JSONObject();
        try {
            //   orderJsonObject.put("token", new SessionManager(RecruitmentGeneralExclusionAndSpecificDiseaseActivity.this).getToken());
            //orderJsonObject.put("study_id", participantDataList.getStudy_id());
            orderJsonObject.put("study_id", "kl123");
            orderJsonObject.put("history_of_tobacco", tobaccoLists.getProductName());

            JSONObject productDataObject = new JSONObject();
            ArrayList<String> productNameData = tobaccoLists.getProductDataNameList();
            ArrayList<String> productData = tobaccoLists.getProductDataList();
            for (int i = 0; i < productNameData.size(); i++) {
                productDataObject.put(productNameData.get(i), productData.get(i));
            }
            orderJsonObject.put("tobacco_products", productDataObject);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        final String requestBody = orderJsonObject.toString();
        Log.d("requestBody", requestBody);

        new ApiPostRequest(
                BaselineQuestionnaireRecruitment3Activity.this,
                new BaseUrl().getBaseUrl() + "api/Participanttobaccohistory",
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
                                if (message.equals("Tobacco History Added Successfully."))
                                    Toast.makeText(BaselineQuestionnaireRecruitment3Activity.this, "Tobacco added Online", Toast.LENGTH_SHORT).show();

                                JSONObject jsonData = jsonObject.getJSONObject("data");
                                //String jsonToken = jsonData.getString("token");

                                //study_id = jsonData.getString("study_id");
                                //Log.d("response", study_id);


                            } else {

                                final AlertDialog.Builder aDialog = new AlertDialog.Builder(BaselineQuestionnaireRecruitment3Activity.this, R.style.DialogTheme)
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
                            Toast.makeText(BaselineQuestionnaireRecruitment3Activity.this, "Json Error.", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );


    }


    private ArrayList<TobaccoList> getTobaccoData() {

        ArrayList<TobaccoList> tobaccoLists = new ArrayList<>();

        if (cigarettesCheck.isChecked()) {
            EditText cigarettesHowMany = findViewById(R.id.cigarettesHowMany);
            EditText cigarettesBrand = findViewById(R.id.cigarettesBrand);
            TextView cigarettesType = findViewById(R.id.cigarettesType);
            EditText cigarettesStart = findViewById(R.id.cigarettesStart);
            EditText cigarettesQuit = findViewById(R.id.cigarettesQuit);
            TextView cigarettesMore100 = findViewById(R.id.cigarettesMore100);

            ArrayList<String> dataName = new ArrayList<>();
            dataName.add("how_many_per_day");
            dataName.add("brand");
            dataName.add("type");
            dataName.add("start");
            dataName.add("quit");
            dataName.add("more_then_100");

            ArrayList<String> data = new ArrayList<>();
            data.add(cigarettesHowMany.getText().toString());
            data.add(cigarettesBrand.getText().toString());
            data.add(cigarettesType.getText().toString());
            data.add(cigarettesStart.getText().toString());
            data.add(cigarettesQuit.getText().toString());
            data.add(cigarettesMore100.getText().toString());
            TobaccoList tobaccoList = new TobaccoList("cigarette", dataName, data);
            tobaccoLists.add(tobaccoList);

        }
        if (beediesCheck.isChecked()) {
            if (!cigarettesCheck.isChecked()) {
                EditText cigarettesHowMany = findViewById(R.id.cigarettesHowMany);
                EditText cigarettesBrand = findViewById(R.id.cigarettesBrand);
                TextView cigarettesType = findViewById(R.id.cigarettesType);
                EditText cigarettesStart = findViewById(R.id.cigarettesStart);
                EditText cigarettesQuit = findViewById(R.id.cigarettesQuit);
                TextView cigarettesMore100 = findViewById(R.id.cigarettesMore100);

                ArrayList<String> dataName = new ArrayList<>();
                dataName.add("how_many_per_day");
                dataName.add("brand");
                dataName.add("type");
                dataName.add("start");
                dataName.add("quit");
                dataName.add("more_then_100");

                ArrayList<String> data = new ArrayList<>();
                data.add(cigarettesHowMany.getText().toString());
                data.add(cigarettesBrand.getText().toString());
                data.add(cigarettesType.getText().toString());
                data.add(cigarettesStart.getText().toString());
                data.add(cigarettesQuit.getText().toString());
                data.add(cigarettesMore100.getText().toString());
                TobaccoList tobaccoList = new TobaccoList("beedies", dataName, data);
                tobaccoLists.add(tobaccoList);
            }

        }
        if (huqaCheck.isChecked()) {

            EditText huqaStart = findViewById(R.id.huqaStart);
            EditText huqaQuit = findViewById(R.id.huqaQuit);
            EditText huqaYearsSmoked = findViewById(R.id.huqaYearsSmoked);


            ArrayList<String> dataName = new ArrayList<>();
            dataName.add("start");
            dataName.add("quit");
            dataName.add("how_many_years_smoked");

            ArrayList<String> data = new ArrayList<>();
            data.add(huqaStart.getText().toString());
            data.add(huqaQuit.getText().toString());
            data.add(huqaYearsSmoked.getText().toString());
            TobaccoList tobaccoList = new TobaccoList("huqqa", dataName, data);
            tobaccoLists.add(tobaccoList);

        }
        if (sheeshaCheck.isChecked()) {

            EditText sheeshaStart = findViewById(R.id.sheeshaStart);
            EditText sheeshaQuit = findViewById(R.id.sheeshaQuit);
            TextView sheeshUsedText = findViewById(R.id.sheeshUsedText);


            ArrayList<String> dataName = new ArrayList<>();
            dataName.add("start");
            dataName.add("quit");
            dataName.add("how_many_years_smoked");

            ArrayList<String> data = new ArrayList<>();
            data.add(sheeshaStart.getText().toString());
            data.add(sheeshaQuit.getText().toString());
            data.add(sheeshUsedText.getText().toString());
            TobaccoList tobaccoList = new TobaccoList("sheesha", dataName, data);
            tobaccoLists.add(tobaccoList);

        }
        if (paanCheck.isChecked()) {

            EditText paanStart = findViewById(R.id.paanStart);
            EditText paanEnd = findViewById(R.id.paanEnd);
            EditText paanHowMany = findViewById(R.id.paanHowMany);
            TextView paanType = findViewById(R.id.paanType);


            ArrayList<String> dataName = new ArrayList<>();
            dataName.add("start");
            dataName.add("quit");
            dataName.add("how_many_per_day");
            dataName.add("type");

            ArrayList<String> data = new ArrayList<>();
            data.add(paanStart.getText().toString());
            data.add(paanEnd.getText().toString());
            data.add(paanHowMany.getText().toString());
            data.add(paanType.getText().toString());
            TobaccoList tobaccoList = new TobaccoList("paan", dataName, data);
            tobaccoLists.add(tobaccoList);

        }
        if (gutkaCheck.isChecked()) {

            EditText gutkaStart = findViewById(R.id.gutkaStart);
            EditText gutkaEnd = findViewById(R.id.gutkaEnd);
            EditText gutkaHowMany = findViewById(R.id.gutkaHowMany);
            TextView gutkaType = findViewById(R.id.gutkaType);


            ArrayList<String> dataName = new ArrayList<>();
            dataName.add("start");
            dataName.add("quit");
            dataName.add("how_many_per_day");
            dataName.add("type");

            ArrayList<String> data = new ArrayList<>();
            data.add(gutkaStart.getText().toString());
            data.add(gutkaEnd.getText().toString());
            data.add(gutkaHowMany.getText().toString());
            data.add(gutkaType.getText().toString());
            TobaccoList tobaccoList = new TobaccoList("gutka", dataName, data);
            tobaccoLists.add(tobaccoList);

        }
        if (supariCheck.isChecked()) {

            EditText supariStart = findViewById(R.id.supariStart);
            EditText supariEnd = findViewById(R.id.supariEnd);
            EditText supariHowMany = findViewById(R.id.supariHowMany);
            TextView supariType = findViewById(R.id.supariType);


            ArrayList<String> dataName = new ArrayList<>();
            dataName.add("start");
            dataName.add("quit");
            dataName.add("how_many_per_day");
            dataName.add("type");

            ArrayList<String> data = new ArrayList<>();
            data.add(supariStart.getText().toString());
            data.add(supariEnd.getText().toString());
            data.add(supariHowMany.getText().toString());
            data.add(supariType.getText().toString());
            TobaccoList tobaccoList = new TobaccoList("supari", dataName, data);
            tobaccoLists.add(tobaccoList);

        }
        if (naswarCheck.isChecked()) {

            EditText naswarStart = findViewById(R.id.naswarStart);
            EditText naswarEnd = findViewById(R.id.naswarEnd);
            EditText naswarHowMany = findViewById(R.id.naswarHowMany);
            TextView naswarType = findViewById(R.id.naswarType);

            ArrayList<String> dataName = new ArrayList<>();
            dataName.add("start");
            dataName.add("quit");
            dataName.add("how_many_per_day");
            dataName.add("type");

            ArrayList<String> data = new ArrayList<>();
            data.add(naswarStart.getText().toString());
            data.add(naswarEnd.getText().toString());
            data.add(naswarHowMany.getText().toString());
            data.add(naswarType.getText().toString());
            TobaccoList tobaccoList = new TobaccoList("naswar", dataName, data);
            tobaccoLists.add(tobaccoList);

        }
        if (gulCheck.isChecked()) {

            EditText gulStart = findViewById(R.id.gulStart);
            EditText gulEnd = findViewById(R.id.gulEnd);
            EditText gulPacketsDay = findViewById(R.id.gulPacketsDay);


            ArrayList<String> dataName = new ArrayList<>();
            dataName.add("start");
            dataName.add("quit");
            dataName.add("packets_per_day");


            ArrayList<String> data = new ArrayList<>();
            data.add(gulStart.getText().toString());
            data.add(gulEnd.getText().toString());
            data.add(gulPacketsDay.getText().toString());
            TobaccoList tobaccoList = new TobaccoList("gul", dataName, data);
            tobaccoLists.add(tobaccoList);

        }
        if (naasCheck.isChecked()) {

            EditText naasStart = findViewById(R.id.naasStart);
            EditText naasEnd = findViewById(R.id.naasEnd);
            EditText naasPacketsDay = findViewById(R.id.naasPacketsDay);


            ArrayList<String> dataName = new ArrayList<>();
            dataName.add("start");
            dataName.add("quit");
            dataName.add("packets_per_day");


            ArrayList<String> data = new ArrayList<>();
            data.add(naasStart.getText().toString());
            data.add(naasEnd.getText().toString());
            data.add(naasPacketsDay.getText().toString());
            TobaccoList tobaccoList = new TobaccoList("naas", dataName, data);
            tobaccoLists.add(tobaccoList);

        }

        return tobaccoLists;

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

    @Override
    public void onTextChange(String data) {
        switch (data) {
            case "Ever Used":
            case "Currently Uses":
                allTobaccoCheckLayout.setVisibility(View.VISIBLE);
                break;
            case "Never Used":
                allTobaccoCheckLayout.setVisibility(View.GONE);
                break;
        }
    }

    public class TobaccoList implements Serializable {

        String productName;
        ArrayList<String> productDataNameList;
        ArrayList<String> productDataList;

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public ArrayList<String> getProductDataNameList() {
            return productDataNameList;
        }

        public void setProductDataNameList(ArrayList<String> productDataNameList) {
            this.productDataNameList = productDataNameList;
        }

        public ArrayList<String> getProductDataList() {
            return productDataList;
        }

        public void setProductDataList(ArrayList<String> productDataList) {
            this.productDataList = productDataList;
        }

        public TobaccoList(String productName, ArrayList<String> productDataNameList, ArrayList<String> productDataList) {
            this.productName = productName;
            this.productDataNameList = productDataNameList;
            this.productDataList = productDataList;


        }
    }

}