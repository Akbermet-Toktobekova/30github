package marketplace.droids;


import marketplace.droids.custom.RepairDroid;
import marketplace.droids.custom.TranslatorDroid;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.MethodOrderer.*;
//import org.junit.jupiter.api.Assertions.*;



// no args, void + name
// List is abstract and doesnt't have a constructor
public class DroidTest {
    @Test
    void testDroidConstructor(){

        List<DroidPart> parts = new ArrayList<>();
        Droid dr = new Droid(parts);
        Assertions.assertEquals(100, dr.getPowerLevel());
    }

    @Test 
    void testDroidCharge(){
        List<DroidPart> parts = new ArrayList<>();
        Droid dr = new Droid(parts);
        // powerL = 50 - ex

        dr.charge(65);

        Assertions.assertEquals(100, dr.getPowerLevel());
    }

    @Test 
    void testDroidReducePower(){
        List<DroidPart> parts = new ArrayList<>();
        Droid dr = new Droid(parts);
        // powerL = 100

        dr.reducePower(165);

        Assertions.assertEquals(0, dr.getPowerLevel());
    }

    // @ParameterizedTest
    // void testRepairDroidRepair(){

    // }


}
