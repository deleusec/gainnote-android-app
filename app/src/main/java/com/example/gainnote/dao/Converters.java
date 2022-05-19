package com.example.gainnote.dao;

import androidx.room.TypeConverter;

import com.example.gainnote.model.Exercice;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;

public class Converters {
    @TypeConverter
    public static ArrayList<Integer> toWeight(String value) {
        return new Gson().fromJson(value, new TypeToken<ArrayList<Integer>>() {
        }.getType());
    }

    @TypeConverter
    public static String fromWeight(ArrayList<Integer> value) {
        return value == null ? null : new Gson().toJson(new ArrayList<>(value));
    }

    @TypeConverter
    public static Date toDate(String value) {
        return new Gson().fromJson(value, new TypeToken<Date>() {
        }.getType());
    }

    @TypeConverter
    public static String fromDate(Date value) {
        return value == null ? null : new Gson().toJson(value);
    }

    @TypeConverter
    public static Time toTime(String value) {
        return new Gson().fromJson(value, new TypeToken<Time>() {
        }.getType());
    }

    @TypeConverter
    public static String fromTime(Time value) {
        return value == null ? null : new Gson().toJson(value);
    }

    @TypeConverter
    public static ArrayList<Exercice> toExercice(String value) {
        return new Gson().fromJson(value, new TypeToken<ArrayList<Exercice>>() {
        }.getType());
    }

    @TypeConverter
    public static String fromExercice(ArrayList<Exercice> value) {
        return value == null ? null : new Gson().toJson(new ArrayList<>(value));
    }
}
