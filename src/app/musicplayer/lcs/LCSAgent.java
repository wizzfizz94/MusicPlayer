package app.musicplayer.lcs;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by zachary on 21/10/16.
 */
public class LCSAgent {

    public static final int NUM_SONGS = 1;

    public static final int NUM_ATTRIBUTES = 5;

    public static final int TOTAL_ATTRIBUTES = NUM_SONGS * NUM_ATTRIBUTES;

    private ArrayList<Classifier> population;
    private ArrayList<Classifier> matchSet;

    private Instance instance;

    LCSAgent(){

        population = new ArrayList<Classifier>();
        matchSet = null;
        instance = null;
        start();
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

    /**
     *      Performs crossover on two classifiers
     * @param c1, first classifier
     * @param c2, second classifier
     */
    public void crossover(Classifier c1, Classifier c2) {

        //find were specification occurs in one classifier but not the other
        for (int i = 0; i < LCSAgent.NUM_ATTRIBUTES; i++) {

            if (c1.conditionSet.get(i).equals("#") && !c2.conditionSet.get(i).equals("#")) {
                //replace at 50% probablity
                int replace = (int) (Math.random() * 2);
                if (replace == 0) {
                    c1.conditionSet.set(i, c2.conditionSet.get(i));
                }
                replace = (int) (Math.random() * 2);
                if (replace == 0) {
                    c2.conditionSet.set(i, "#");
                }
            }
            else if (!c1.conditionSet.get(i).equals("#") && c2.conditionSet.get(i).equals("#")) {
                //replace at 50% probablity
                int replace = (int) (Math.random() * 2);
                if (replace == 0) {
                    c1.conditionSet.set(i, "#");
                }
                replace = (int) (Math.random() * 2);
                if (replace == 0) {
                    c2.conditionSet.set(i, c1.conditionSet.get(i));
                }
            }
        }
    }

    /**
     *
     * @param classifier
     */
    public void mutate(Classifier classifier){

        for (int i = 0; i < LCSAgent.NUM_ATTRIBUTES; i++) {
            //replace at 33.33% probability
            int replace = (int)(Math.random()*3);
            if(replace == 0){
                if(classifier.conditionSet.get(i).equals("#")){
                    classifier.conditionSet.set(i,instance.attributeSet.get(i));
                }else{
                    classifier.conditionSet.set(i,"#");
                }
            }
        }
    }

    /**
     *
     * @return
     */
    public Classifier cover(){

        Classifier classifier = new Classifier();

        //generate number of attributes to pick
        int numAttributes = (int)(Math.random() * LCSAgent.NUM_ATTRIBUTES + 1);

        //randomly pick indexes and copy attribute to classifier
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        for(int j=0; j<LCSAgent.NUM_ATTRIBUTES;j++){
            indexList.add(j);
        }
        Collections.shuffle(indexList);
        for(int j=0; j<numAttributes;j++){
            classifier.setCondition(indexList.get(j),instance.attributeSet.get(indexList.get(j)));
        }

        return classifier;
    }


    public void delete(){

    }

}
