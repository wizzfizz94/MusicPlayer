package app.musicplayer.lcs;

import java.util.ArrayList;

/**
 * Created by zachary on 21/10/16.
 */
public class Classifier implements Comparable {

    public static final String wildcard = "#";


    public ArrayList<String> conditionSet;
    private int fitness;
    public double numerosity;

    public Classifier(){
        conditionSet = new ArrayList<String>();
        for(int i=0;i<LCSAgent.NUM_ATTRIBUTES;i++){
            conditionSet.add(wildcard);
        }
        fitness = 50;
        numerosity = 1;
    }

    public Classifier(String c1, int index1){

        conditionSet = new ArrayList<String>();
        for(int i=0;i<LCSAgent.NUM_ATTRIBUTES;i++){
            conditionSet.add(wildcard);
        }
        conditionSet.set(index1,c1);

        fitness = 50;
        numerosity = 1;
    }

    public Classifier(int fitness){
        conditionSet = new ArrayList<String>();
        for(int i=0;i<LCSAgent.NUM_ATTRIBUTES;i++){
            conditionSet.add(wildcard);
        }
        this.fitness = fitness;
        numerosity = 1;
    }

    public Classifier(String c1, int index1, String c2, int index2){

        conditionSet = new ArrayList<String>();
        for(int i=0;i<LCSAgent.NUM_ATTRIBUTES;i++){
            conditionSet.add(wildcard);
        }
        conditionSet.set(index1,c1);
        conditionSet.set(index2,c2);

        fitness = 50;
        numerosity = 1;
    }

    public Classifier(String c1, int index1, String c2, int index2, String c3, int index3){

        conditionSet = new ArrayList<String>();
        for(int i=0;i<LCSAgent.NUM_ATTRIBUTES;i++){
            conditionSet.add(wildcard);
        }
        conditionSet.set(index1,c1);
        conditionSet.set(index2,c2);
        conditionSet.set(index3,c3);

        fitness = 50;
        numerosity = 1;
    }

    public Classifier(String c1, int index1, String c2, int index2, String c3, int index3, String c4, int index4){

        conditionSet = new ArrayList<String>();
        for(int i=0;i<LCSAgent.NUM_ATTRIBUTES;i++){
            conditionSet.add(wildcard);
        }
        conditionSet.set(index1,c1);
        conditionSet.set(index2,c2);
        conditionSet.set(index3,c3);
        conditionSet.set(index4,c4);

        fitness = 50;
        numerosity = 1;
    }

    public Classifier(String c1, int index1, String c2, int index2, String c3, int index3, String c4, int index4, String c5, int index5){

        conditionSet = new ArrayList<String>();
        for(int i=0;i<LCSAgent.NUM_ATTRIBUTES;i++){
            conditionSet.add(wildcard);
        }
        conditionSet.set(index1,c1);
        conditionSet.set(index2,c2);
        conditionSet.set(index3,c3);
        conditionSet.set(index4,c4);
        conditionSet.set(index5,c5);

        fitness = 50;
        numerosity = 1;
    }

    /**
     *
     * @param index
     * @param value
     */
    public void setCondition(int index, String value){
        conditionSet.set(index,value);
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

    /**
     *      Subsume another classifier
     * @param classifier the other classifier
     * @return true if subsumed
     */
    public boolean subsume(Classifier classifier){
        for(int i=0; i<LCSAgent.NUM_ATTRIBUTES;i++){
            if(!this.conditionSet.get(i).equals(wildcard) && !this.conditionSet.get(i).equals(classifier.conditionSet.get(i))){
                return false;
            }
        }
        return true;
    }


    /**
     *      Get fitness
     * @return
     */
    public int getFitness() {
        return fitness;
    }

    /**
     *      Set fitness
     * @param value
     * @return
     */
    public void setFitness(int value){
        fitness = value;
    }

    @Override
    /*
     * Sort in Descending order
     * @param o the classifier
     */
    public int compareTo(Object o) {
        int compareFitness;
        compareFitness = ((Classifier)o).getFitness();
        return compareFitness - this.fitness;
    }
}
