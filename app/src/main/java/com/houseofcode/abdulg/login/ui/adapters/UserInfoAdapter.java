package com.houseofcode.abdulg.login.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.houseofcode.abdulg.login.R;
import com.houseofcode.abdulg.login.ui.adapters.models.UserInfoDataObject;
import com.houseofcode.abdulg.login.ui.adapters.models.UserInfoViewHolder;

import java.util.List;

/**
 * Created by Abdullah on 14-09-2016.
 */
public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoViewHolder> {
    List<UserInfoDataObject> userInfos;
    int onedpi = -1;

    public UserInfoAdapter(List<UserInfoDataObject> userInfos, int onedpi) {
        this.userInfos = userInfos;
        this.onedpi = onedpi;
    }

    @Override
    public UserInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_userinfo_cardview, parent, false);
        UserInfoViewHolder uivh = new UserInfoViewHolder(v);
        return uivh;
    }

    @Override
    public void onBindViewHolder(final UserInfoViewHolder holder, int position) {
        holder.setTitle(userInfos.get(position).getTitle());
        holder.setText(userInfos.get(position).getText());
        holder.getCardView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onedpi <= 0) {
                    //Hvis vi ikke har fat i den rigtige dpi, så lad vær med at gøre noget ved klik.
                    return;
                }
                int currentHeight = holder.getCardView().getLayoutParams().height;
                int wrap_content = LinearLayout.LayoutParams.WRAP_CONTENT;
                int original_height = onedpi * 100;
                ViewGroup.LayoutParams layoutParams = holder.getCardView().getLayoutParams();
                boolean doesTextFit = holder.getText().getPaint().measureText(holder.getText().getText().toString()) < ((holder.getCardView().getWidth() - (onedpi * 24)) * 2);
                if (!doesTextFit) {
                    if (currentHeight != wrap_content) {
                        layoutParams.height = wrap_content;
                    } else {
                        layoutParams.height = original_height;
                    }
                    holder.getCardView().setLayoutParams(layoutParams);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return userInfos.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
