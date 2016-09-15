package com.houseofcode.abdulg.login.utils;

import com.houseofcode.abdulg.login.models.CurrentUser;
import com.houseofcode.abdulg.login.ui.adapters.models.UserInfoDataObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abdullah on 14-09-2016.
 */
public class ToolBox {
    public static String getStringNoNull(Object value) {
        if (value != null) {
            return value.toString();
        }
        return "";
    }
}
