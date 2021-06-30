package collections.streams.model;

import java.time.LocalDate;
import java.util.List;

public class PersonService {

  private PersonService() {
  }

  public static List<Person> personData() {
    return List.of(
        new Person(
            "Alpha",
            LocalDate.of(1980, 1, 1),
            Person.Sex.FEMALE,
            "a@aa.com"),
        new Person(
            "Beta",
            LocalDate.of(1981, 1, 1),
            Person.Sex.MALE,
            "b@aa.com"),
        new Person(
            "Gamma",
            LocalDate.of(1982, 1, 1),
            Person.Sex.FEMALE,
            "c@aa.com"),
        new Person(
            "Lemma",
            LocalDate.of(1983, 1, 1),
            Person.Sex.MALE,
            "l@aa.com"),
        new Person(
            "Phi",
            LocalDate.of(1980, 1, 1),
            Person.Sex.FEMALE,
            "p@aa.com")
    );
  }
}
