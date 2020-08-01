package com.udacity.gradle.builditbigger.jokelibrary;

public class Joke {
    // Declare variables
    private String mQuestion;
    private String mAnswer;

    /**
     * Default constructor
     */
    public Joke() {}

    /**
     * Constructor for all variables
     * @param question to set
     * @param answer to set
     */
    public Joke(String question, String answer) {
        mQuestion = question;
        mAnswer = answer;
    }

    /**
     * Getter for the joke question
     * @return joke question
     */
    public String getQuestion() {
        return mQuestion;
    }

    /**
     * Setter for question
     * @param question to set
     */
    public void setQuestion(String question) {
        this.mQuestion = question;
    }

    /**
     * Getter for joke answer
     * @return joke answer
     */
    public String getAnswer() {
        return mAnswer;
    }

    /**
     * Setter for joke answer
     * @param answer to set
     */
    public void setAnswer(String answer) {
        this.mAnswer = answer;
    }

    /**
     * Method to convert joke smith to a string
     * @return converted string
     */
    @Override
    public String toString() {
        if (mAnswer != null && !mAnswer.equals("")) {
            return mQuestion + "\n\n\n" + mAnswer;
        } else {
            return mQuestion;
        }
    }
}
