package com.example.android.javajokegenerator;

import java.util.ArrayList;
import java.util.Arrays;

public class JokeGenerator {
    private ArrayList<String> jokes =  new ArrayList<>(
            Arrays.asList(
                    "What is red and smells like blue paint?\n\nRed paint.",
                    "What do you call a fish with no eyes?\n\nA fsh.",
                    "What has 4 letters, sometimes has 9 letters, but never has 5 letters.",
                    "What's a pirate's favorite letter?\n\nArrr.",
                    "What computer sings the best?\n\nA Dell.",
                    "How do you find Will Smith in the snow?\n\nLook for the fresh prints.",
                    "What's a dentist's favorite time of day?\n\nTooth hurty.",
                    "How many software engineers does it take to screw in a lightbulb?\n\nNone, it's a hardware issue."
            ));

    public String getJoke(){
        if ((jokes == null) || jokes.isEmpty()) return "No jokes here.";

        int randomIndex = (int) Math.floor(Math.random() * jokes.size());
        return jokes.get(randomIndex);
    }
}
