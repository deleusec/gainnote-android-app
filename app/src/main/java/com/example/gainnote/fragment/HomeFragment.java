package com.example.gainnote.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gainnote.R;
import com.example.gainnote.activity.MainActivity;
import com.example.gainnote.activity.adapter.HomeAdapter;
import com.example.gainnote.dao.AppDatabase;
import com.example.gainnote.databinding.FragmentHomeBinding;
import com.example.gainnote.model.TrainingSession;
import com.example.gainnote.model.User;
import com.example.gainnote.utils.ActivityUtils;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        User user = AppDatabase.getUser(getContext());

        binding.welcomeUser.setText(getString(R.string.welcome_user, user.getFirstname() +" "+ user.getName()));
        binding.homeWeight.setText(getString(R.string.dynamic_weight, user.getLastWeight().toString()));

        binding.homeAddWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtils.addFragmentToActivity((AppCompatActivity) getActivity(), new WeightFragment(), R.id.main_fragment_container);
            }
        });

        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtils.addFragmentToActivity((AppCompatActivity) getActivity(), new SessionFragment(), R.id.main_fragment_container);
            }
        });

        binding.sessionsList.setLayoutManager(new LinearLayoutManager(getContext()));
        setupRecyclerView();

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    public void setupRecyclerView() {
        binding.sessionsList.setAdapter(new HomeAdapter(this, AppDatabase.getDatabase(getContext()).appDao().getAllTrainingSession()) {
            @Override
            public void onContainerClick(TrainingSession trainingSession) {
                SessionVisualizerFragment sessionVisualizerFragment = new SessionVisualizerFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("TRAINING_KEY", trainingSession);
                sessionVisualizerFragment.setArguments(bundle);

                ActivityUtils.addFragmentToActivity((AppCompatActivity) getActivity(), sessionVisualizerFragment, R.id.main_fragment_container);

            }


        });
    }


}