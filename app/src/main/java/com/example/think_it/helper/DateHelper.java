package com.example.think_it.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    public static String getDate(){
        Long tsLong = System.currentTimeMillis();
        DateFormat df = new SimpleDateFormat("MMM d, yyyy");
        return df.format(new java.util.Date());
    }
}
