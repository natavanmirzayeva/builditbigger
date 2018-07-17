package com.project.udacity.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.backend.myApi.model.Joke;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertTrue;

/**
 * Created by mehseti on 7.7.2018.
 */
@RunWith(AndroidJUnit4.class)
public class JokeTest
{
    @Test
    public void jokeTest()
    {
        GetJokeAsyncTask getJokeAsyncTask = new GetJokeAsyncTask();
        getJokeAsyncTask.execute();
        try {
            Joke joke = getJokeAsyncTask.get();
            assertTrue(!joke.equals(null));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
