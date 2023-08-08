package assignment_3;


/**
 * Creating a Pizza using the Builder Pattern
 *
 * The Builder pattern is a creational design pattern that allows the step-by-step construction
 * of complex objects by separating the construction from its representation. In this example, we
 * demonstrate how to create a pizza using the Builder pattern with some variations on the toppings.
 *
 * 1. Pizza Class:
 *    - The `Pizza` class represents the final pizza with attributes like size, cheese, pepperoni,
 *      mushrooms, onions, olives, and bacon, indicating the presence of various toppings.
 *    - It provides methods like `hasCheese()`, `hasPepperoni()`, etc., to check the presence of specific toppings.
 *    - The `toString()` method is overridden to provide a human-readable representation of the pizza's details.
 *
 * 2. PizzaBuilder Class:
 *    - The `PizzaBuilder` class is responsible for constructing the pizza step by step.
 *    - It initializes with the pizza's size and default values for all toppings (set to false).
 *    - The class provides methods like `addCheese()`, `addPepperoni()`, etc., to set the corresponding toppings to true.
 *    - Each method returns `this`, enabling method chaining for a fluent and expressive way to build the pizza.
 *    - The `build()` method creates the `Pizza` object by passing itself (`this`) to the `Pizza` constructor.
 *
 * 3. Usage:
 *    - In the `main` method, we demonstrate the construction of a pizza using the `PizzaBuilder` class.
 *    - We start by specifying the pizza's size (e.g., "large").
 *    - Then, we chain the `addCheese()`, `addPepperoni()`, etc., methods to select the desired toppings for the pizza.
 *    - Finally, we call the `build()` method to get the final `Pizza` object.
 *    - The `toString()` method of the `Pizza` class provides a human-readable representation of the pizza's details,
 *      including its size and the selected toppings.
 *
 * Using the Builder pattern allows us to create a pizza with different combinations of toppings in a clear and maintainable way.
 */



class Pizza {
    private final String size;
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean mushrooms;
    private final boolean onions;
    private final boolean olives;
    private final boolean bacon;

    public Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
        this.onions = builder.onions;
        this.olives = builder.olives;
        this.bacon = builder.bacon;
    }

    public String getSize() {
        return size;
    }

    public boolean hasCheese() {
        return cheese;
    }

    public boolean hasPepperoni() {
        return pepperoni;
    }

    public boolean hasMushrooms() {
        return mushrooms;
    }

    public boolean hasOnions() {
        return onions;
    }

    public boolean hasOlives() {
        return olives;
    }

    public boolean hasBacon() {
        return bacon;
    }

    @Override
    public String toString() {
        StringBuilder toppings = new StringBuilder();
        if (cheese) toppings.append("Cheese, ");
        if (pepperoni) toppings.append("Pepperoni, ");
        if (mushrooms) toppings.append("Mushrooms, ");
        if (onions) toppings.append("Onions, ");
        if (olives) toppings.append("Olives, ");
        if (bacon) toppings.append("Bacon, ");

        if (!toppings.isEmpty()) {
            toppings.setLength(toppings.length() - 2); // Remove the last comma and space
        }

        return "Size: " + size + ", Toppings: " + toppings.toString();
    }

    public static class PizzaBuilder {
        private final String size;
        private boolean cheese;
        private boolean pepperoni;
        private boolean mushrooms;
        private boolean onions;
        private boolean olives;
        private boolean bacon;

        public PizzaBuilder(String size) {
            this.size = size;
        }

        public PizzaBuilder addCheese() {
            cheese = true;
            return this;
        }

        public PizzaBuilder addPepperoni() {
            pepperoni = true;
            return this;
        }

        public PizzaBuilder addMushrooms() {
            mushrooms = true;
            return this;
        }

        public PizzaBuilder addOnions() {
            onions = true;
            return this;
        }

        public PizzaBuilder addOlives() {
            olives = true;
            return this;
        }

        public PizzaBuilder addBacon() {
            bacon = true;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    public static void main(String[] args) {
        // Creating a pizza using the Builder pattern
        Pizza pizza = new PizzaBuilder("large")
                .addCheese()
                .addPepperoni()
                .addOnions()
                .addOlives()
                .build();

        System.out.println("Pizza details:");
        System.out.println(pizza);
    }
}
