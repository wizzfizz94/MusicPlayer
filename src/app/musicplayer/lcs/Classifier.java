package app.musicplayer.lcs;

import java.util.ArrayList;

/**
 * Created by zachary on 21/10/16.
 */
public class Classifier {

    public static final String wildcard = "#";


    private ArrayList<String> conditionSet;
    private double fitness;
    public double numerosity;

    public Classifier(String c1, int index1){

        conditionSet = new ArrayList<String>();
        for(int i=0;i<LCSAgent.SONG_ATTRIBUTES;i++){
            conditionSet.add(wildcard);
        }
        conditionSet.set(index1,c1);

        fitness = 0.5;
        numerosity = 1;
    }

    public Classifier(String c1, int index1, String c2, int index2){

        conditionSet = new ArrayList<String>();
        for(int i=0;i<LCSAgent.SONG_ATTRIBUTES;i++){
            conditionSet.add(wildcard);
        }
        conditionSet.set(index1,c1);
        conditionSet.set(index2,c2);

        fitness = 0.5;
        numerosity = 1;
    }

    public Classifier(String c1, int index1, String c2, int index2, String c3, int index3){

        conditionSet = new ArrayList<String>();
        for(int i=0;i<LCSAgent.SONG_ATTRIBUTES;i++){
            conditionSet.add(wildcard);
        }
        conditionSet.set(index1,c1);
        conditionSet.set(index2,c2);
        conditionSet.set(index3,c3);

        fitness = 0.5;
        numerosity = 1;
    }

    public Classifier(String c1, int index1, String c2, int index2, String c3, int index3, String c4, int index4){

        conditionSet = new ArrayList<String>();
        for(int i=0;i<LCSAgent.SONG_ATTRIBUTES;i++){
            conditionSet.add(wildcard);
        }
        conditionSet.set(index1,c1);
        conditionSet.set(index2,c2);
        conditionSet.set(index3,c3);
        conditionSet.set(index4,c4);

        fitness = 0.5;
        numerosity = 1;
    }

    public Classifier(String c1, int index1, String c2, int index2, String c3, int index3, String c4, int index4, String c5, int index5){

        conditionSet = new ArrayList<String>();
        for(int i=0;i<LCSAgent.SONG_ATTRIBUTES;i++){
            conditionSet.add(wildcard);
        }
        conditionSet.set(index1,c1);
        conditionSet.set(index2,c2);
        conditionSet.set(index3,c3);
        conditionSet.set(index4,c4);
        conditionSet.set(index5,c5);

        fitness = 0.5;
        numerosity = 1;
    }

    /**
     *      checks if a condition matches a attribute
     * @param index of the condition in the condition set
     * @param attribute value of the attribute string
     * @return
     */
    public boolean match(int index, String attribute){

        if(conditionSet.get(index).equals(attribute) || conditionSet.get(index).equals(wildcard)){
            return true;
        }
        return false;
    }

}
