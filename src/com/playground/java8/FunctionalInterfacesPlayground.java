package com.playground.java8;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java 8 FunctionalInterfaces playground
 */
public class FunctionalInterfacesPlayground {

    static Predicate<String> isNonEmpty = (s) -> !s.isEmpty();
    static Function<Integer, String> convertIntToString = String::valueOf;
    static Supplier<Person> personSupplier = Person::new;
    static Consumer<Person> personConsumer = (p) -> System.out.println("Hello "+ p.fName + " " + p.lName);
    static Comparator<Person> personComparator = (p1, p2) -> p1.fName.length() > p2.fName.length() ? 1: 0;

    static class Person {
        String fName;
        String lName;

        public Person() {
            this.fName = "Unknown";
            this.lName = "Unknown";
        }

        public Person(String fName, String lName) {
            this.fName = fName;
            this.lName = lName;
        }
    }

    public static void main(String[] args) {
        /******** Predicate *******/
        System.out.println("Predicate: "+ isNonEmpty.test("Sameer"));

        /******** Function ********/
        System.out.println("Function: "+ convertIntToString.apply(10));

        /******** Supplier ********/
        Person person = personSupplier.get();
        System.out.println("Supplied person " + person.fName + "," + person.lName);

        /******** Consumer ********/
        personConsumer.accept(person);

        /******** Comparator ******/
        Person person1 = new Person("Mohammed", "Sameer");
        Person person2 = new Person("Samrah", "Sameer");
        System.out.println(personComparator.compare(person1, person2));

        /******** Optional ********/
        Optional<Person> personOptional = Optional.of(person1);
        personOptional.ifPresent(personConsumer);
    }
}
