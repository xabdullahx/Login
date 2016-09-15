package com.houseofcode.abdulg.login.ui.activities;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.houseofcode.abdulg.login.api.apicalls.APILogin;
import com.houseofcode.abdulg.login.models.CurrentUser;
import com.houseofcode.abdulg.login.models.json.DateAdapter;
import com.houseofcode.abdulg.login.R;
import com.houseofcode.abdulg.login.ui.constants.Constants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LoginScreen extends AppCompatActivity {
    private EditText et_Username, et_Password;
    private Button btn_Login;
    private Handler dialogHandler;
    private ProgressDialog progress;
    private Callback callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        initMemberVariables();
    }

    private void showProgressDialog() {
        progress = new ProgressDialog(this);
        progress.setTitle(getString(R.string.loading));
        progress.setMessage(getString(R.string.please_wait));
        progress.setCancelable(false);
        progress.show();
    }

    private void dismissProgressDialog() {
        progress.dismiss();
    }

    private void displayAlertDialog(String title, String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    private void login(String email, String password) {
        APILogin login = new APILogin();
        login.callLoginAPI(email, password, callback);
    }

    private void initMemberVariables() {
        et_Username = (EditText) findViewById(R.id.et_username);

        et_Password = (EditText) findViewById(R.id.et_password);

        btn_Login = (Button) findViewById(R.id.btn_login);
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!et_Username.getText().toString().equals("") && !et_Password.getText().toString().equals("")) {
                    showProgressDialog();
                    login(et_Username.getText().toString(), et_Password.getText().toString());
                } else {
                    displayAlertDialog(getString(R.string.login_error), getString(R.string.missing_fields));
                }

            }
        });

        dialogHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Bundle data = msg.getData();
                String title = data.getString(Constants.LOGINSCREEN_DIALOGHANDLER_TITLE);
                String message = data.getString(Constants.LOGINSCREEN_DIALOGHANDLER_TEXT);
                displayAlertDialog(title, message);
            }
        };

        callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                dismissProgressDialog();
                displayAlertDialog(getString(R.string.login_failed), getString(R.string.cant_login));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                dismissProgressDialog();
                if (response.code() == 200) {
                    String returnjson = response.body().string();
                    Moshi moshi = new Moshi.Builder().add(new DateAdapter()).build();
                    JsonAdapter<CurrentUser> jsonAdapter1 = moshi.adapter(CurrentUser.class);
                    CurrentUser currentUser = jsonAdapter1.fromJson(returnjson);
                    if (currentUser != null && currentUser.user != null && currentUser.user.getSuccess()) {
                        Intent intent = new Intent(getApplicationContext(), LoggedIn.class);
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(Constants.LOGGEDIN_LOGINSCREEN_USER, currentUser);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    } else {
                        displayAlertDialog(getString(R.string.login_failed), getString(R.string.unknown_error));
                    }
                } else {
                    displayAlertDialog(getString(R.string.login_failed), getString(R.string.wrong_login));
                }
            }

            private void displayAlertDialog(String title, String text) {

                Bundle bundle = new Bundle();
                bundle.putString(Constants.LOGINSCREEN_DIALOGHANDLER_TITLE, title);
                bundle.putString(Constants.LOGINSCREEN_DIALOGHANDLER_TEXT, text);

                Message message = dialogHandler.obtainMessage();
                message.setData(bundle);
                message.sendToTarget();
            }
        };
    }
}
