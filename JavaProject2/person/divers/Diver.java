package person.divers;
import environment.collectables.*;
import environment.marker.Color;
import java.util.ArrayList;
import person.util.*;

public class Diver{
    private final ArrayList<Artefact> artefacts ;
    private final String teamId;
    private final Color specialityColor; 

    public Diver( String teamId, Color color){
        this.teamId = teamId;
        this.specialityColor = color;
        this.artefacts = new ArrayList<>();
    }

    public Diver(){
        this.teamId = "T1";
        this.specialityColor= Color.RED;
        this.artefacts = new ArrayList<>();
    }

    public ArrayList<Artefact> getArtefacts(){
        ArrayList<Artefact> artefacts = new ArrayList<>(this.artefacts);
        return artefacts;
    }

    public Color getColor(){
        return this.specialityColor;
    }

    public String getTeamId(){
        return this.teamId;
    }

    public void tagArtefacts(ArrayList<Artefact> toTag){
        if(this.specialityColor == Color.GREEN){
            for (Artefact artefact : toTag) {
                artefact.tag();
            }
        }
        if(this.specialityColor == Color.RED){
            for (Artefact artefact : toTag) {
                if(artefact.getRigidStructure()== true)
                artefact.tag();
            }
        }
       
    }

    public boolean tryToGetArtefact(Artefact artefact){
        if(artefact.getColor()!=this.specialityColor){
            return false;
        }
        if(artefact.retrieve() == null){
            artefact.tag();
            return false;
        }
        artefacts.add(artefact);
        return true;
    }

    // --------- CUSTOM EXEPTION
    public void forceInsertArtefact(Artefact artefact) throws WrongArtefact {
        if(artefact.getColor()!=this.specialityColor){
            throw new WrongArtefact("Wrong Color");
        }
        if(artefact.retrieve() == null){
            artefact.tag();
            if(artefact.retrieve() == null){
                if(artefact.getLocationData().contains("#KO")){
                    throw new WrongArtefact("Got Waste");
                }
            }
        }

        artefacts.add(artefact);
       

    }

}
