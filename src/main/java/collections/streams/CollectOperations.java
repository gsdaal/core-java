package collections.streams;

import collections.streams.model.Person;
import collections.streams.model.PersonService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;
import static collections.streams.model.Person.Sex.MALE;

public class CollectOperations {

    public static void main(String[] args) {
        List<Person> personStream = PersonService.personData();
        printAgeMalesUsingCollect(personStream.stream());
        printGroupAgeMalesUsingCollect(personStream.stream());
        totalAgeByGender(personStream.stream());
        averageAgeByGender(personStream.stream());
    }

    private static void printAgeMalesUsingCollect(Stream<Person> stream) {
        stream
                .filter(p -> p.getGender() == MALE)
                .map(Person::getAge)
                .collect(Collectors.toList()) // Returns a Collector that accumulates the input elements into a new List.
                .forEach(out::println);
    }

    private static void printGroupAgeMalesUsingCollect(Stream<Person> stream) {
        Map<Person.Sex, List<Person>> collect = stream
                .collect(Collectors.groupingBy(Person::getGender));// Returns a Collector that accumulates the input elements into a new List.

        collect.forEach(
                (key, value) -> out.println(key.name() + ":" + value.size())
        );
    }

    private static void totalAgeByGender(Stream<Person> stream) {
        Map<Person.Sex, Integer> collect = stream
                .collect(
                        Collectors.groupingBy(
                                Person::getGender,
                                Collectors.reducing(
                                        0,
                                        Person::getAge,
                                        Integer::sum
                                )
                        )
                );
        collect.forEach((sex, totalAge) -> out.println(sex + ":" + totalAge));
    }

    private static void averageAgeByGender(Stream<Person> stream) {
        Map<Person.Sex, Double> collect = stream
                .collect(
                        Collectors.groupingBy(
                                Person::getGender,
                                Collectors.averagingInt(
                                        Person::getAge
                                )
                        )
                );
        collect.forEach((sex, averageAge) -> out.println(sex + ":" + averageAge));
    }
}
