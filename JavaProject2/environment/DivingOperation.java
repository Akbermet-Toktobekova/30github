package environment;
import environment.collectables.Artefact;
import environment.marker.Color;
import java.util.*;
import person.Dumper;
import person.divers.*;
import person.util.InvalidOperation;

public class DivingOperation {
    public final ArrayList<Diver> teams;
    public final ArrayList<Artefact> allArtefacts;

    public DivingOperation(int totalTeams){
        this.teams = new ArrayList<>();
        this.allArtefacts = new ArrayList<>();
        Color currentColor = Color.GREEN;
        if(totalTeams % 3 != 0){
            throw new IllegalArgumentException();
        }
        else{
            for (int i = 0; i < totalTeams; i++) {
                teams.add(new Diver("T" + (i + 1 ), currentColor));

                if (currentColor == Color.GREEN) {
                    currentColor = Color.BLUE;
                } else if (currentColor == Color.BLUE) {
                    currentColor =  Color.RED;
                } else {
                    currentColor = Color.GREEN;
                }
            }
            
        }
        


    }
//vararg - is an array internally
    private void registerArtefacts( Artefact... artefact){
        for (Artefact ar : artefact) {
            if(ar.getColor()==Color.GREEN){
                allArtefacts.add(ar);     
            }
        }
    }

    private void registerArtefact(Artefact artefact){
        if(allArtefacts.contains(artefact) == false){
            allArtefacts.add(artefact);
        }
  
    }

    public void prepareOperation(int n) throws InvalidOperation{
        ArrayList<Artefact> qq = Dumper.dumpArtefacts(n); 
        if(qq.getFirst().getColor()==Color.GREEN){

        }else if(qq.get(2).getColor()==Color.GREEN){

        }else if(qq.get(qq.size()/2 - 1).getColor()==Color.GREEN){

        }else if(qq.getLast().getColor()==Color.GREEN){

        }else{
            throw new InvalidOperation();
        }
        
        registerArtefacts(qq.toArray(new Artefact[0]));
    
    }

    public HashSet<Artefact> conductOperation(){
        HashSet<Artefact> result  = new HashSet<>();
        for (Diver diver : teams) {
            for (Artefact ar : allArtefacts)
            {
                diver.tryToGetArtefact(ar);
            }

            for (Artefact successArt : diver.getArtefacts()) {
                result.add(successArt);
            }
            
        }
        return result;

    }

    


}
