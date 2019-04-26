package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;

import java.io.IOException;

public class JokeAsyncTask extends AsyncTask<Void, Void, String> {
    private static JokeApi mJokeApi = null;
    private JokeAsyncPreExecute mJokeAsyncPreExecute;
    private JokeResult mJokeResult;

    public JokeAsyncTask(JokeAsyncPreExecute jokeAsyncPreExecute, JokeResult jokeResponse){
        mJokeAsyncPreExecute = jokeAsyncPreExecute;
        mJokeResult = jokeResponse;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mJokeAsyncPreExecute.performPreExecute();
    }

    @Override
    protected String doInBackground(Void... params) {
        if (mJokeApi == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            mJokeApi = builder.build();
        }

        try {
            return mJokeApi.getJokeBean().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }


    @Override
    protected void onPostExecute(String joke) {
        mJokeResult.getJokeResult(joke);
    }

    public interface JokeResult {
        void getJokeResult(String joke);
    }

    public interface JokeAsyncPreExecute {
        void performPreExecute();
    }
}
