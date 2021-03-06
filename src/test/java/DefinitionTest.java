import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @After
  public void tearDown() {
    Definition.clear();
  }

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

  @Test
  public void Definition_getId_0() {
    Definition myDefinition = new Definition("Soldier who fails weapons qual");
    assertEquals(0, myDefinition.getId());
  }

  @Test
  public void Definition_allInstancesOfDefinition_true() {
    Definition definition1 = new Definition ("Soldier who fails weapons qual");
    Definition definition2 = new Definition ("Soldier who can not use rifle");
    assertEquals(true, Definition.all().contains(definition1));
    assertEquals(true, Definition.all().contains(definition2));
  }

}
