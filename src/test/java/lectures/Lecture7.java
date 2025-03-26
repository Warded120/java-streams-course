package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  @Test
  public void count() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();

    long femalesCount = people.stream()
            .filter(person -> person.getGender().equalsIgnoreCase("female"))
            .count();

    System.out.println(femalesCount);
  }

  @Test
  public void min() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    double yellowMinPrice = cars.stream()
            .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
            .mapToDouble(Car::getPrice)
            .min()
            .getAsDouble();

    System.out.println(yellowMinPrice);
  }

  @Test
  public void max() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    double yellowMaxPrice = cars.stream()
            .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
            .mapToDouble(Car::getPrice)
            .max()
            .getAsDouble();

    System.out.println(yellowMaxPrice);
  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();

    double avCarPrice = cars.stream()
            .mapToDouble(Car::getPrice)
            .average()
            .orElseThrow(() -> new RuntimeException("No cars found"));

    System.out.println(avCarPrice);
  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();

    double sum = cars.stream()
            .mapToDouble(Car::getPrice)
            .sum();

    System.out.println(sum);

  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics statistics = cars.stream()
        .mapToDouble(Car::getPrice)
        .summaryStatistics();
    System.out.println(statistics);
    System.out.println(statistics.getAverage());
    System.out.println(statistics.getCount());
    System.out.println(statistics.getMax());
    System.out.println(statistics.getMin());
    System.out.println(statistics.getSum());
  }

}