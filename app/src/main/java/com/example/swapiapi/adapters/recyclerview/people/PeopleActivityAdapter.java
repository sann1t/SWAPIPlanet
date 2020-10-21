package com.example.swapiapi.adapters.recyclerview.people;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.swapiapi.R;
import com.example.swapiapi.models.peoples.People;
import com.example.swapiapi.models.peoples.Peoples;
import com.example.swapiapi.views.peoples.info.StartNewActivityCallBack;

import java.util.List;

public class PeopleActivityAdapter extends RecyclerView.Adapter<PeopleActivityViewHolder> {

    private List<People> peoplesList;
    private StartNewActivityCallBack callBack;

    public PeopleActivityAdapter(Peoples peoples, StartNewActivityCallBack callBack) {
        this.callBack = callBack;
        this.peoplesList = peoples.getResults();
    }


    @NonNull
    @Override
    public PeopleActivityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_category_activity, viewGroup, false);
        return new PeopleActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleActivityViewHolder peopleActivityViewHolder, int i) {
        peopleActivityViewHolder.bind(peoplesList.get(i), callBack);
    }

    @Override
    public int getItemCount() {
        return peoplesList.size();
    }
}
