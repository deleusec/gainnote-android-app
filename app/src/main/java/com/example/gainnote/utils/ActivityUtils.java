package com.example.gainnote.utils;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.gainnote.R;
import com.example.gainnote.fragment.SessionFragment;

public class ActivityUtils {

    public static void launchActivity(AppCompatActivity activity, Class activityClass){
        launchActivity(activity,activityClass,false);
    }

    public static void launchActivity(AppCompatActivity activity, Class activityClass, boolean isFinish){
        launchActivity(activity, new Intent(activity,activityClass),isFinish);
    }

    public static void launchActivity(AppCompatActivity activity, Intent intent){
        launchActivity(activity,intent,true);
    }

    public static void addFragmentToActivity(AppCompatActivity activity, @NonNull Fragment fragment, int frameId) {
        FragmentTransaction transaction;
        transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_to_right, R.anim.slide_to_right);
        transaction.add(frameId, fragment, "tag");
        transaction.addToBackStack(null);
        transaction.commit();
    }


    public static void addFragmentToFragment(Fragment parentFragment, @NonNull Fragment fragment, int frameId) {
        FragmentTransaction transaction;
        transaction = parentFragment.getChildFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(frameId, fragment, "tag");
        transaction.commit();
    }

    public static void launchActivity(AppCompatActivity activity, Intent intent, boolean isFinish){
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_to_right,R.anim.fade_out);
        if(isFinish){
            activity.finish();
        }
    }
}
