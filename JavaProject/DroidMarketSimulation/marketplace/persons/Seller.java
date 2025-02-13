package marketplace.persons;
import java.util.*; 
import marketplace.droids.*;

//abstract - when not implemented
// public abstract - these guys are always true 
// for interface methods, so it's okay to not use them

// interface- don't forget!!

public interface Seller {
    public abstract int sellDroid( List<Droid> buyList);
    public abstract int sellDroidParts( List<DroidPart> buyList);
}
