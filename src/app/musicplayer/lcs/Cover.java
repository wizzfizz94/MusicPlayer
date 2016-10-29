package app.musicplayer.lcs;

import java.util.ArrayList;
import java.util.Collections;

/**
 *      performs covering to produce new classifiers
 *
 * Created by zachary on 21/10/16.
 */

public class Cover {

    public static Classifier cover(Instance instance){

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

}
