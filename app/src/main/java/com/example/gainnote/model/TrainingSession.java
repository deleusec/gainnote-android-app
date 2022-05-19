package com.example.gainnote.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Time;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Locale;

@Entity
public class TrainingSession implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    int id;
    Date date;
    Time time;
    ArrayList<Exercice> exercices;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public TrainingSession(ArrayList<Exercice> exercices) {
        this.time = new Time(System.currentTimeMillis());
        this.date = new Date(System.currentTimeMillis());
        this.exercices = exercices;
    }

    protected TrainingSession(Parcel in) {
        id = in.readInt();
        exercices = in.createTypedArrayList(Exercice.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeTypedList(exercices);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TrainingSession> CREATOR = new Creator<TrainingSession>() {
        @Override
        public TrainingSession createFromParcel(Parcel in) {
            return new TrainingSession(in);
        }

        @Override
        public TrainingSession[] newArray(int size) {
            return new TrainingSession[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Exercice> getExercices() {
        return exercices;
    }

    public void setExercices(ArrayList<Exercice> exercices) {
        this.exercices = exercices;
    }

}
