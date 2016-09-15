package com.houseofcode.abdulg.login.api.apicalls;

import com.houseofcode.abdulg.login.api.constants.Constants;
import com.houseofcode.abdulg.login.models.LoginRequest;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Abdullah on 14-09-2016.
 */
public class APILogin {

    public void callLoginAPI(String username, String password, Callback callback) {
        LoginRequest login = new LoginRequest();
        login.setEmail(username);
        login.setPassword(password);
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<LoginRequest> jsonAdapter = moshi.adapter(LoginRequest.class);
        String loginJson = jsonAdapter.toJson(login);

        try {
            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), loginJson);
            Request request = new Request.Builder()
                    .url(Constants.login)
                    .post(body)
                    .build();
            Call call = client.newCall(request);

            call.enqueue(callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
