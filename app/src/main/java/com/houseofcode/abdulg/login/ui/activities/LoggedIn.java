package com.houseofcode.abdulg.login.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.houseofcode.abdulg.login.ui.adapters.UserInfoAdapter;
import com.houseofcode.abdulg.login.models.CurrentUser;
import com.houseofcode.abdulg.login.R;
import com.houseofcode.abdulg.login.ui.adapters.models.UserInfoDataObject;
import com.houseofcode.abdulg.login.ui.constants.Constants;
import com.houseofcode.abdulg.login.utils.Helper;

import java.util.List;

/**
 * Created by Abdullah on 14-09-2016.
 */
public class LoggedIn extends Activity {
    private CurrentUser currentUser;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        initMemberVariables();
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        int onedpi = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics());

        List<UserInfoDataObject> userDatas = Helper.convertCurrentUserToDataObject(currentUser);
        UserInfoAdapter adapter = new UserInfoAdapter(userDatas, onedpi);
        recyclerView.setAdapter(adapter);
    }

    private void initMemberVariables() {
        currentUser = getIntent().getExtras().getParcelable(Constants.LOGGEDIN_LOGINSCREEN_USER);

        TextView tv_UserLoggedIn = (TextView) findViewById(R.id.tv_userloggedin);
        tv_UserLoggedIn.setText(getString(R.string.logged_in_as) + ":\n" + currentUser.user.getName());

        Button btn_logout = (Button) findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.rv);
    }


}
