package environment.collectables;

import environment.marker.Color;

public class Sample extends Artefact {
    private boolean tagged = false;
    
    
    public Sample(String locationData, Color color){
        super(locationData, color);
        super.setRigidStructure(false);

    }

    @Override
    public void extendLocationData(String locationData){
        this.locationData += locationData;
    }

    @Override
    public Sample retrieve(){
        if(super.getRigidStructure() || tagged){
            //this.locationData += "#KO";
            if((locationData.length() + color.toString()).length() > 9 && (locationData.length() + color.toString()).length() < 14){
                this.locationData += "#OK";
            }
            else{
                this.locationData += "#NO";
            }
            return this;
        }
        else{
            return null;
        }
    }
    
    @Override
    public void tag(){
        this.tagged = true;
        super.setRigidStructure(!super.getRigidStructure());
        
    }


}
