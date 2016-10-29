package app.musicplayer.lcs;

/**
 *      performs covering to produce new classifiers
 *
 * Created by zachary on 21/10/16.
 */

public class Cover {

    public static Classifier cover(Environment env){

        //generate number of attributes to pick
        int numAttributes = (int)(Math.random() * env.getCurrentInstance().size() + 1);

        //generate index's to pick
        for(int j=0; j<numAttributes;j++){

        }

        return null;
    }

}
