package app.musicplayer.lcs;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import  app.musicplayer.model.Library;
import app.musicplayer.model.Playlist;
import app.musicplayer.model.Song;
import javafx.collections.ObservableList;

/**
 *      Holds the attribute set of the current environment state
 *
 * Created by zachary on 21/10/16.
 */
public class Instance {

    public ArrayList<String> attributeSet;

    public Instance(Song song){

        attributeSet = new ArrayList<String>();

        attributeSet.add(String.valueOf(song.getArtist()));
        attributeSet.add(String.valueOf(song.getGenre().getValue()));
        attributeSet.add(String.valueOf(song.getLengthInBuckets().getValue()));
        attributeSet.add(String.valueOf(song.getYearInBuckets().getValue()));
        //attributeSet.add(song.getLanguage().toString());

    }

}
