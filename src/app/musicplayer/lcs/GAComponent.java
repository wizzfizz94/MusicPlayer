package app.musicplayer.lcs;

import org.junit.Test;

/**
 * Created by zachary on 21/10/16.
 */
public class GAComponent {

    /**
     *      Performs crossover on two classifiers
     * @param c1, first classifier
     * @param c2, second classifier
     */
    public static void crossover(Classifier c1, Classifier c2) {

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

    public static void mutate(Instance instance, Classifier classifier){

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

}
