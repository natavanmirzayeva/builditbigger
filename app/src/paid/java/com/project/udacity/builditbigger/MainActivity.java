package com.project.udacity.builditbigger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.udacity.gradle.builditbigger.backend.myApi.model.Joke;
import com.project.udacity.jokedisplayer.JokeDisplayerActivity;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress_bar);
    }

    public void tellJoke(View v)
    {
        progressBar.setVisibility(View.VISIBLE);
        new GetJokeAsyncTask() {
            @Override
            protected void onPostExecute(Joke joke) {
                if (joke != null)
                {
                    progressBar.setVisibility(View.GONE);
                    Intent intent = new Intent(MainActivity.this, JokeDisplayerActivity.class);
                    intent.putExtra("Question",joke.getQuestion());
                    intent.putExtra("Answer",joke.getAnswer());
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "There is might be a problem. Please try again!", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }

            }
        }.execute();
    }
}
