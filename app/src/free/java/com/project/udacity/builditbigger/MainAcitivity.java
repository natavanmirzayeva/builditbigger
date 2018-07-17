package com.project.udacity.builditbigger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.project.udacity.jokedisplayer.JokeDisplayerActivity;
import com.udacity.gradle.builditbigger.backend.myApi.model.Joke;

public class MainAcitivity extends AppCompatActivity
{
    InterstitialAd mInterstitialAd;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar =  findViewById(R.id.progress_bar);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3284261743888939/5705707735");
        mInterstitialAd.setAdListener(new AdListener()
        {
            @Override
            public void onAdClosed()
            {
                addInterestial();
                getJoke();
            }
        });
        addInterestial();
    }

    private void addInterestial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    public void tellJoke(View view){
        if (mInterstitialAd.isLoaded())
            mInterstitialAd.show();
        else {
            getJoke();
        }
    }

    private void getJoke() {
        mProgressBar.setVisibility(View.VISIBLE);
        new GetJokeAsyncTask()
        {
            @Override
            protected void onPostExecute(Joke joke)
            {
                if (joke != null)
                {
                    Intent intent = new Intent(MainAcitivity.this, JokeDisplayerActivity.class);
                    intent.putExtra("Question",joke.getQuestion());
                    intent.putExtra("Answer",joke.getAnswer());
                    startActivity(intent);
                } else {
                    Toast.makeText(MainAcitivity.this, "There is might be a problem. Please try again!", Toast.LENGTH_LONG).show();
                }

                mProgressBar.setVisibility(View.GONE);
            }
        }.execute();
    }
}
