package com.houseofcode.abdulg.login.models.json;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Abdullah on 13-09-2016.
 */
public class DateAdapter {
    @FromJson
    Date fromJson(String date){
        //2016-03-02T14:33:07.000+01:00
        try{
            String string = date;
            DateFormat format = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss.SSSZ");
            return format.parse(string);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @ToJson
    String toJson(Date date){
        return "";
    }

}
