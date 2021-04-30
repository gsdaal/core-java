package collections.streams;

import model.Person;
import model.PersonService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;
import static model.Person.Sex.MALE;

public class CollectOperations {

    public static void main(String[] args) {
        List<Person> personStream = PersonService.personData();
        printSumAgeMalesUsingReduce(personStream.stream());
    }

    private static void printSumAgeMalesUsingReduce(Stream<Person> stream) {
        stream
                .filter(p -> p.getGender() == MALE)
                .map(Person::getAge)
                .collect(Collectors.toList()) // Returns a Collector that accumulates the input elements into a new List.
                .forEach(out::println);
    }

}
