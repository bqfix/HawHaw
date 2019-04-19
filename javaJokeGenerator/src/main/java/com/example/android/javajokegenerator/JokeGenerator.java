package com.example.android.javajokegenerator;

import java.util.ArrayList;
import java.util.Arrays;

public class JokeGenerator {
    private ArrayList<String> jokes =  new ArrayList<>(
            Arrays.asList(
                    "This is joke #1",
                    "This is joke #2",
                    "This is joke #3"
            ));

    public String getJoke(){
        if ((jokes == null) || jokes.isEmpty()) return "No jokes here.";

        int randomIndex = (int) Math.floor(Math.random() * jokes.size());
        return jokes.get(randomIndex);
    }
}
