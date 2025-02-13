package marketplace.persons;
import java.util.*; 
import marketplace.droids.*;


// if multiple inf-s "," to 
// for interfaces:
public class Jawa implements Seller{

    private List<Droid> droidsInStorage;
    private Map<DroidPart,Integer> partsInStorage;
    private String name;
    public Jawa(String name){
        this.name = name;
    }
    // public Jawa(){} - when provided with 2 -> overloading(polimorshisim)
    // 4 pillers for oop - inheritence, polimorshisim, encapsilation, abstract-?
    // use override when realization of the skeleton(Parent)
    @Override
    public int sellDroid( List<Droid> buyList){
        int totalValue = 0;
        for (Droid droid : buyList) {
            if(droidsInStorage.contains(droid)){
                totalValue += sellDroidParts(droid.getParts());
                droidsInStorage.remove(droid);
            }
            
        }
        return totalValue;
    }

    /// REMEMBER!!!
    /// for gets/sets - adge cases - check always
    @Override 
    public int sellDroidParts(List<DroidPart> buyList){
        int totalValue = 0;
        for (DroidPart droidPart : buyList) {
            int currentStock = partsInStorage.getOrDefault(droidPart, 0);
            if (currentStock >= 0){
                if (currentStock == 0) { 
                    partsInStorage.remove(droidPart);
                    continue;
                }
    
                partsInStorage.put(droidPart, currentStock-1);
                totalValue += droidPart.getPrice();
            }
            
        }
 
        return totalValue;
    }

    private int applyDiscount(int totalPrice) {
        double discountPercentage = haggle();
        double discountAmount = totalPrice * (discountPercentage / 100.0);  
        totalPrice -= discountAmount;
        
        return totalPrice;
    }
    
    private double haggle() {
        Random random = new Random();
        // Generate a random discount percentage between 0 and 10
        double discountPercentage = random.nextDouble() * 10;
        return discountPercentage;
    }
    

    
    public List<Droid> browseDroids(){
        List<Droid> newList = new ArrayList<>(droidsInStorage);
            //option_2
        // for (int i = 0 ; i<droidsInStorage.size(); i++){
        //     newList.add(droidsInStorage.get(i));
            
        // }
       return newList;
    }

    public Map<DroidPart,Integer> browserDroidParts(){
        Map<DroidPart,Integer> newMap  = new HashMap<>(partsInStorage); 
        return newMap;
    }

    public void addDroidToInventory(Droid droid){
        droidsInStorage.add(droid);
    }

    public void restockPart(DroidPart partType, int quantity){
        int existingQuantity = partsInStorage.getOrDefault(partType, 0);
        int newQuantity = existingQuantity+ quantity;
        partsInStorage.put(partType,newQuantity);
        
    }

    public boolean checkPartAvailability(DroidPart partType, int quantity){
        int existingQuantity = partsInStorage.getOrDefault(partType, 0);
        return existingQuantity >= quantity;
    }

    @Override
    public boolean equals(Object eq){

    if (eq == null){
        return false;
    }

    if (this.getClass() != eq.getClass()){
        return false;
    }

    Jawa eq2 = (Jawa) eq;

    return this.name.equals(eq2.name);
    }

}

// Override - there was an equals method in the parent class , but you want to override it

// for subclasses/with parent : public class Jawa extends nameOfTheParent