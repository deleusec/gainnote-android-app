package com.example.gainnote.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Exercice implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    int repetitions;
    int series;

    public Exercice(String name, int repetitions, int series) {
        this.name = name;
        this.repetitions = repetitions;
        this.series = series;
    }

    protected Exercice(Parcel in) {
        id = in.readInt();
        name = in.readString();
        repetitions = in.readInt();
        series = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(repetitions);
        dest.writeInt(series);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Exercice> CREATOR = new Creator<Exercice>() {
        @Override
        public Exercice createFromParcel(Parcel in) {
            return new Exercice(in);
        }

        @Override
        public Exercice[] newArray(int size) {
            return new Exercice[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

}
