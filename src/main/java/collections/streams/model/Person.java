package collections.streams.model;

import lombok.Value;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;

@Value
public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        return birthday
                .until(IsoChronology.INSTANCE.dateNow())
                .getYears();
    }
}
