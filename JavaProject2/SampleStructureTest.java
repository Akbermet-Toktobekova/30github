import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.MethodOrderer.*;
import check.*;

@TestMethodOrder(OrderAnnotation.class)
public class SampleStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("environment.collectables.Sample", withParent("environment.collectables.Artefact"))
                 .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
                 ;
    }

    @Test @DisabledIf(notApplicable) @Order(1_00)
    public void fieldTagged() {
        it.hasField("tagged: boolean")
          .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE);
    }

    @Test @DisabledIf(notApplicable) @Order(2_00)
    public void constructor01() {
        it.hasConstructor(withParams("locationData: String", "color: environment.marker.Color"))
          .thatIs(VISIBLE_TO_ALL)
          .thatCalls(theParent("with tagged"));
    }

    @Test @DisabledIf(notApplicable) @Order(3_00)
    public void methodExtendLocationData() {
        it.hasMethod("extendLocationData", withParams("locationData: String"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable) @Order(3_01)
    public void methodRetrieve() {
        it.hasMethod("retrieve", withNoParams())
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("environment.collectables.Sample");
    }

    @Test @DisabledIf(notApplicable) @Order(3_02)
    public void methodTag() {
        it.implementsMethod("tag");
    }

}
