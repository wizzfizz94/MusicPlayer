package app.musicplayer.lcs;

import app.musicplayer.model.Library;
import app.musicplayer.model.Song;
import app.musicplayer.util.Resources;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by zachary on 30/10/16.
 */
public class Tester {

    /**
     *      test script for crossover
     */
    @Test
    public void testCrossover(){
        Classifier c1 = new Classifier("pop",1,"1980",3,"America",4);
        Classifier c2 = new Classifier("3min",0);
        System.out.println(c1.conditionSet.toString());
        System.out.println(c2.conditionSet.toString());
        LCSAgent.crossover(c1,c2);
        System.out.println(c1.conditionSet.toString());
        System.out.println(c2.conditionSet.toString());

    }

    /**
     *      test for cover
     */
    @Test
    public void testCover(){
        Resources.JAR = "";
        Song song = Library.getSong("Leaves");
        Instance instance = new Instance(song);
        Classifier classifier = LCSAgent.cover(instance);
        System.out.println(classifier.conditionSet.toString());
    }

    /**
     *      test subsume
     */
    @Test
    public void testSubsume(){
        Classifier c1 = new Classifier("pop",1,"1980",3,"America",4);
        Classifier c2 = new Classifier("pop",1);
        assertEquals(false,c1.subsume(c2));
        assertEquals(true,c2.subsume(c1));
    }
}
