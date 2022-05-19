package com.example.gainnote.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.gainnote.R;
import com.example.gainnote.activity.adapter.HomeAdapter;
import com.example.gainnote.activity.adapter.SessionVisualizerAdapter;
import com.example.gainnote.dao.AppDatabase;
import com.example.gainnote.databinding.FragmentHomeBinding;
import com.example.gainnote.databinding.FragmentSessionVisualizerBinding;
import com.example.gainnote.model.Exercice;
import com.example.gainnote.model.TrainingSession;
import com.example.gainnote.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

public class SessionVisualizerFragment extends Fragment {
    FragmentSessionVisualizerBinding binding;

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_session_visualizer, container, false);

        TrainingSession trainingSession = getArguments().getParcelable("TRAINING_KEY");
        List<Exercice> exercices = trainingSession.getExercices();

        binding.visualizerDate.setText(trainingSession.getDate() + " " + trainingSession.getTime());
        binding.visualizerList.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.visualizerList.setAdapter(new SessionVisualizerAdapter(this, exercices));

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}
