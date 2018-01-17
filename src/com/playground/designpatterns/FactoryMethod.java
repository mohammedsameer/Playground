package com.playground.designpatterns;

/**
 * Type: Creational
 * Factory Method, abstract away the object creation from client into a factory class containing factory method
 */
public class FactoryMethod {

    static abstract class Plan {
        abstract int getRate();

        public int calculateBill(int unit) {
            return unit * getRate();
        }
    }

    //Concrete implementation of Plan
    static class DomesticPlan extends Plan {
        private String name = "Domestic";

        public int getRate() {
            return 1;
        }

    }

    //Concrete implementation of Plan
    static class InternationalPlan extends Plan {
        private String name = "International";

        public int getRate() {
            return 2;
        }
    }

    //Plan factory responsible for plan creation
    static class PlanFactory {
        public static Plan getPlan(String name) {
            if(name.equals("Domestic"))
                return new DomesticPlan();
            else
                return new InternationalPlan();
        }
    }

    //Demo
    public static void main(String[] args) {

        Plan plan = PlanFactory.getPlan("Domestic");
        int bill = plan.calculateBill(10);
        System.out.println("Your bill is: " + bill);
    }

}
