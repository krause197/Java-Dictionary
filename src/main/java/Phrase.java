import java.util.List;
import java.util.ArrayList;

public class Phrase {
  private String mPhrase;
  private static List<Phrase> instances = new ArrayList<Phrase>();
  private int mId;
  private List<Definition> mDefinition = new ArrayList<Definition>();

  public Phrase(String phrase) {
    mPhrase = phrase;
    mId = instances.size();
    instances.add(this);
  }

  public static void clear() {
    instances.clear();
  }

  public String getPhrase() {
    return mPhrase;
  }

  public int getId() {
    return mId;
  }

  public List<Definition> getDefinition() {
    return mDefinition;
  }

  public static List<Phrase> all() {
    return instances;
  }

  public static Phrase find(int id) {
    try {
      return instances.get(id);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public void addDefinition(Definition definition) {
    mDefinition.add(definition);
  }
}
