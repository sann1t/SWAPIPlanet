package com.example.swapiapi.presenters;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.swapiapi.views.films.FilmActivity;
import com.example.swapiapi.views.peoples.PeopleActivity;
import com.example.swapiapi.views.planets.PlanetActivity;
import com.example.swapiapi.views.species.SpecieActivity;
import com.example.swapiapi.views.starships.StarShipActivity;
import com.example.swapiapi.views.vehicles.VehicleActivity;

public class StartPresenter{

    private Context context;

    public StartPresenter(Context context) {
        this.context = context;
    }

    public void startNewActivity(String nameCategory) {
        Intent intent;
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
            case "films" :
                intent = new Intent(context, FilmActivity.class);
                break;
            default: intent = null;
        }
        context.startActivity(intent);
    }

    public void setImage(String nameCategory, ImageView image) {
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
