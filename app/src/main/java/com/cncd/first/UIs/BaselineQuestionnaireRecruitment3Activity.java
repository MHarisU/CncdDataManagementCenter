package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.cncd.first.R;
import com.cncd.first.Utils.GeneralUtils;
import com.cncd.first.Utils.JsonArrayToList;
import com.cncd.first.Utils.JsonListToJsonArray;
import com.cncd.first.Utils.LoadListToMenu;

import java.util.List;

public class BaselineQuestionnaireRecruitment3Activity extends AppCompatActivity {

    TextView sheeshUsedText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (GeneralUtils.getLanguage(BaselineQuestionnaireRecruitment3Activity.this).equals("ur"))
            GeneralUtils.changeIntoUrdu(BaselineQuestionnaireRecruitment3Activity.this);
        setContentView(R.layout.activity_baseline_questionnaire_recruitment3);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        loadUI();
    }


    private void loadUI() {
        sheeshUsedText = findViewById(R.id.sheeshUsedText);
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

                sheeshUsedText.setText(item.getTitle().toString());

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

        Intent intent = new Intent(this, BaselineQuestionnaireRecruitment4Activity.class);
        startActivityForResult(intent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == 1) {
            this.setResult(1);
            this.finish();
        }
    }

}