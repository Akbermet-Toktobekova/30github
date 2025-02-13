package marketplace.droids;

public class DroidPart {
    private int basePrice;

    private int damage;
    //getter
    public int getDamage(){
        return this.damage;
    }
    //setter
    public void setDamage(int damage){
        if (damage<0 || damage>100){
            throw new IllegalArgumentException();
        }
        this.damage = damage;
    }
    
    private DroidPartTypes type;

    public DroidPartTypes getType(){
        return this.type;
    }
    
    //constructor // doesn't have specified return type
    public DroidPart( int basePrice, int damage, DroidPartTypes type){

    }
    // if returns Nothing, int - write it in the function name
    public int getPrice(){
        return (int) (basePrice*(1-(damage/100.0f)));
    }

// int/int -> int, double/int -> double
// toDouble - num.0f, toInt (int)

    public int getRepairCost(){
        return basePrice - getPrice();
    }
    
    public void upgrade(int priceIncrease){
        basePrice = basePrice + priceIncrease;
    }
    
    //TEXTUAL_REPRESENTATION
    @Override
    public String toString(){
        return String.format("Part: %s, Damage: %d%%", type.toString(), damage);
        //return "Part: " + type.toString() + ", Damage: " + damage + "%";

    }

}
