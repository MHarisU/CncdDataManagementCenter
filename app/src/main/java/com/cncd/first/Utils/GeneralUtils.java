package com.cncd.first.Utils;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.cncd.first.UIs.CallBackForm3Activity;
import com.cncd.first.UIs.HfCaseExcIncCriteriaActivity;
import com.cncd.first.UIs.MICaseExclusionInclusionCriteriaActivity;
import com.cncd.first.UIs.RecruitmentGeneralExclusionAndSpecificDiseaseActivity;

import java.util.List;
import java.util.Locale;

public class GeneralUtils {

    static String MY_PREFS_NAME = "language";



    public static void hideSoftKeyboard(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (inputMethodManager.isAcceptingText()) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        /*InputMethodManager inputMethodManager =(InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), 0);*/


    }


    public static void alertDialogBoxSimple(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setIcon(android.R.drawable.ic_dialog_info);

        AlertDialog alert1 = builder.create();
        alert1.show();
    }

    public static void alertDialogBoxSimpleCloseActivity(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if(context instanceof RecruitmentGeneralExclusionAndSpecificDiseaseActivity){
                    ((RecruitmentGeneralExclusionAndSpecificDiseaseActivity)context).finish(); }

                if(context instanceof MICaseExclusionInclusionCriteriaActivity){
                    ((MICaseExclusionInclusionCriteriaActivity)context).finish(); }

                if(context instanceof HfCaseExcIncCriteriaActivity){
                    ((HfCaseExcIncCriteriaActivity)context).finish(); }

                if(context instanceof Activity){
                    ((Activity)context).finish(); }
            }
        });
        builder.setIcon(android.R.drawable.ic_dialog_info);

        AlertDialog alert1 = builder.create();
        alert1.show();
    }

    public static void selectYesNoNotAnswered(Context context, View view) {

        TextView textView = (TextView) view;


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(context, "yes_no_not_answered.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(context, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(context, list, view);


        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                textView.setText(item.getTitle().toString());

                return true;
            }
        });

        menu.show(); //showing popup menu

    }


    public static void selectFilteredNonFiltered(Context context, View view) {

        TextView textView = (TextView) view;


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(context, "filter_non_filter.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(context, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(context, list, view);


        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                textView.setText(item.getTitle().toString());

                return true;
            }
        });

        menu.show(); //showing popup menu

    }




    public static void selectMaritalStatus(Context context, View view) {

        TextView textView = (TextView) view;


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(context, "marital_status.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(context, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(context, list, view);


        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                textView.setText(item.getTitle().toString());

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

    public static void selectFirstSecondCousinStatus(Context context, View view) {

        TextView textView = (TextView) view;


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(context, "relation_first_second_cousin.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(context, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(context, list, view);


        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                textView.setText(item.getTitle().toString());

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

    public static void selectSpousRelationStatus(Context context, View view) {

        TextView textView = (TextView) view;


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(context, "relation_spouse.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(context, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(context, list, view);


        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                textView.setText(item.getTitle().toString());

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


    public static void selectRelation(Context context, View view) {

        TextView textView = (TextView) view;


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(context, "relations.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(context, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(context, list, view);


        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                textView.setText(item.getTitle().toString());

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


    public static void selectRelationExtra(Context context, View view) {

        TextView textView = (TextView) view;


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(context, "relations_extra.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(context, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(context, list, view);


        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                textView.setText(item.getTitle().toString());

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




    public static void selectEmploymentStatus(Context context, View view) {

        TextView textView = (TextView) view;


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(context, "employment_status.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(context, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(context, list, view);


        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                textView.setText(item.getTitle().toString());

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


    public static void selectUsageTobacco(Context context, View view) {

        TextView textView = (TextView) view;


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(context, "tobacco_usage.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(context, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(context, list, view);

        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                textView.setText(item.getTitle().toString());

                return true;
            }
        });

        menu.show(); //showing popup menu

    }


    public static void changeIntoUrdu(Context context) {

        String languageToLoad = "ur"; // your language
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getResources().updateConfiguration(config,
                context.getResources().getDisplayMetrics());
    }



    public static void setLanguage(Context context, String lan) {

        SharedPreferences.Editor editor = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("lan", lan);
        editor.apply();
    }

    public static String getLanguage(Context context) {

        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String lan = prefs.getString("lan", "en");//"en" is the default value.
        //int idName = prefs.getInt("idName", 0); //0 is the default value.
        return lan;
    }


    public static void selectTambakoNonTambako(Context context, View view) {

        TextView textView = (TextView) view;


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(context, "tambako_non.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(context, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(context, list, view);

        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                textView.setText(item.getTitle().toString());

                return true;
            }
        });

        menu.show(); //showing popup menu

    }


    public static void selectTypeOfNaswar(Context context, View view) {

        TextView textView = (TextView) view;


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(context, "naswar_type.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(context, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(context, list, view);

        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                textView.setText(item.getTitle().toString());

                return true;
            }
        });

        menu.show(); //showing popup menu

    }

    public static void selectExposedToOtherSmoke(Context context, View view) {

        TextView textView = (TextView) view;


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(context, "exposed_to_smoke.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(context, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(context, list, view);

        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                textView.setText(item.getTitle().toString());

                return true;
            }
        });

        menu.show(); //showing popup menu

    }

    public static void selectStateOfWomenSubject(Context context, View view) {

        TextView textView = (TextView) view;


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(context, "state_of_women_subject.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(context, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(context, list, view);

        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                textView.setText(item.getTitle().toString());

                return true;
            }
        });

        menu.show(); //showing popup menu

    }


    public static void selectWhyDidPeriodsStop(Context context, View view) {

        TextView textView = (TextView) view;


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(context, "why_did_periods_stop.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(context, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(context, list, view);

        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                textView.setText(item.getTitle().toString());

                return true;
            }
        });

        menu.show(); //showing popup menu

    }

    public static void selectBodyType(Context context, View view) {

        TextView textView = (TextView) view;


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(context, "body_type.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(context, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(context, list, view);

        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                textView.setText(item.getTitle().toString());

                return true;
            }
        });

        menu.show(); //showing popup menu

    }



    public static void selectRelationWithSpouse(Context context, View view) {

        TextView textView = (TextView) view;


        String jsonArray = JsonListToJsonArray.loadJSONFromAsset(context, "relation_with_spouse.json");
        Log.d("CallBackActivity", jsonArray);
        List<String> list = JsonArrayToList.createList(context, jsonArray);

        PopupMenu menu = LoadListToMenu.loadMenu(context, list, view);

        //registering popup with OnMenuItemClickListener
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                textView.setText(item.getTitle().toString());

                return true;
            }
        });

        menu.show(); //showing popup menu

    }




}
