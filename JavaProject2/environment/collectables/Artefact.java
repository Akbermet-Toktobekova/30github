package environment.collectables;
import environment.marker.*;

public abstract class  Artefact implements Marked{
    protected String locationData;
    protected final Color color;
    private boolean rigidStructure;
 
    public Artefact(String locationData, Color color){

//null.equals - no
// null - be save with it
        if (locationData == null || locationData.length()<3 ) {
            throw new IllegalArgumentException();
        }

        // x.equals(y)
        this.color = color;
        this.locationData = locationData;
        rigidStructure = true;
    }

    public Color getColor(){
        return this.color;
    }

    public String getLocationData(){
        return this.locationData;
    }

    public boolean getRigidStructure(){
        return this.rigidStructure;
    }

    public void setRigidStructure(boolean rigidStructure){
        this.rigidStructure = rigidStructure;
    }

    public abstract void extendLocationData(String newData);
    
    public abstract Artefact retrieve();

    @Override
    public String toString(){
        String result = String.format("LocationData: %s, Color: %s, isRigid: %s", locationData, color, rigidStructure);
        return result; 
    }

    @Override
    public  int hashCode() {
        return 0;
        // return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object eq){

        if(eq == null){
            return false;
        }

        if(this.getClass() != eq.getClass()){
            return false;
        }

        Artefact artefact = (Artefact) eq;

        return ((this.locationData.substring(0, 2).equals(artefact.locationData.substring(0, 2))) && (this.color.equals(artefact.color) && (this.rigidStructure == artefact.rigidStructure)));

    }

}

// class {
//     Name
//     agName
//     neptune
// }

// a = "a" 90 "999"
// b ="a" 90 "999"