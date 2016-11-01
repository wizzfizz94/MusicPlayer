package app.musicplayer.lcs;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by zachary on 21/10/16.
 */
public class LCSAgent {

    public static final int NUM_SONGS = 1;

    public static final int MAX_POPULATION_SIZE = 10;

    public static final int CULL_SIZE = 9;     //MUST BE LESS THAN MAX_POPULATION_SIZE

    public static final int NUM_ATTRIBUTES = 4;

    public static final int CROSSOVER_RATE = 2;

    public static final int MUTATE_RATE = 3;

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
            classifier.numerosity++;
            matchSet.add(classifier);
        }

        if(matchSetIsEmpty()){
            if(!isFull()){
                cover();
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
        if(population.size() >= MAX_POPULATION_SIZE){
            resizePopulation();
        }
    }

    public void startGA(){
        Collections.shuffle(matchSet);
        Classifier classifier = crossover(matchSet.get(0), matchSet.get(1));
        mutate(classifier);
        population.add(classifier);
        subsume();

    }

    public void resizePopulation(){
        // Sort the classifiers by fitness
        Collections.sort(population);

        ArrayList<Classifier> swpPop = population;
        population = new ArrayList<Classifier>();
        for(int i=0;i<CULL_SIZE;i++){
            population.add(swpPop.get(i));
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
            int parent = (int) (Math.random() * CROSSOVER_RATE);

            if(parent==0){
                classifier.setCondition(i,c1.conditionSet.get(i));
            }else{
                classifier.setCondition(i,c2.conditionSet.get(i));
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
            int replace = (int)(Math.random()*MUTATE_RATE);
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

    public void subsume(){
        for (Classifier classifier : matchSet){
            outerloop : for (Classifier classifier1 : matchSet){
                //if same object continue
                if(classifier == classifier1){
                    continue outerloop;
                }

                for(int i=0;i<NUM_ATTRIBUTES;i++){
                    if( !classifier.conditionSet.get(i).equals(classifier1.conditionSet.get(i)) &&  !classifier.conditionSet.get(i).equals("#")){
                        continue outerloop;
                    }
                }
                population.remove(classifier1);
            }
        }
    }


    public void delete(){

        // Sort the classifiers by fitness
        Collections.sort(population);

        int j = population.size();
        ArrayList<Classifier> swpPop = population;
        population = new ArrayList<Classifier>();
        while(j > MAX_POPULATION_SIZE - 1){
            population.remove(j-1);
        }
    }


}
