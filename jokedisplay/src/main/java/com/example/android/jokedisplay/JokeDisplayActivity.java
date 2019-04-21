package com.example.android.jokedisplay;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    public static String JOKE_STRING_KEY = "joke_string";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        //Initialize Views
        TextView jokeDisplayTextView = (TextView) findViewById(R.id.joke_display_tv);

        //Get Intent Extra
        Intent jokeIntent = getIntent();
        if (!jokeIntent.hasExtra(JOKE_STRING_KEY)) finish(); //If Joke not provided, finish

        jokeDisplayTextView.setText(jokeIntent.getStringExtra(JOKE_STRING_KEY));

        //Set up button functionality
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (android.R.id.home): {
                onBackPressed();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
