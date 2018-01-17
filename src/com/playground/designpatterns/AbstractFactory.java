package com.playground.designpatterns;

/**
 * Type: Creational
 * Abstract Factory Method, extends Factory pattern with additional layer of encapsulation around factory
 */
public class AbstractFactory {

    enum Type {
        INFANT, TODDLER, CHILD
    }

    static abstract class Toy {
        String color = "Unknown";
        String name = "Unknown";
        abstract public void makeToy();
    }

    static class Duck extends Toy {

        @Override
        public void makeToy() {
            color = "Yellow";
            name = "Duck";
            System.out.println("Make duck of color " + color);
        }
    }

    static class Bus extends Toy {

        @Override
        public void makeToy() {
            color = "Red";
            name = "Bus";
            System.out.println("Make bus of color " + color);
        }
    }

    static class Rings extends Toy {

        @Override
        public void makeToy() {
            color = "Rainbow";
            name = "Rings";
            System.out.println("Make rings of color " + color);
        }
    }

    static class InfantToyFactory {
        //Only one infant toy for now
        static Toy toy;
        public static Toy getInfantToy(String color) {
            switch (color) {
                case "Rainbow": toy = new Rings(); break;
                default: toy = null; break;
            }

            return toy;
        }
    }

    static class ToddlerToyFactory {
        //Only one infant toy for now
        static Toy toy;
        public static Toy getToddlerToy(String color) {
            switch (color) {
                case "Yellow": toy = new Duck(); break;
                default: toy = null; break;
            }

            return toy;
        }
    }

    static class ChildToyFactory {
        //Only one child toy for now
        static Toy toy;
        public static Toy getChildToy(String color) {
            switch (color) {
                case "Red": toy = new Bus(); break;
                default: toy = null; break;
            }

            return toy;
        }
    }

    //Super Factory
    static class ToyFactory {
        public static Toy getToy(String color, Type type) {
            Toy toy = null;
            switch (type) {
                case INFANT: toy = InfantToyFactory.getInfantToy(color); break;
                case TODDLER: toy = ToddlerToyFactory.getToddlerToy(color); break;
                case CHILD: toy = ChildToyFactory.getChildToy(color); break;
                default: break;
            }

            return toy;
        }
    }

    //Demo
    public static void main(String[] args) {
        Toy toy = ToyFactory.getToy("Rainbow", Type.INFANT);
        System.out.println("I have a toy named" + toy.name);
    }
}
