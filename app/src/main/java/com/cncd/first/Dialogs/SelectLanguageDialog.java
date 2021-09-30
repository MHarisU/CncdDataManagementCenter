package com.cncd.first.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cncd.first.R;
import com.cncd.first.UIs.CallBackFormActivity;
import com.cncd.first.UIs.LoginActivity;
import com.cncd.first.UIs.PGRFormActivity;
import com.cncd.first.UIs.SplashActivity;
import com.cncd.first.Utils.GeneralUtils;

public class SelectLanguageDialog {


    Dialog dialog;
    Context context;

    public SelectLanguageDialog() {
    }

    public void showDialog(final Context activity) {
        context = activity;
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.select_language_dialog_layout);


        ImageView closeButton = (ImageView) dialog.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        LinearLayout english = (LinearLayout) dialog.findViewById(R.id.english);
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GeneralUtils.setLanguage(context, "en");
                context.startActivity(new Intent(context, LoginActivity.class));
                //context.finish();
                ((SplashActivity)(context)).finish();
                dialog.dismiss();

            }
        });

        LinearLayout urdu = (LinearLayout) dialog.findViewById(R.id.urdu);
        urdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GeneralUtils.setLanguage(context, "ur");
                context.startActivity(new Intent(context, LoginActivity.class));
                //context.finish();
                ((SplashActivity)(context)).finish();
                dialog.dismiss();

            }
        });


        dialog.show();
        //Window window = dialog.getWindow();
        //window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

    }


}