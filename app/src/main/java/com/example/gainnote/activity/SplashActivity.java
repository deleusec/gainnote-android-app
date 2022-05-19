package com.example.gainnote.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.gainnote.R;
import com.example.gainnote.dao.AppDatabase;
import com.example.gainnote.databinding.ActivitySplashBinding;
import com.example.gainnote.model.User;
import com.example.gainnote.utils.ActivityUtils;


@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySplashBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        User user = AppDatabase.getUser(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if( user == null ){
                    ActivityUtils.launchActivity(SplashActivity.this,CurrentDataActivity.class,true);
                } else {
                    ActivityUtils.launchActivity(SplashActivity.this,MainActivity.class,true   );
                }
            }
        },4000);

    }
}