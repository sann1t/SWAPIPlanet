package com.example.swapiapi.adapters.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.categoryActivity.peoples.PeopleActivityInfo;
import com.example.swapiapi.models.peoples.People;
import com.example.swapiapi.models.peoples.PeoplesList;

import java.util.List;

public class PeopleActivityAdapter extends RecyclerView.Adapter<PeopleActivityAdapter.PeopleActivityViewHolder> {

    private List<People> peoplesList;
    private Context parent;

    public PeopleActivityAdapter(PeoplesList peoplesList, Context parent) {
        this.parent = parent;
        this.peoplesList = peoplesList.getResults();
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
        peopleActivityViewHolder.bind(peoplesList.get(i));
    }

    @Override
    public int getItemCount() {
        return peoplesList.size();
    }

    public class PeopleActivityViewHolder extends RecyclerView.ViewHolder{

        private People people;
        private TextView name;

        public PeopleActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startNewActivity();
                }
            });
        }

        private void startNewActivity() {
            Intent intent = new Intent(parent, PeopleActivityInfo.class);
            intent.putExtra("People", people);
            parent.startActivity(intent);
        }
        private void bind(People people) {
            this.people = people;
            name.setText(people.getName());
        }
    }
}
