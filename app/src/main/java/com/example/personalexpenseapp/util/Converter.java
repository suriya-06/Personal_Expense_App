package com.example.personalexpenseapp.util;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.util.Date;

public class Converter {

    @TypeConverter
    public static Date fromTimeStamp(Long value){
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long toDate(Date date){
        return date == null ? null : date.getTime();
    }
}
