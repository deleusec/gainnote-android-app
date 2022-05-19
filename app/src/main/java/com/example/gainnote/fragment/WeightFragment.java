package com.example.gainnote.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.gainnote.R;
import com.example.gainnote.databinding.FragmentWeightBinding;

public class WeightFragment extends Fragment {
    FragmentWeightBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_weight, container, false);




        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}
