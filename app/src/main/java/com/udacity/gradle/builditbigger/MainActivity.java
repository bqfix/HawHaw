package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.android.javajokegenerator.JokeGenerator;
import com.example.android.jokedisplay.JokeDisplayActivity;


public class MainActivity extends AppCompatActivity implements JokeAsyncTask.JokeResult {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //A helper method that displays a joke returned from the JokeAsyncTask
    public void tellJoke(View v) {
        new JokeAsyncTask(this).execute();
    }

    //Launch the new activity when the AsyncTask returns with a joke
    @Override
    public void getJokeResult(String joke) {
        Intent jokeIntent = new Intent(MainActivity.this, JokeDisplayActivity.class);
        jokeIntent.putExtra(JokeDisplayActivity.JOKE_STRING_KEY, joke);
        startActivity(jokeIntent);
    }
}
