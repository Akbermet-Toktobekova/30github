package environment.collectables;

import environment.marker.Color;

public class Waste extends Artefact {
    private boolean tagged = false;
    private boolean isAlreadySet = false;

    public Waste(String locationData, Color color){
        super(locationData, color);
        super.setRigidStructure(true);
    }
    
    @Override
    public void extendLocationData(String locationData){
        this.locationData += locationData;
    }

    @Override
    public Waste retrieve(){
        if(tagged){
            this.locationData += "#KO";
            return this;
        }
        else{
            return null;
        }

    }
    
    @Override
    public void tag(){
        // if(tagged){
        //     tagged = false; 
        // }
        // else{
        //     tagged = true;\
        tagged = !tagged;

    }
    
    @Override
    public void setRigidStructure(boolean rigidStructure){
        if (!isAlreadySet){
            super.setRigidStructure(rigidStructure);
            isAlreadySet = true;
        }
    }


}
