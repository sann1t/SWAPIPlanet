package com.example.swapiapi.adapters.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.swapiapi.CallBackStartNewActivity;
import com.example.swapiapi.R;

public class StartActivityAdapter extends RecyclerView.Adapter<StartActivityAdapter.ViewHolderForStartActivity> {

    private String[] starWarsInfo = {"vehicles", "peoples", "starShips", "planets", "species", "films"};
    private Context context;
    private CallBackStartNewActivity callBackStartNewActivity;

    public StartActivityAdapter(Context context, CallBackStartNewActivity callBackStartNewActivity) {
        this.callBackStartNewActivity = callBackStartNewActivity;
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
                    callBackStartNewActivity.startNewActivity(nameCategory);
                }
            });
        }

        private void bind(String nameCategory) {
            this.nameCategory = nameCategory;
            name.setText(nameCategory);

            switch(nameCategory) {
                case "vehicles" :
                    Glide.with(context).load("https://iconarchive.com/icons/jonathan-rey/star-wars-vehicles/icons-390.jpg").into(image);
                    break;
                case "peoples" :
                    Glide.with(context).load("https://sun9-47.userapi.com/impf/c848536/v848536870/1d3243/MRhMNKXnSDU.jpg?size=200x0&quality=90&crop=278,0,585,675&sign=630125a14a6328db53f3b129948c162e&ava=1").into(image);
                    break;
                case "starShips" :
                    Glide.with(context).load("https://bigpicture.ru/wp-content/uploads/2015/04/starwarsstars00.jpg").into(image);
                    break;
                case "planets" :
                    Glide.with(context).load("https://www.swleague.ru/_pu/2/33212380.png").into(image);
                    break;
                case "species" :
                    Glide.with(context).load("https://images.wikia.com/starwars/images/thumb/6/63/Devaronians.jpg/200px-Devaronians.jpg").into(image);
                    break;
                 case "films" :
                    Glide.with(context).load("https://lh3.googleusercontent.com/proxy/1SKxYuSef6449GaPjV0XzluQQWZukGDS7fRdZx1KwGa4JntkWYBP0As0m_mg52Lr-wu5mZy58fq_x7lvqQ9uKRfsPUcEG81WqcU7zN-ae7TlxR4").into(image);
                    break;
            }
        }
    }

}
