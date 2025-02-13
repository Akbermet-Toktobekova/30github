package marketplace.droids.custom;
import marketplace.droids.*;
import java.util.*;

// no extend for 1+ classes

public class RepairDroid extends Droid{
    private int repairAmount;
    public RepairDroid( List<DroidPart> parts, int repairAmount){
        super(parts);
        this.repairAmount = repairAmount;
    }
    public void repairPart( DroidPart droidPart){

        if (powerLevel>=8){
            droidPart.setDamage(Math.clamp(droidPart.getDamage()-repairAmount, 0,100)); // rem!!
            powerLevel -= 8;
        }

    }
    public void prioritizeRepair( List<DroidPart> parts){
 //sorrt the list itself 
        Collections.sort(parts, new Comparator<DroidPart>() {
            @Override
            public int compare(DroidPart l, DroidPart r) {
                return l.getDamage() - r.getDamage();
            }
        });

        for(int i=0; i < parts.size(); i++){
            repairPart(parts.get(i));
        }
    }

    @Override
    public String toString(){
        String result = runDiagnostics();
        result = "RepairDroid"+"\n" + result + "Power Level: " + powerLevel + "%"+"\n"+"Repair amount: 20";
        return result;
    }
}