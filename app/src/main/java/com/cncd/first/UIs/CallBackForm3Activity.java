package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;

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

public class CallBackForm3Activity extends AppCompatActivity {

    TextView sheeshUsedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (GeneralUtils.getLanguage(CallBackForm3Activity.this).equals("ur"))
            GeneralUtils.changeIntoUrdu(CallBackForm3Activity.this);
        setContentView(R.layout.activity_call_back_form3);
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


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(CallBackForm3Activity.this, "how_often_used.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(CallBackForm3Activity.this, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(CallBackForm3Activity.this, list, view);


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
        GeneralUtils.selectUsageTobacco(CallBackForm3Activity.this, view);

    }

    public void selectYesNoNot(View view) {
        GeneralUtils.selectYesNoNotAnswered(CallBackForm3Activity.this, view);
    }

    public void selectFilterNonFilter(View view) {
        GeneralUtils.selectFilteredNonFiltered(CallBackForm3Activity.this, view);

    }

    public void selectTambakoNonTambako(View view) {
        GeneralUtils.selectTambakoNonTambako(CallBackForm3Activity.this, view);
    }

    public void selectTypeOfNaswar(View view) {
        GeneralUtils.selectTypeOfNaswar(CallBackForm3Activity.this, view);

    }

    public void selectExposedToOtherSmoke(View view) {
        GeneralUtils.selectExposedToOtherSmoke(CallBackForm3Activity.this, view);
    }
}