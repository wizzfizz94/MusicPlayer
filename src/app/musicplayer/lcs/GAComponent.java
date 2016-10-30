package app.musicplayer.lcs;

/**
 * Created by zachary on 21/10/16.
 */
public class GAComponent {

    public Classifier crossover(Instance instance, Classifier c1, Classifier c2){

        //find were specification occurs in one classifier but not the other
        for(int i=0;i<LCSAgent.NUM_ATTRIBUTES;i++){

            if(c1.conditionSet.get(i).equals("#") && !c2.conditionSet.get(i).equals("#")){
                //replace at 50% probablity
                int replace = (int)(Math.random()*2);
                if(replace == 0){
                    c1.conditionSet.set(i,instance.attributeSet.get(i));
                }
                replace = (int)(Math.random()*2);
                if(replace == 0){
                    c2.conditionSet.set(i,"#");
                }
            }
            if(!c1.conditionSet.get(i).equals("#") && c2.conditionSet.get(i).equals("#")){
                //replace at 50% probablity
                int replace = (int)(Math.random()*2);
                if(replace == 0){
                    c1.conditionSet.set(i,"#");
                }
                replace = (int)(Math.random()*2);
                if(replace==0){
                    c2.conditionSet.set(i,instance.attributeSet.get(i));
                }
            }
        }
    }
}
