package lectures;


import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

public class Lecture10 {

  private static final List<ArrayList<String>> arrayListOfNames = Lists.newArrayList(
      Lists.newArrayList("Mariam", "Alex", "Ismail"),
      Lists.newArrayList("John", "Alesha", "Andre"),
      Lists.newArrayList("Susy", "Ali")
  );

  @Before
  public void setUp() {
    System.out.println(arrayListOfNames);
  }

  @Test
  public void withoutFlatMap() throws Exception {
//  [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
    ArrayList<String> reduced = arrayListOfNames.stream()
            .reduce(new ArrayList<>(), (l1, l2) -> {
              l1.addAll(l2);
              return l1;
            });
    System.out.println(reduced);
  }


  @Test
  public void withFlatMap() throws Exception {
    List<String> flatList = arrayListOfNames.stream()
            .flatMap(List::stream)
            .toList();

    System.out.println(flatList);
  }
}

