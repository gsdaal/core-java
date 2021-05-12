package collections.streams;

import collections.streams.model.Person;
import collections.streams.model.PersonService;

import java.util.List;
import java.util.stream.Stream;

import static java.lang.System.out;
import static collections.streams.model.Person.Sex.MALE;

public class AggregateOperations {

    public static void main(String[] args) {
        var personStream = PersonService.personData();
        printsNameAll(personStream.stream());
        printsFemaleNames(personStream.stream());
        printAverageAgeMales(personStream.stream());
        printSumAgeMales(personStream.stream());
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
                .filter(p -> p.getGender() == MALE)
                .mapToInt(Person::getAge)
                .average()
                .ifPresentOrElse(out::println,
                        () -> out.println("No data"));
    }

    private static void printSumAgeMales(Stream<Person> stream) {
        var sum = stream
                .filter(p -> p.getGender() == MALE)
                .mapToDouble(Person::getAge)
                .sum();
        out.println(sum);
    }

}
