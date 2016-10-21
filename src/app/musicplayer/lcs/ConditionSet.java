package app.musicplayer.lcs;

import app.musicplayer.model.Song;

import java.util.ArrayList;

/**
 *  Holds attribute values for conditions set in classifiers
 *
 * Created by zachary on 21/10/16.
 */
public class ConditionSet {

    public static final String wildcard = "#";

    private ArrayList<Song> songSet;
    private  ArrayList<String> stringSet;

    public ConditionSet(){

    }

    public ArrayList getSet(){
        return stringSet;
    }
}
