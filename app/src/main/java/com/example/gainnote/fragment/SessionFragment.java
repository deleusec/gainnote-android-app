package com.example.gainnote.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.gainnote.R;
import com.example.gainnote.activity.CurrentDataActivity;
import com.example.gainnote.dao.AppDatabase;
import com.example.gainnote.databinding.FragmentHomeBinding;
import com.example.gainnote.databinding.FragmentSessionBinding;
import com.example.gainnote.model.Exercice;
import com.example.gainnote.model.TrainingSession;
import com.example.gainnote.utils.ActivityUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SessionFragment extends Fragment
{
    FragmentSessionBinding binding;
    ArrayList<View> exercicesRows = new ArrayList<>();
    ArrayList<Exercice> exercices = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_session, container, false);

        View exerciceRow = inflater.inflate(R.layout.exercice_row, container,false);
        exercicesRows.add(exerciceRow);
        binding.exercicesContainer.addView(exerciceRow);

        binding.sessionAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View exerciceRow = inflater.inflate(R.layout.exercice_row, container,false);
                exercicesRows.add(exerciceRow);
                binding.exercicesContainer.addView(exerciceRow);
            }
        });

        binding.sessionValidate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                for (View item : exercicesRows) {
                    String exerciceName =((EditText)item.findViewById(R.id.exercice_name)).getText().toString();
                    String exerciceRep =((EditText)item.findViewById(R.id.exercice_series)).getText().toString();
                    String exerciceSer =((EditText)item.findViewById(R.id.exercice_responses)).getText().toString();

                    if(!exerciceName.isEmpty() && !exerciceSer.isEmpty() && !exerciceRep.isEmpty()){
                        Exercice exercice = new Exercice(exerciceName, Integer.parseInt(exerciceSer), Integer.parseInt(exerciceRep));
                        exercices.add(exercice);
                    }


                    Log.i("item", exerciceSer);
                    Log.i("item", exerciceRep);
                    Log.i("item", exerciceName);
                }

                if(!exercices.isEmpty()){
                    TrainingSession session = new TrainingSession(exercices);
                    AppDatabase.getDatabase(getContext()).appDao().insert(session);
                }

                for(Fragment fragment : getActivity().getSupportFragmentManager().getFragments()){
                    if(fragment instanceof HomeFragment) {
                        ((HomeFragment) fragment).setupRecyclerView();
                    }
                }

                getActivity().onBackPressed();


            }
        });

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}
