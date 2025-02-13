package marketplace.droids;


import marketplace.droids.custom.RepairDroid;
import marketplace.droids.custom.TranslatorDroid;

//import static org.api.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.MethodOrderer.*;


public class CustomDroidTest {

    @ParameterizedTest
    @CsvSource({
        "0, 0, 0", 
        "100, 50, 00", 
        "100, 100, 0"
    })
    void testRepairDroidRepair(int initialDamage, int repairAmount, int expectedDamage) {
        DroidPart part = new DroidPart(100, initialDamage, DroidPartTypes.DROID_ARM );
        RepairDroid repairDroid = new RepairDroid(new ArrayList<>(), repairAmount);

        repairDroid.repairPart(part);

        assertEquals(expectedDamage, part.getDamage());
    }

    @Test
    void testTranslatorDroidTranslate() {
        TranslatorDroid translatorDroid = new TranslatorDroid(new ArrayList<>());
        String input = "Hello";
        String expectedOutput = "Ifmmp";
        String actualOutput = translatorDroid.translate(input, "binary");
        assertEquals(expectedOutput, actualOutput);
    }


}
