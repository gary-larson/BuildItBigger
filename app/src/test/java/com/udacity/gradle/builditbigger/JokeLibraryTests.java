package com.udacity.gradle.builditbigger;

import com.udacity.gradle.builditbigger.jokelibrary.Joke;
import com.udacity.gradle.builditbigger.jokelibrary.JokeSmith;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Clas to test java joke library
 */
public class JokeLibraryTests {
    // Declare constants
    private static final String JOKE_QUESTION = "Why did the chicken cross the road?";
    private static final String JOKE_ANSWER = "To get to the other side!";
    // Declare and initialize variables
    private Joke joke = new Joke(JOKE_QUESTION, JOKE_ANSWER);
    private JokeSmith jokeSmith = new JokeSmith();

    /**
     * Test for constructor and question getter
     */
    @Test
    public void testJokeQuestionGetter() {
        assertEquals(JOKE_QUESTION, joke.getQuestion());
    }

    /**
     * Test for question setter
     */
    @Test
    public void testJokeQuestionSetter() {
        final String QUESTION = "What am I doing";
        joke.setQuestion(QUESTION);
        assertEquals(QUESTION, joke.getQuestion());
    }

    /**
     * Test for constructor and answer getter
     */
    @Test
    public void testJokeAnswerGetter() {
        assertEquals(JOKE_ANSWER, joke.getAnswer());
    }

    /**
     * Test for answer setter
     */
    @Test
    public void testJokeAnswerSetter() {
        final String ANSWER = "Just am.";
        joke.setAnswer(ANSWER);
        assertEquals(ANSWER, joke.getAnswer());
    }

    /**
     * Test to insure something is returned from get joke
     */
    @Test
    public void testJokeSmithGetter() {
        assertNotNull(jokeSmith.getJoke());
    }
}
