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
public class Environment {

    private ArrayList<String> currentInstance = new ArrayList<String>();

    public Environment(){
        update();
    }

    public void update(){
        currentInstance.clear();
        //get last three songs and create instance set
        Playlist recentPlaylist = Library.getPlaylist(-1);      //id of recent playlist
        List<Song> songs = recentPlaylist.getSongs().subList(0,LCSAgent.NUM_SONGS);

        for(Song song : songs){
            currentInstance.add(song.getArtist());
            currentInstance.add(song.getLength());
            currentInstance.add(Integer.toString(song.getPlayCount()));
        }
    }

    public ArrayList getCurrentInstance(){
        return currentInstance;
    }
}
