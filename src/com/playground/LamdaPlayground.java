package com.playground;

/**
 * Java 8 LambdaPlayground
 */
public class LamdaPlayground {

    interface Formula {
        double calculate(int a);

        default double sqrt(int a) {
            return Math.sqrt(a);
        }
    }

    static class Person {
        String fName;
        String lName;

        Person(String fName, String lName) {
            this.fName = fName;
            this.lName = lName;
        }
    }

    static class ZeroFormula {
        static double zero(int num) {
            return 0;
        }
    }

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

    public static void main(String[] args) {
        /******** Interfaces *************/
        //Old style
        Formula oldFormula = new Formula() {
            @Override
            public double calculate(int num) {
                return num * 100;
            }
        };
        System.out.println("OldFormula: " + oldFormula.calculate(10));

        //New style
        Formula newFormula = (num) -> num * 100;
        System.out.println("NewFormula: " + newFormula.calculate(10));

        /******** Method References *************/
        //New style
        Formula newerFormula = ZeroFormula::zero;
        System.out.println("NewerFormula: " + newerFormula.calculate(10));

        /******** Constructor References ********/
        //Old style
        PersonFactory<Person> oldPersonFactory = new PersonFactory<Person>() {
            @Override
            public Person create(String firstName, String lastName) {
                Person person = new Person(firstName, lastName);
                return person;
            }
        };
        Person oldPerson = oldPersonFactory.create("Mohammed", "Sameer");
        System.out.print("Hello old person: " + oldPerson.fName + " " + oldPerson.lName);

        //New style
        PersonFactory<Person> newPersonFactory = Person::new;
        Person newPerson = newPersonFactory.create("Mohammed", "Sameer");
        System.out.print("Hello new person: " + newPerson.fName + " " + newPerson.lName);
    }
}
