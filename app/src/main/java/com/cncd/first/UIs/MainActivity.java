package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.cncd.first.Dialogs.AdFormTypeDialog;
import com.cncd.first.Network.SessionManager;
import com.cncd.first.R;
import com.cncd.first.Utils.GeneralUtils;

import java.util.HashMap;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        if (GeneralUtils.getLanguage(MainActivity.this).equals("ur"))
            GeneralUtils.changeIntoUrdu(MainActivity.this);
        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        getUserInfo();

    }

    private void getUserInfo() {
        sessionManager = new SessionManager(MainActivity.this);


        HashMap<String, String> user = sessionManager.getUserDetail();
        String name = user.get(sessionManager.NAME);

        TextView Name;
        Name = findViewById(R.id.userNameTextView);
        Name.setText(name);
       // Log.d("DoctorMainActivity",user_id);
    }

    public void adForm(View view) {
        AdFormTypeDialog formTypeDialog = new AdFormTypeDialog();
        formTypeDialog.showDialog(MainActivity.this);
    }
}