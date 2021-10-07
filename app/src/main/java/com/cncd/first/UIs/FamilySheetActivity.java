package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.cncd.first.R;
import com.cncd.first.Utils.DatePicker;
import com.cncd.first.Utils.GeneralUtils;

public class FamilySheetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (GeneralUtils.getLanguage(FamilySheetActivity.this).equals("ur"))
            GeneralUtils.changeIntoUrdu(FamilySheetActivity.this);
        setContentView(R.layout.activity_family_sheet);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

    }

    public void CloseForm(View view) {
        finish();
    }

    public void openAddSubject(View view) {
    }

    public void dateSelect(View view) {
        TextView dateText = findViewById(R.id.dateText);
        DatePicker datePicker = new DatePicker(FamilySheetActivity.this, dateText);
        String selected_date = datePicker.pickDate();
    }

    public void closeAddNewSubjectLayout(View view) {
    }

    public void addSubject(View view) {
    }

    public void submitFamilySheet(View view) {
    }
}