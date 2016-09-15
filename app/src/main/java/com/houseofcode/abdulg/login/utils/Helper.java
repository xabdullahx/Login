package com.houseofcode.abdulg.login.utils;

import com.houseofcode.abdulg.login.models.CurrentUser;
import com.houseofcode.abdulg.login.ui.adapters.models.UserInfoDataObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abdullah on 15-09-2016.
 */
public class Helper {
    public static List<UserInfoDataObject> convertCurrentUserToDataObject(CurrentUser currentUser) {
        if (currentUser == null)
            return new ArrayList<>();
        if (currentUser.user == null)
            return new ArrayList<>();

        List<UserInfoDataObject> list = new ArrayList<>();
        list.add(new UserInfoDataObject("Success", ToolBox.getStringNoNull(currentUser.user.getSuccess())));
        list.add(new UserInfoDataObject("Id", ToolBox.getStringNoNull(currentUser.user.getId())));
        list.add(new UserInfoDataObject("Authentication Token", ToolBox.getStringNoNull(currentUser.user.getAuthentication_token())));
        list.add(new UserInfoDataObject("Name", ToolBox.getStringNoNull(currentUser.user.getName())));
        list.add(new UserInfoDataObject("Email", ToolBox.getStringNoNull(currentUser.user.getEmail())));
        list.add(new UserInfoDataObject("Member Since", ToolBox.getStringNoNull(currentUser.user.getMember_since())));
        list.add(new UserInfoDataObject("Created At", ToolBox.getStringNoNull(currentUser.user.getCreated_at())));
        list.add(new UserInfoDataObject("Updated At", ToolBox.getStringNoNull(currentUser.user.getUpdated_at())));
        list.add(new UserInfoDataObject("Has Access", ToolBox.getStringNoNull(currentUser.user.getHas_access())));
        list.add(new UserInfoDataObject("Subscription Id", ToolBox.getStringNoNull(currentUser.user.getSubscription().getId())));
        list.add(new UserInfoDataObject("Subscription Expires", ToolBox.getStringNoNull(currentUser.user.getSubscription().getExpires())));
        list.add(new UserInfoDataObject("Subscription Created At", ToolBox.getStringNoNull(currentUser.user.getSubscription().getCreated_at())));
        list.add(new UserInfoDataObject("Subscription Updated At", ToolBox.getStringNoNull(currentUser.user.getSubscription().getUpdated_at())));
        return list;
    }
}
