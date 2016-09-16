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

}
