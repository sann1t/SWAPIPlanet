package com.example.swapiapi.adapters.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.presenters.StartPresenter;

public class StartActivityAdapter extends RecyclerView.Adapter<StartActivityAdapter.ViewHolderForStartActivity> {

    private String[] starWarsInfo = {"vehicles", "peoples", "starShips", "planets", "species", "films"};
    private Context context;
    private StartPresenter startPresenter;

    public StartActivityAdapter(Context context) {
        this.context = context;
        startPresenter = new StartPresenter(context);
    }

    @NonNull
    @Override
    public ViewHolderForStartActivity onCreateViewHolder(@NonNull ViewGroup parent, int index) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_start_activity ,parent,false);

        return new ViewHolderForStartActivity(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForStartActivity viewHolderForStartActivity, int index) {
        viewHolderForStartActivity.bind(starWarsInfo[index]);
    }

    @Override
    public int getItemCount() {
        return starWarsInfo.length;
    }


    protected class ViewHolderForStartActivity extends RecyclerView.ViewHolder {

        private TextView name;
        private ImageView image;
        private String nameCategory;

        private ViewHolderForStartActivity(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_item_start_activity);
            image = itemView.findViewById(R.id.image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startPresenter.startNewActivity(nameCategory);
                }
            });
        }

        private void bind(String nameCategory) {
            this.nameCategory = nameCategory;
            name.setText(nameCategory);

            startPresenter.setImage(nameCategory, image);
        }
    }

}
