import java.util.ArrayList;
import java.util.List;

public class Definition {
  private String mDefinition;
  private static List<Definition> instances = new ArrayList<Definition>();
  private int mId;

  public Definition(String definition) {
    mDefinition = definition;
    mId = instances.size();
    instances.add(this);
  }

  public String getDefinition() {
    return mDefinition;
  }

  public int getId() {
    return mId;
  }

  public static List<Definition> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

}
