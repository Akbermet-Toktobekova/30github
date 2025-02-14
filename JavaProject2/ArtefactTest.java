// // package environment.collectables;

// // import static org.junit.jupiter.api.Assertions.assertEquals;

// // import org.junit.jupiter.api.*;
// // import org.junit.jupiter.api.condition.*;
// // import org.junit.jupiter.params.ParameterizedTest;
// // import org.junit.jupiter.params.provider.CsvSource;

// // import environment.marker.Color;

// // import org.junit.jupiter.api.MethodOrderer.*;

// // public class ArtefactTest {
// //     @Test
// //     void testSampleConstructor(){

// //     }

// //     @Test
// //     void testRetrieve(){
// //         Sample sample = new Sample("ABC", Color.RED);
// //         assertEquals(null, sample.retrieve().getLocationData());
// //         Sample sample1 = new Sample("ABC", Color.RED);
// //         sample1.tag();
// //         assertEquals("ABC#NO", sample1.retrieve().getLocationData());
// //         Sample sample2 = new Sample("ABClocat", Color.RED);
// //         sample2.tag();
// //         assertEquals("ABClocat#OK", sample2.retrieve().getLocationData());

// //     }

// //     @Test
// //     void testTag(){
// //         Sample sample = new Sample("ABC", Color.RED);
// //         assertEquals(false, sample.getRigidStructure());
        
// //         sample.tag();

// //         assertEquals(true, sample.getRigidStructure());

// //         sample.tag();

// //         assertEquals(false, sample.getRigidStructure());

// //     }
// //     @Test
// //     void testText(){
// //         Sample sample = new Sample("RX-721", Color.BLUE);
// //         assertEquals("LocationData: RX-721, Color: BLUE, isRigid: false", sample.toString());
       
// //     }

// //     @Test
// //     void testSampleEquals(){
// //         Sample sample = new Sample("ABC", Color.RED);
// //         Sample sample1 = new Sample("ABC", Color.RED);
      
// //         assertEquals(true, sample1.equals(sample));
// //         assertEquals(true, sample.hashCode() == sample1.hashCode());
// //     }
// // }

// package environment.collectables;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.params.ParameterizedTest;
// import org.junit.jupiter.params.provider.CsvSource;

// import environment.marker.Color;

// public class ArtefactTest {
    
//     @Test
//     void testSampleConstructor() {
//         // Add meaningful assertions
//     }

//     @Test
//     void testRetrieve() {
//         Sample sample = new Sample("ABC", Color.RED);
//         assertEquals(null, sample.retrieve().getLocationData());

//         Sample sample1 = new Sample("ABC", Color.RED);
//         sample1.tag();
//         assertEquals("ABC#NO", sample1.retrieve().getLocationData());

//         Sample sample2 = new Sample("ABClocat", Color.RED);
//         sample2.tag();
//         assertEquals("ABClocat#OK", sample2.retrieve().getLocationData());
//     }

//     @Test
//     void testTag() {
//         Sample sample = new Sample("ABC", Color.RED);
//         assertEquals(false, sample.getRigidStructure());

//         sample.tag();
//         assertEquals(true, sample.getRigidStructure());

//         sample.tag();
//         assertEquals(false, sample.getRigidStructure());
//     }

//     @Test
//     void testText() {
//         Sample sample = new Sample("RX-721", Color.BLUE);
//         assertEquals("LocationData: RX-721, Color: BLUE, isRigid: false", sample.toString());
//     }

//     @Test
//     void testSampleEquals() {
//         Sample sample = new Sample("ABC", Color.RED);
//         Sample sample1 = new Sample("ABC", Color.RED);

//         assertEquals(true, sample1.equals(sample));
//         assertEquals(true, sample.hashCode() == sample1.hashCode());
//     }
// }



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import environment.collectables.Sample;
import environment.marker.Color;

public class ArtefactTest {

    @Test
    public void testSampleConstructor() {
        // Add meaningful assertions
    }

    @Test
    public void testRetrieve() {
        Sample sample = new Sample("ABC", Color.RED);
        assertEquals(null, sample.retrieve().getLocationData());

        Sample sample1 = new Sample("ABC", Color.RED);
        sample1.tag();
        assertEquals("ABC#NO", sample1.retrieve().getLocationData());

        Sample sample2 = new Sample("ABClocat", Color.RED);
        sample2.tag();
        assertEquals("ABClocat#OK", sample2.retrieve().getLocationData());
    }

    @Test
    public void testTag() {
        Sample sample = new Sample("ABC", Color.RED);
        assertEquals(false, sample.getRigidStructure());

        sample.tag();
        assertEquals(true, sample.getRigidStructure());

        sample.tag();
        assertEquals(false, sample.getRigidStructure());
    }

    @Test
    public void testText() {
        Sample sample = new Sample("RX-721", Color.BLUE);
        assertEquals("LocationData: RX-721, Color: BLUE, isRigid: false", sample.toString());
    }

    @Test
    public void testSampleEquals() {
        Sample sample = new Sample("ABC", Color.RED);
        Sample sample1 = new Sample("ABC", Color.RED);

        assertEquals(true, sample1.equals(sample));
        assertEquals(true, sample.hashCode() == sample1.hashCode());
    }

    @ParameterizedTest
    @CsvSource({
        "ABC, RED, ABC#NO",
        
    })
    public void testRetrieveParameterized(String locationData, Color color, String expected) {
        Sample sample = new Sample(locationData, color);
        sample.tag();
        assertEquals(expected, sample.retrieve().getLocationData());
    }
}
