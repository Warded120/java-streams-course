package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < names.size()-1; i++) {
      builder.append(names.get(i));
      builder.append(",");
    }
    builder.append(names.get(names.size()-1));
    System.out.println(builder.toString());
  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String joined = names.stream().collect(Collectors.joining(","));
    System.out.println(joined);
  }
}
