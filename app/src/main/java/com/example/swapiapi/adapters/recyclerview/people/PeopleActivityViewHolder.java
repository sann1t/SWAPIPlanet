package com.example.swapiapi.adapters.recyclerview.people;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.categoryActivity.peoples.PeopleActivityInfo;
import com.example.swapiapi.models.peoples.People;

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
        Intent intent = new Intent(itemView.getContext(), PeopleActivityInfo.class);
        intent.putExtra("People", people);
        itemView.getContext().startActivity(intent);
    }
    protected void bind(People people) {
        this.people = people;
        name.setText(people.getName());
    }
}