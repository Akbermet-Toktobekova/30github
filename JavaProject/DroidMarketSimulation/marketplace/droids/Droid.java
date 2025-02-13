package marketplace.droids;
import java.util.*;
public class Droid {
    protected List<DroidPart> parts = null;

    //in lists we do "add", "get(i)"
    //non-copyable
    public List<DroidPart> getParts(){
        List<DroidPart> newList = new ArrayList<>(); //rememeber
        for(int i=0; i<parts.size(); i++){
            newList.add(parts.get(i));
        }
        return newList ;
    }

    // remember the initial values

    protected int powerLevel=100;

    public int getPowerLevel(){
        return this.powerLevel;
    }
//
    public Droid(List<DroidPart> parts){
        this.parts = new ArrayList<>(parts);
    }
/// REMEMBER for constructors!
    // public Droid(List<DroidPart> parts){
    //     this.parts = new ArrayList<>(parts);
    // }

    public void damagePart(DroidPart part, int damage){
        
    }

    public void charge(int chargeAmount){

        int newValue = powerLevel + chargeAmount;
        powerLevel = Math.min(newValue, 100);
        // do{
        // powerLevel ++;
        // chargeAmount--;
        // }
        // while(powerLevel <= 100 && chargeAmount > 0 )
    }

    public String runDiagnostics(){
        String result ="";
        for (DroidPart part : parts){
            result += part.toString()+"\n";
            // System.out.println(part.toString());
        }
        return  result;
    }

    public void reducePower(int amount){
        int newValue = powerLevel - amount;
        powerLevel = Math.max(newValue, 0);
    }

    @Override
    public String toString(){
        String result = runDiagnostics();
        result = "Droid"+"\n" + result + "Power Level: " + powerLevel + "%";
        return result;
    }

}
