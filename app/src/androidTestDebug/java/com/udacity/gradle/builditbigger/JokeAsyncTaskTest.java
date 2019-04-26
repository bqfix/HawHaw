package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutionException;

@RunWith(AndroidJUnit4.class)
public class JokeAsyncTaskTest implements JokeAsyncTask.JokeResult {

    @Test
    public void asyncTaskReturnsNonEmptyString() {
        String result;
        try {
            result = new JokeAsyncTask(this).execute().get(); //Attempt to reassign string using the AsyncTask (note: this is purposefully on the UI thread)
        } catch (ExecutionException | InterruptedException e) {
            result = "";
        }

        assertNotEquals(result, "");
    }

    @Override
    public void getJokeResult(String joke) {
    }
}
