package com.cncd.first.Network;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;


import com.cncd.first.UIs.LoginActivity;
import com.cncd.first.UIs.MainActivity;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    private Context context;

    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public static final String NAME = "NAME";
    public static final String USER_TYPE = "USER_TYPE";
    public static final String EMAIL = "EMAIL";
    public static final String PASSWORD = "PASSWORD";
    public static final String ID = "ID";
    public static final String PHONE = "PHONE";
    public static final String TOKEN = "TOKEN";

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createSession(String id, String name, String email, String password, String user_type, String phone, String token) {
        editor.putBoolean(LOGIN, true);
        editor.putString(ID, id);
        editor.putString(NAME, name);
        editor.putString(USER_TYPE, user_type);
        editor.putString(EMAIL, email);
        editor.putString(PASSWORD, password);
        editor.putString(PHONE, phone);
        editor.putString(TOKEN, token);


        editor.apply();

    }

    public boolean isLogin() {
        return sharedPreferences.getBoolean(LOGIN, false);
    }

    public void checkLoginSplash() {
        if (!this.isLogin()) {
            Intent i = new Intent(context, LoginActivity.class);
            context.startActivity(i);
            ((MainActivity) context).finish();
        }
    }

    public void checkLogin() {
        if (!this.isLogin()) {
            Intent i = new Intent(context, LoginActivity.class);
            context.startActivity(i);
            ((MainActivity) context).finish();
        }
    }

    public void checkLogin(Context context) {
        if (!this.isLogin()) {
            Intent i = new Intent(context, LoginActivity.class);
            context.startActivity(i);
            ((MainActivity) context).finish();
        }
    }

    public HashMap<String, String> getUserDetail() {

        HashMap<String, String> user = new HashMap<>();
        user.put(ID, sharedPreferences.getString(ID, null));
        user.put(NAME, sharedPreferences.getString(NAME, null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL, null));
        user.put(PASSWORD, sharedPreferences.getString(PASSWORD, null));
        user.put(USER_TYPE, sharedPreferences.getString(USER_TYPE, null));
        user.put(PHONE, sharedPreferences.getString(PHONE, null));
        user.put(TOKEN, sharedPreferences.getString(TOKEN, null));


        return user;
    }

    public String getToken() {
        return sharedPreferences.getString(TOKEN, null);
    }

    public String getUserType() {
        return sharedPreferences.getString(USER_TYPE, null);
    }

    public String getPassword() {
        return sharedPreferences.getString(PASSWORD, null);
    }

    public void setPassword(String password) {

        editor.putString(PASSWORD, password);

        editor.apply();

    }

    public void setFirstName(String firstName) {

        editor.putString(NAME, firstName);

        editor.apply();

    }



    public void setPhone(String phone) {

        editor.putString(PHONE, phone);

        editor.apply();

    }


    public String getUserId() {
        return sharedPreferences.getString(ID, null);
    }

    public void logout() {
        editor.clear();
        editor.commit();

        Intent i = new Intent(context, LoginActivity.class);
        context.startActivity(i);
        ((MainActivity) context).finish();
    }

    public void logoutPatient() {
        editor.clear();
        editor.commit();

        Intent i = new Intent(context, LoginActivity.class);
        context.startActivity(i);
        ((MainActivity) context).finish();
    }
}
