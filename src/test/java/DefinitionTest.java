import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void Definition_initializescorrectly_true() {
    Definition myDefinition = new Definition("Soldier who fails weapons qual");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void Definition_getDefinition_definition() {
    Definition myDefinition = new Definition("Soldier who fails weapons qual");
    assertEquals("Soldier who fails weapons qual", myDefinition.getDefinition());
  }
}
