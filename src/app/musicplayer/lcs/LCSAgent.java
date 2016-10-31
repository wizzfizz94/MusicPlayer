package app.musicplayer.lcs;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by zachary on 21/10/16.
 */
public class LCSAgent {

    public static final int NUM_SONGS = 1;

    public static final int MAX_POPULATION_SIZE = 30;

    public static final int NUM_ATTRIBUTES = 4;

    public static final double DELETE_RATE = 0.1;

    public static final int TOTAL_ATTRIBUTES = NUM_SONGS * NUM_ATTRIBUTES;

    public ArrayList<Classifier> population;
    private ArrayList<Classifier> matchSet;

    private Instance instance;

    public LCSAgent(){

        population = new ArrayList<Classifier>();
        matchSet = null;
        instance = null;
    }

    public void setInstance(Instance instance){
        this.instance = instance;
    }

    public void printPopulation(){
        for (int i=0; i<population.size();i++){
            System.out.print(population.get(i).conditionSet.toString());
            System.out.print("hello");
        }
    }

    /**
     *
     * @param instance
     * @return
     */
    public boolean findMatches(Instance instance){
        this.instance = instance;
        matchSet = new ArrayList<Classifier>();
        outerloop : for(Classifier classifier : population){
            for (int i=0;i<NUM_ATTRIBUTES;i++){
                if(!classifier.match(i, instance.attributeSet.get(i))){
                    continue outerloop;
                }
            }
            matchSet.add(classifier);
        }

        if(matchSetIsEmpty()){
            if(!isFull()){
                cover();
            }else{
                delete();
            }
            return false;
        }
        return true;
    }

    public void updateFitness(int reinforcement){
        for (Classifier classifier : matchSet){
            classifier.setFitness(classifier.getFitness() + reinforcement);
        }

        if(matchSet.size() > 1){
            startGA();
        }
    }

    public void startGA(){
        Collections.shuffle(matchSet);
        Classifier classifier = crossover(matchSet.get(0), matchSet.get(1));
        mutate(classifier);
        population.add(classifier);
        resizePopulation();
        printPopulation();
    }

    public void resizePopulation(){
        // Sort the classifiers by fitness
        Collections.sort(population);

        int j = population.size();
        while(j > MAX_POPULATION_SIZE){
            population.remove(j-1);
        }
    }

    public boolean matchSetIsEmpty(){
        return matchSet.isEmpty();
    }

    public boolean isFull(){
        if(population.size() >= MAX_POPULATION_SIZE){
            return true;
        }
        return false;
    }

    /**
     *      Performs crossover on two classifiers
     * @param c1, first classifier
     * @param c2, second classifier
     */
    public Classifier crossover(Classifier c1, Classifier c2) {

        Classifier classifier = new Classifier();

        for (int i = 0; i < LCSAgent.NUM_ATTRIBUTES; i++) {
            //replace at 50% probablity
            int replace = (int) (Math.random() * 2);

            if(replace==0){
                int parent = (int) (Math.random() * 2);
                if(parent==0){
                    classifier.setCondition(i,c1.conditionSet.get(i));
                }else{
                    classifier.setCondition(i,c2.conditionSet.get(i));
                }
            }
        }

        return classifier;
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
    public void cover(){

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

        population.add(classifier);
    }


    public void delete(){

        // Sort the classifiers by fitness
        Collections.sort(population);

        int j = population.size();
        while(j > MAX_POPULATION_SIZE - 1){
            population.remove(j-1);
        }
    }


}
