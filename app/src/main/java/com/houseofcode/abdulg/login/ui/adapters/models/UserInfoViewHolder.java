package com.houseofcode.abdulg.login.ui.adapters.models;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.houseofcode.abdulg.login.R;

/**
 * Created by Abdullah on 14-09-2016.
 */
public class UserInfoViewHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private TextView text;
    private CardView cardView;

    public UserInfoViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.tv_userinfotitle);
        text = (TextView) itemView.findViewById(R.id.tv_userinfotext);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public TextView getText() {
        return text;
    }

    public void setText(String text) {
        this.text.setText(text);
    }

    public CardView getCardView() {
        return cardView;
    }

    public void setCardView(CardView cardView) {
        this.cardView = cardView;
    }
}
