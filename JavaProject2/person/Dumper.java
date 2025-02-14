package person;

import environment.collectables.*;
import environment.marker.Color;
import java.util.ArrayList;

public class Dumper {

    public Dumper() {
    
    }

    public static ArrayList<Artefact> dumpArtefacts(int n) {
        ArrayList<Artefact> listOArtefacts = new ArrayList<>();
        boolean isWaste = true;
        Color currentColor = Color.GREEN;
        for (int i = 0; i < n; i++) {
            Artefact artefect;
            String location = String.format("%d-%s", 101+i, currentColor.toString().substring(0, 2));
            if (isWaste){
                artefect = new Waste(location, currentColor);
            }
            else{
                artefect = new Sample(location, currentColor);
            }

            if (currentColor == Color.GREEN) {
                currentColor = Color.BLUE;
            } else if (currentColor == Color.BLUE) {
                currentColor =  Color.RED;
            } else {
                currentColor = Color.GREEN;
            }
            isWaste = !isWaste;
            listOArtefacts.add(artefect);
        }
        return listOArtefacts;
    }
    
}
