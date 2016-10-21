package app.musicplayer.lcs;

import java.util.ArrayList;

/**
 * Created by zachary on 21/10/16.
 */
public class Enviroment {

    private ArrayList currentInstance;

    public Enviroment(int instanceLength){
        currentInstance = new ArrayList(instanceLength);
    }

    public ArrayList getCurrentInstance(){
        return currentInstance;
    }
}
