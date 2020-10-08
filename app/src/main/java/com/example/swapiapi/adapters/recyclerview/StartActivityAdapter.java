package com.example.swapiapi.adapters.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.swapiapi.categoryActivity.peoples.PeopleActivity;
import com.example.swapiapi.R;
import com.example.swapiapi.categoryActivity.planets.PlanetActivity;
import com.example.swapiapi.categoryActivity.species.SpecieActivity;
import com.example.swapiapi.categoryActivity.starships.StarShipActivity;
import com.example.swapiapi.categoryActivity.vehicles.VehicleActivity;

public class StartActivityAdapter extends RecyclerView.Adapter<StartActivityAdapter.ViewHolderForStartActivity> {

    private String[] starWarsInfo = {"vehicles", "peoples", "starShips", "planets", "species"};
    private Context context;

    public StartActivityAdapter(Context context) {
        this.context = context;
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

    private void startCategoryActivity(String nameCategory) {
        Intent  intent;
        switch(nameCategory) {
            case "vehicles" :
                intent = new Intent(context, VehicleActivity.class);
                break;
            case "peoples" :
                intent = new Intent(context, PeopleActivity.class);
                break;
            case "starShips" :
                intent = new Intent(context, StarShipActivity.class);
                break;
            case "planets" :
                intent = new Intent(context, PlanetActivity.class);
                break;
            case "species" :
                intent = new Intent(context, SpecieActivity.class);
                break;
            default: intent = null;
        }
        context.startActivity(intent);
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
                    startCategoryActivity(nameCategory);
                }
            });
        }

        private void bind(String nameCategory) {
            this.nameCategory = nameCategory;
            name.setText(nameCategory);

            switch(nameCategory) {
                case "vehicles" :
                    Glide.with(context).load("https://ae01.alicdn.com/kf/HTB1oZ_AbbSYBuNjSspiq6xNzpXaH/WSTXBD-Original-BANDAI-Star-Wars-Vehicle-VEHICLE-MODEL-AT-M6-012-PVC-Figure-Brinquedos-Dolls-Toys.jpg").into(image);
                    break;
                case "peoples" :
                    Glide.with(context).load("https://i.ytimg.com/vi/y999fXAx5kQ/maxresdefault.jpg").into(image);
                    break;
                case "starShips" :
                    Glide.with(context).load("https://inteng-storage.s3.amazonaws.com/img/iea/BxG2d8lJw9/sizes/porsche-lucasfilm-starship-ie_resize_md.jpg").into(image);
                    break;
                case "planets" :
                    Glide.with(context).load("https://vignette.wikia.nocookie.net/starwars/images/7/72/Teth-TVE.png/revision/latest?cb=20190423045047").into(image);
                    break;
                case "species" :
                    Glide.with(context).load("https://i.pinimg.com/originals/54/24/ac/5424acc3c35ddc100c20a6afeab2eaf9.jpg").into(image);
                    break;
            }
        }
    }

}
