package com.example.gainnote.activity.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gainnote.R;
import com.example.gainnote.fragment.SessionVisualizerFragment;
import com.example.gainnote.model.Exercice;
import com.example.gainnote.model.TrainingSession;

import java.util.List;

public class SessionVisualizerAdapter extends RecyclerView.Adapter<SessionVisualizerAdapter.ViewHolder> {

    List<Exercice> exercisesList;

    public SessionVisualizerAdapter(SessionVisualizerFragment sessionVisualizerFragment, List<Exercice> exercices){
        this.exercisesList = exercices;
    }

    @NonNull
    @Override
    public SessionVisualizerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.visualizer_row,parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SessionVisualizerAdapter.ViewHolder holder, int position) {
        Exercice exercice = exercisesList.get(position);

        holder.exerciceName.setText(exercice.getName());
        holder.exerciceRep.setText(String.valueOf(exercice.getRepetitions()));
        holder.exerciceSer.setText(String.valueOf(exercice.getSeries()));
    }

    @Override
    public int getItemCount() {
        return exercisesList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {


        private TextView exerciceName;
        private TextView exerciceRep;
        private TextView exerciceSer;

        ViewHolder(View itemView){
            super(itemView);
            exerciceName = itemView.findViewById(R.id.visualizer_exercice);
            exerciceRep = itemView.findViewById(R.id.visualizer_repetition);
            exerciceSer = itemView.findViewById(R.id.visualizer_series);
        }
    }
}
