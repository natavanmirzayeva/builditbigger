package com.udacity.gradle.builditbigger.backend;

import com.project.udacity.jokeprovider.Joke;

public class MyBean {

    private Joke myData;

    public Joke getData() {
        return myData;
    }

    public void setData(Joke data) {
        myData = data;
    }
}