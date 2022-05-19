package com.example.gainnote.activity.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gainnote.R;
import com.example.gainnote.fragment.HomeFragment;
import com.example.gainnote.model.TrainingSession;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public abstract class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    List<TrainingSession> trainingSessionList;

    public HomeAdapter(HomeFragment homeFragment, List<TrainingSession> trainingSession){
        this.trainingSessionList = trainingSession;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.session_row,parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        TrainingSession trainingSession = trainingSessionList.get(position);

        holder.date.setText(trainingSession.getDate() + "   " + trainingSession.getTime());
        //trainingSession.getDate().
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onContainerClick(trainingSession);
            }
        });
    }

    public abstract void onContainerClick(TrainingSession trainingSession);

    @Override
    public int getItemCount() {
        return trainingSessionList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {


        private TextView date;
        private LinearLayout container;

        ViewHolder(View itemView){
            super(itemView);
            date = itemView.findViewById(R.id.session_date);
            container = itemView.findViewById(R.id.session_container);
        }
    }
}
