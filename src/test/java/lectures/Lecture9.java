package lectures;


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Lecture9 {

  @Test
  public void reduce() throws Exception {
    Integer[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

    Integer reduced = Arrays.stream(integers).reduce(0, (a, b) -> a + b);
    System.out.println(reduced);
    //Arrays.stream(integers).reduce(0, Integer::sum); or like this
  }

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

