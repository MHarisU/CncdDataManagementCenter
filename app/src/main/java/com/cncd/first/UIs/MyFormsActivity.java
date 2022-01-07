package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import com.cncd.first.R;

public class MyFormsActivity extends AppCompatActivity {

    LinearLayout loading_layout, all_forms_layout, pending_forms_layout, completed_forms_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_forms);


        LoadUI();

    }

    private void LoadUI() {
        loading_layout = findViewById(R.id.loading_layout);
        all_forms_layout = findViewById(R.id.all_forms_layout);
        pending_forms_layout = findViewById(R.id.pending_forms_layout);
        completed_forms_layout = findViewById(R.id.completed_forms_layout);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loading_layout.setVisibility(View.GONE);
                all_forms_layout.setVisibility(View.VISIBLE);
            }
        },1500);
    }

    public void CloseForm(View view) {
        finish();
    }

    public void allFormButtonClick(View view) {

        pending_forms_layout.setVisibility(View.GONE);
        completed_forms_layout.setVisibility(View.GONE);
        all_forms_layout.setVisibility(View.VISIBLE);

    }


    public void pendingFormButtonClick(View view) {

        completed_forms_layout.setVisibility(View.GONE);
        all_forms_layout.setVisibility(View.GONE);
        pending_forms_layout.setVisibility(View.VISIBLE);

    }

    public void completedFormButtonClick(View view) {

        all_forms_layout.setVisibility(View.GONE);
        pending_forms_layout.setVisibility(View.GONE);
        completed_forms_layout.setVisibility(View.VISIBLE);

    }

}