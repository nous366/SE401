interface Coffee {
    String getDescription();
    double getCost();
}

// Concrete Component
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;
    
    public CoffeeDecorator(Coffee c) {
        this.decoratedCoffee = c;
    }

    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// Concrete Decorator
class Milk extends CoffeeDecorator {
    public Milk(Coffee c) {
        super(c);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }
}

// Another Concrete Decorator
class Sugar extends CoffeeDecorator {
    public Sugar(Coffee c) {
        super(c);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.3;
    }
}

// Demo class to test the Decorator pattern
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Coffee myCoffee = new SimpleCoffee();
        System.out.println(myCoffee.getDescription() + " Cost: $" + myCoffee.getCost());

        Coffee milkCoffee = new Milk(myCoffee);
        System.out.println(milkCoffee.getDescription() + " Cost: $" + milkCoffee.getCost());

        Coffee sugarMilkCoffee = new Sugar(milkCoffee);
        System.out.println(sugarMilkCoffee.getDescription() + " Cost: $" + sugarMilkCoffee.getCost());
    }
}
