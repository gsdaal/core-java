package collections.streams;

import model.Person;
import model.PersonService;

import java.util.List;
import java.util.stream.Stream;

import static java.lang.System.out;

public class AggregateOperations {

    public static void main(String[] args) {
        List<Person> personStream = PersonService.personData();
        printsNameAll(personStream.stream());
        printsFemaleNames(personStream.stream());
        printAverageAgeMales(personStream.stream());
    }

    private static void printsNameAll(Stream<Person> personStream) {
        personStream
                .map(Person::getName)
                .forEach(out::println);
    }

    private static void printsFemaleNames(Stream<Person> personStream) {
        personStream
                .filter(p -> p.getGender() == Person.Sex.FEMALE)
                .map(Person::getName)
                .forEach(out::println);
    }

    private static void printAverageAgeMales(Stream<Person> personStream) {
        personStream
                .mapToInt(Person::getAge)
                .average()
                .ifPresentOrElse(out::println,
                        () -> out.println("No data"));
    }

}
