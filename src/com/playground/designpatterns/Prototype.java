package com.playground.designpatterns;

/**
 * Type: Creational
 * Prototype
 *
 * Note: We can simply have base class & child class relationship
 */
public class Prototype {

    interface Person {
        Person clone();

        default void greet() {
            System.out.println("Hello!");
        }
    }

    public static class Sameer implements Person {

        public String fName = "Mohammed";
        public String lName = "Sameer";

        @Override
        public Person clone() {
            return new Sameer();
        }
    }

    public static class Samrah implements Person {

        public String fName = "Samrah";
        public String lName = "Sameer";

        @Override
        public Person clone() {
            return new Samrah();
        }
    }

    public static void main(String[] args) {
        Samrah samrah = new Samrah();
        samrah.clone();
        samrah.clone();

        Sameer sameer = new Sameer();
        sameer.clone();
        sameer.clone();
    }
}
