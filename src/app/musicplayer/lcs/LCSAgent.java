package app.musicplayer.lcs;

import java.util.ArrayList;

/**
 * Created by zachary on 21/10/16.
 */
public class LCSAgent {

    public static final int NUM_SONGS = 1;

    public static final int NUM_ATTRIBUTES = 5;

    public static final int TOTAL_ATTRIBUTES = NUM_SONGS * NUM_ATTRIBUTES;

    private ArrayList<Classifier> population;
    private ArrayList<Classifier> matchSet;

    LCSAgent(){

        population = new ArrayList<Classifier>();
        matchSet = new ArrayList<Classifier>();
    }

    /**
     *      Start LCS system
     */
    public void start(){

    }

    /**
     *      Find macthes and populate match set
     * @param instance to match
     */
    public void findMatches(Instance instance){

    }

}
