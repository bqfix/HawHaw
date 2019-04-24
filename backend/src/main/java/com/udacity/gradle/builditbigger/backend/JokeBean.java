package com.udacity.gradle.builditbigger.backend;

import com.example.android.javajokegenerator.JokeGenerator;

/** The object model for the data we are sending through endpoints */
public class JokeBean {

    private JokeGenerator jokeGenerator;

    public JokeBean(){
        jokeGenerator = new JokeGenerator();
    }

    public String getJoke() {
        return jokeGenerator.getJoke();
    }

}