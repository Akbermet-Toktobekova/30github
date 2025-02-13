package marketplace;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import marketplace.droids.*;
import marketplace.persons.*;

public class Market {

    private List<Jawa> sellers = null; // =null - to understand , no needed
// null can't be filled with anything
//private List<Jawa> sellers = new ArrayList<>(); - eq-lent

    public Market(){
        this.sellers = new ArrayList<>();
    }

    public void addSeller(Jawa seller){
        sellers.add(seller);
    }

    public int buyDroids(Jawa seller, List<Droid> droidsToBuy){
        if(sellers.contains(seller)){
            int num = seller.sellDroid(droidsToBuy); // use this once only 
            System.out.println("Droids purchased for a total price of:" + num);
            return num; // cuz seller is from Jawa
        }
        else{
            throw new IllegalArgumentException("The specified seller is not part of this market");
        }
    }

    public int buyDroidParts(Jawa seller, List<DroidPart> partsToBuy){
        if(sellers.contains(seller)){

            int num = seller.sellDroidParts(partsToBuy); // use this once only 
            System.out.println("Droid part purchased for a total price of:" + num);
            return num; // cuz seller is from Jawa
        }
        else{
            throw new IllegalArgumentException("The specified seller is not part of this market");
        }
    }

    public void displayAvailableDroids(Jawa seller){
        if(sellers.contains(seller)){
            for (Droid droid : seller.browseDroids()) {
                System.out.println(droid.toString()+"\n");
            } 
        }
        else{
            throw new IllegalArgumentException("The specified seller is not part of this market");
        }
    }

    public void displayAvailableParts(Jawa seller){
        if(sellers.contains(seller)){
            for (Entry<DroidPart,Integer> entry : seller.browserDroidParts().entrySet()) {
                //entry.getKey()
                
                if( entry.getValue()>0){
                    System.out.println(entry.getKey()+"\n");
                }
            } 
        }
        else{
            throw new IllegalArgumentException("The specified seller is not part of this market");
        }
    }
}
