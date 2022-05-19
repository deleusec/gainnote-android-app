package com.example.gainnote.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.gainnote.R;
import com.example.gainnote.dao.AppDatabase;
import com.example.gainnote.databinding.ActivityMainBinding;
import com.example.gainnote.databinding.ActivitySettingsBinding;
import com.example.gainnote.utils.ActivityUtils;

import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {

    ActivitySettingsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_settings);

        binding.settingsDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase.getDatabase(SettingsActivity.this).appDao().deleteAllData();
                AppDatabase.getDatabase(SettingsActivity.this).appDao().deleteAllSessions();
                ActivityUtils.launchActivity(SettingsActivity.this, CurrentDataActivity.class);
            }
        });

        binding.settingsDeleteSessions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase.getDatabase(SettingsActivity.this).appDao().deleteAllSessions();
                ActivityUtils.launchActivity(SettingsActivity.this, MainActivity.class);
            }
        });
    }
}