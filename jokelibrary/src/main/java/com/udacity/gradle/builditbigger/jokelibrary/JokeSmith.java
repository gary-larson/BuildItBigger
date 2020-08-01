package com.udacity.gradle.builditbigger.jokelibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeSmith {
    // Declare variable
    private List<Joke> mJokeList;
    private Random mRandom;

    /**
     * Default constructor
     */
    public JokeSmith() {
        mRandom = new Random(System.currentTimeMillis());
        mJokeList = new ArrayList<>();
        mJokeList.add(new Joke("Today, my son asked \"Can I have a book mark?\" and I burst into tears.\n11 years old and he still doesn't know my name is Brian.", ""));
        mJokeList.add(new Joke("I told my psychiatrist I got suicidal tendencies.","He said from now on I have to pay in advance."));
        mJokeList.add(new Joke("What do you call a group of 8 Hobbits?","A Hobbyte."));
        mJokeList.add(new Joke("I bought some shoes from a drug dealer. I don't know what he laced them with, but I was tripping all day!",""));
        mJokeList.add(new Joke("Why are there no pharmacies in Africa?","Because you can't use medicine on an empty stomach."));
        mJokeList.add(new Joke("A neutron walks into a bar and asks for a price on a drink.\nThe barkeeper says: \"For you... no charge!\"",""));
        mJokeList.add(new Joke("To whoever stole my copy of Microsoft Office, I will find you. You have my Word!",""));
        mJokeList.add(new Joke("There are only 10 kinds of people in this world: those who know binary and those who don't.",""));
        mJokeList.add(new Joke("Why do programmers confuse halloween and christmas?","Because Oct 31 = Dec 25"));
        mJokeList.add(new Joke("What time did the man go to the dentist?","Tooth hurt-y."));
        mJokeList.add(new Joke("Why did the chicken cross the road, roll in the mud and cross the road again?","He was a dirty double crosser!"));
    }

    /**
     * Getter for Joke
     * @return joke as a string
     */
    public String getJoke() {
        int position = mRandom.nextInt(mJokeList.size());
        return mJokeList.get(position).toString();
    }

}