package marketplace.droids.custom;

import java.util.List;
import marketplace.droids.Droid;
import marketplace.droids.DroidPart;

public class TranslatorDroid extends Droid{
    public TranslatorDroid( List<DroidPart> parts){
        super(parts);   // constuctor of the child is the same as the parent's
    }

    public String translate( String s, String language){
        String newText = "";
        if (powerLevel<5){
            return "Not enough power";
        }
        if ( language.equals("huttese") ){      /// remember!!!
            newText = shiftCharacters(s, 3);  
            powerLevel -= 5;
        }else if ( language.equals("binary")){
            newText = shiftCharacters(s, 1);
            powerLevel -= 5;
        }

        else{
            newText = "Unknown language";
        }

        return newText;
    }

    private String shiftCharacters(String str, int shift){
        String output="";
        for (int i = 0; i < str.length(); i++) {
            int newNum = (int) str.charAt(i) + shift;
            output += (char) newNum;

        }
        return output;
    }
    
    @Override
    public String toString(){
        String result = runDiagnostics();
        result = "TranslatorDroid"+"\n" + result + "Power Level: " + powerLevel + "%" + "\n"+ "Languages: huttese, binary";
        return result;
    }
}