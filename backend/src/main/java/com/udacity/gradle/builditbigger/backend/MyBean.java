package com.udacity.gradle.builditbigger.backend;

import com.udacity.gradle.builditbigger.jokelibrary.JokeSmith;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myJoke;

    public String getData() {
        return myJoke;
    }

    public void setData() {
        JokeSmith jokeSmith = new JokeSmith();
        myJoke = jokeSmith.getJoke();
    }
}