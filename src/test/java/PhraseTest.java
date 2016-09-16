import org.junit.*;
import static org.junit.Assert.*;

public class PhraseTest {

  @After
  public void tearDown() {
    Phrase.clear();
  }

  @Test
  public void Phrase_initiatesCorrectly_true() {
    Phrase myPhrase = new Phrase("Bolo");
    assertEquals(true, myPhrase instanceof Phrase);
  }

  @Test
  public void Phrase_getPhrase_phrase() {
    Phrase myPhrase = new Phrase("Bolo");
    assertEquals("Bolo", myPhrase.getPhrase());
  }

  @Test
  public void Phrase_getId_0() {
    Phrase myPhrase = new Phrase("Bolo");
    assertEquals(0, myPhrase.getId());
  }

  @Test
  public void Phrase_allInstancesOfPhrase_true() {
    Phrase phrase1 = new Phrase ("Bolo");
    Phrase phrase2 = new Phrase ("Cannibalize");
    assertEquals(true, Phrase.all().contains(phrase1));
    assertEquals(true, Phrase.all().contains(phrase2));
  }

  @Test
  public void Phrase_returnPhraseWithCorrectID_phrase2() {
    Phrase phrase1 = new Phrase ("Bolo");
    Phrase phrase2 = new Phrase ("Cannibalize");
    assertEquals(Phrase.find(phrase2.getId()), phrase2);
  }

  // @Test
  // public void Definition_addDefinitionToList_true() {
  //   Phrase phrase = new Phrase("Bolo");
  //   Definition definition = new Definition("Soldier who fails weapons qual");
  //   List<Object> expected = new ArrayList<Object>();
  //   expected.add(definition);
  //   Phrase.addDefinition(definition);
  //   assertEquals(expected, Phrase.getDefinition());
  // }
}
