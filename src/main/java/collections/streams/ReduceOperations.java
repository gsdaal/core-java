package collections.streams;

import static collections.streams.model.Person.Sex.MALE;
import static java.lang.System.out;

import collections.streams.model.Person;
import collections.streams.model.PersonService;
import java.util.List;
import java.util.stream.Stream;

public class ReduceOperations {

  public static void main(String[] args) {
    List<Person> personStream = PersonService.personData();
    printSumAgeMalesUsingReduce(personStream.stream());
  }

  private static void printSumAgeMalesUsingReduce(Stream<Person> stream) {
    var sum = stream
        .filter(p -> p.getGender() == MALE)
        .map(Person::getAge)
        .reduce(0,    // identity
            Integer::sum); // accumulator
    out.println(sum);
  }

}
