package com.example.gainnote.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.gainnote.R;
import com.example.gainnote.dao.AppDatabase;
import com.example.gainnote.databinding.ActivityMainBinding;
import com.example.gainnote.fragment.HomeFragment;
import com.example.gainnote.model.User;
import com.example.gainnote.utils.ActivityUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    public User user = AppDatabase.getUser(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
/*
        User user = AppDatabase.getUser(this);
        ArrayList<Integer> weight = user.getWeight();
        weight.add(15);
        user.setWeight(weight);
*/

        String firstname = user.getFirstname();
        ActivityUtils.addFragmentToActivity(MainActivity.this, new HomeFragment(), R.id.main_fragment_container);

        binding.mainProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtils.launchActivity(MainActivity.this, SettingsActivity.class);
            }
        });

    }
}