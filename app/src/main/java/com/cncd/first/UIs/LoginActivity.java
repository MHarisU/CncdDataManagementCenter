package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cncd.first.Network.BaseUrl;
import com.cncd.first.Network.SessionManager;
import com.cncd.first.R;
import com.cncd.first.Utils.GeneralUtils;
import com.google.android.material.button.MaterialButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class LoginActivity extends AppCompatActivity {

    MaterialButton loginButton;
    ProgressBar progressBarLogin;
    EditText editTextEmail, editTextPassword;


    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (GeneralUtils.getLanguage(LoginActivity.this).equals("ur"))
            GeneralUtils.changeIntoUrdu(LoginActivity.this);

        setContentView(R.layout.activity_login);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        InitUI();
        //   Login("harish@cncd.org", "123");


    }

    private void InitUI() {
        loginButton = findViewById(R.id.loginButton);
        progressBarLogin = findViewById(R.id.progressBarLogin);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

    public void signIn(View view) {
      /*  finish();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));*/


        progressBarLogin.setVisibility(View.VISIBLE);
        loginButton.setVisibility(View.GONE);

        final String email = editTextEmail.getText().toString();
        final String password = editTextPassword.getText().toString();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (email != null && !email.equals("") && password != null && !password.equals("")) {

                    //Login(email, password);
                    if (email.equals("danish@cncd.org") && password.equals("12345678"))
                        LoginDummy(email, password);
                    //Login("harish@cncd.org", "123");


                } else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this, R.style.DialogTheme)
                            .setTitle("Info!")
                            .setMessage("Please Enter Email and Password")
                            .setCancelable(false)
                            .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    loginButton.setVisibility(View.VISIBLE);
                                    progressBarLogin.setVisibility(View.GONE);

                                }
                            });
                    //      dialog.show().getWindow().setBackgroundDrawableResource(R.drawable.backgroud_alertbox_round);
                    dialog.show();
                    progressBarLogin.setVisibility(View.GONE);
                    loginButton.setVisibility(View.VISIBLE);
                }
            }
        }, 100);

    }

    private void LoginDummy(String email, String password) {
        //Toast.makeText(LoginActivity.this, "This is dummy login", Toast.LENGTH_SHORT).show();

        String id = "1";
        String name = "Danish Saleheen";
        //String email = "dummy@gmail.com";
        String contact = "03473647030";
        String image = "";
        String role = "1";


        sessionManager = new SessionManager(LoginActivity.this);
        sessionManager.createSession(id, name, email, password, role, contact, "jsonToken");


        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();

        //  Toast.makeText(LoginActivity.this, name+"\n"+id, Toast.LENGTH_SHORT).show();

        loginButton.setVisibility(View.VISIBLE);
        progressBarLogin.setVisibility(View.GONE);
    }


    private void Login(final String email, final String password) {

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("email", email);
            jsonBody.put("password", password);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String requestBody = jsonBody.toString();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, new BaseUrl().getBaseUrl() + "api/login",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("api_response", response);

                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response);
                        } catch (JSONException jsonException) {
                            jsonException.printStackTrace();
                        }

                        try {
                            //JSONObject jsonObject = jsonObject.getJSONObject("Response");
                            String successResponse = jsonObject.getString("success");

                            if (successResponse.equals("true")) {
                                // JSONArray jsonDataArray = jsonObject.getJSONArray("data");
                                JSONObject jsonData = jsonObject.getJSONObject("data");
                                String jsonToken = jsonData.getString("token");

                                String id = jsonData.getString("id").trim();
                                String name = jsonData.getString("name").trim();
                                String email = jsonData.getString("email").trim();
                                String contact = jsonData.getString("contact").trim();
                                String image = jsonData.getString("dp").trim();
                                String role = jsonData.getString("role").trim();


                                sessionManager = new SessionManager(LoginActivity.this);
                                sessionManager.createSession(id, name, email, password, role, contact, jsonToken);

                                /*
                                String android_id = Settings.Secure.getString(getContentResolver(),
                                        Settings.Secure.ANDROID_ID);

                                rootNode = FirebaseDatabase.getInstance();
                                reference = rootNode.getReference("users");

                                FirebaseUserModel userModel = new FirebaseUserModel(id, name + " " + last_name, email, android_id);
                                reference.child(id).setValue(userModel);
                                Log.d("firebase_info", id + " " + name + " " + last_name + " " + email + " " + android_id);

                                   Toast.makeText(LoginActivity.this, id + "\n" + first_name + "\n" + last_name + "\n" + email + "\n" + user_type + "\n" + phone, Toast.LENGTH_LONG).show();

                                if (role.equals("doctor")) {
                                    Intent intent = new Intent(getApplicationContext(), DoctorMainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else if (role.equals("patient")) {

                                    Intent intent = new Intent(getApplicationContext(), PatientMainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                */
                                //  Toast.makeText(LoginActivity.this, id + "\n" + name + "\n" +  email + "\n" + role + "\n" + contact + "\n" + jsonToken, Toast.LENGTH_LONG).show();

                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                finish();

                                //  Toast.makeText(LoginActivity.this, name+"\n"+id, Toast.LENGTH_SHORT).show();

                                loginButton.setVisibility(View.VISIBLE);
                                progressBarLogin.setVisibility(View.GONE);

                            } else if (successResponse.equals("false")) {
                                loginButton.setVisibility(View.VISIBLE);
                                progressBarLogin.setVisibility(View.GONE);
                                AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this, R.style.DialogTheme)
                                        .setTitle("Info!")
                                        .setMessage("Invalid Email and Password")
                                        .setCancelable(false)
                                        .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                                loginButton.setVisibility(View.VISIBLE);
                                                progressBarLogin.setVisibility(View.GONE);

                                            }
                                        });
                                //      dialog.show().getWindow().setBackgroundDrawableResource(R.drawable.backgroud_alertbox_round);
                                dialog.show();
                            } else {

                                loginButton.setVisibility(View.VISIBLE);
                                progressBarLogin.setVisibility(View.GONE);
                                AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this, R.style.DialogTheme)
                                        .setTitle("Info!")
                                        .setMessage("Invalid Email and Password")
                                        .setCancelable(false)
                                        .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                                loginButton.setVisibility(View.VISIBLE);
                                                progressBarLogin.setVisibility(View.GONE);

                                            }
                                        });
                                //      dialog.show().getWindow().setBackgroundDrawableResource(R.drawable.backgroud_alertbox_round);
                                dialog.show();


                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                            loginButton.setVisibility(View.VISIBLE);
                            progressBarLogin.setVisibility(View.GONE);
                            AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this, R.style.DialogTheme)
                                    .setTitle("Info!")
                                    .setMessage("Invalid Email and Password")
                                    .setCancelable(false)
                                    .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                            loginButton.setVisibility(View.VISIBLE);
                                            progressBarLogin.setVisibility(View.GONE);

                                        }
                                    });
                            //      dialog.show().getWindow().setBackgroundDrawableResource(R.drawable.backgroud_alertbox_round);
                            dialog.show();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        loginButton.setVisibility(View.VISIBLE);
                        progressBarLogin.setVisibility(View.GONE);
                        AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this, R.style.DialogTheme)
                                .setTitle("Info!")
                                .setMessage("Invalid Email and Password")
                                .setCancelable(false)
                                .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                        loginButton.setVisibility(View.VISIBLE);
                                        progressBarLogin.setVisibility(View.GONE);

                                    }
                                });
                        //      dialog.show().getWindow().setBackgroundDrawableResource(R.drawable.backgroud_alertbox_round);
                        dialog.show();

                    }
                }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return requestBody == null ? null : requestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                    return null;
                }
            }
        };

        stringRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 10000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 0; //retry turn off
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}