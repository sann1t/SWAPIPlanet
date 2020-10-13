package com.example.swapiapi.models;

import android.graphics.Color;

import java.util.Random;

public class RandomColor implements RandomColorInterface {

    private int r;
    private int g;
    private int b;
    @Override
    public int getRandomColor() {
        Random random = new Random();
        r = random.nextInt(255);
        g = random.nextInt(255);
        b = random.nextInt(255);

        return Color.rgb(r, g, b);
    }
}
