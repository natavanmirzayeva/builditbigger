package com.project.udacity.jokeprovider;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class JokeProvider
{
    public Joke jokeProvide()
    {
        Reader reader = null;
        List<Joke> jokes = new ArrayList<>() ;

        try {
            File file = new File(".\\JokeProvider\\src\\jokes.txt");
            reader = new FileReader(file);
            Gson gson = new Gson();
            Joke[] joke = gson.fromJson(reader, Joke[].class);
            for(int i=0;i<joke.length;i++)
            {
                jokes.add(joke[i]);
            }
            Collections.shuffle(jokes);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return jokes.get(0);
    }
}
