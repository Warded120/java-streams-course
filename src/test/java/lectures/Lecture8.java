package lectures;


import beans.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class Lecture8 {

  @Test
  public void simpleGrouping() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    Map<String, List<Car>> collectedCars = cars.stream()
            .collect(Collectors.groupingBy(Car::getMake));

    collectedCars.forEach((make, makeCars) -> {
      System.out.println("------ " + make + " ------");
      makeCars.forEach(System.out::println);
    });
  }

  @Test
  public void groupingAndCounting() throws Exception {
    ArrayList<String> names = Lists
        .newArrayList(
            "John",
            "John",
            "Mariam",
            "Alex",
            "Mohammado",
            "Mohammado",
            "Vincent",
            "Alex",
            "Alex"
        );

    Map<String, Long> groupedNames = names.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    groupedNames.forEach((name, count) -> {
      System.out.println(name + ": " + count);
    });
  }

}