package app.musicplayer.lcs;

import java.util.ArrayList;

/**
 *  Holds attributes values
 *
 * Created by zachary on 21/10/16.
 */
public class AttributeSet {

    private ArrayList set;

    public AttributeSet(int size){
        set = new ArrayList(size);
    }

    public ArrayList getSet(){
        return set;
    }
}
