package com.playground.designpatterns;

/**
 * Type: Creational
 * Builder: Separate construction from representation
 */
public class Builder {

    public static class Pizza {
        String doug = "";
        String sauce = "";
        String toppings = "";

        public void setDoug(String doug) {
            this.doug = doug;
        }

        public void setSauce(String sauce) {
            this.sauce = sauce;
        }

        public void setToppings(String toppings) {
            this.toppings = toppings;
        }

        public void showContents() {
            System.out.println(" I am made up of " + doug + " " + sauce + " " + toppings);
        }
    }

    //Construction
    abstract static class PizzaBuilder {
        Pizza pizza;

        abstract void buildDoug();
        abstract void buildSauce();
        abstract void buildToppings();

        Pizza makePizza() {
            return pizza;
        }
    }

    //Representation
    public static class CheesePizza extends PizzaBuilder {

        Pizza pizza;

        @Override
        public void buildDoug() {
            pizza.setDoug("Wheat");
        }

        @Override
        public void buildSauce() {
            pizza.setSauce("Mild");
        }

        @Override
        public void buildToppings() {
            pizza.setToppings("Cheese");
        }
    }

    //Representation
    public static class ChickenPizza extends PizzaBuilder {

        Pizza pizza;

        @Override
        public void buildDoug() {
            pizza.setDoug("Wheat");
        }

        @Override
        public void buildSauce() {
            pizza.setSauce("Hot");
        }

        @Override
        public void buildToppings() {
            pizza.setToppings("Chicken");
        }
    }

    public static class Waiter {
        PizzaBuilder pizzaBuilder;

        public Pizza getPizza() {
            return pizzaBuilder.makePizza();
        }

        public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
            this.pizzaBuilder = pizzaBuilder;
        }
    }


    public static void main(String[] args) {
        CheesePizza cheesePizzaBuilder = new CheesePizza();
        ChickenPizza chickenPizzaBuilder = new ChickenPizza();

        //Get cheese pizza
        Waiter waiter = new Waiter();
        waiter.setPizzaBuilder(cheesePizzaBuilder);

        Pizza pizza = waiter.getPizza();
        pizza.showContents();

        //Get chicken pizza
        waiter.setPizzaBuilder(chickenPizzaBuilder);

        pizza = waiter.getPizza();
        pizza.showContents();
    }
}
