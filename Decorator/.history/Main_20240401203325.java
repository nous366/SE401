import java.util.Scanner;

interface Coffee {
    String getDescription();
    double getCost();
}


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
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Coffee myCoffee = new SimpleCoffee();
        System.out.println("Starting with: " + myCoffee.getDescription() + " Cost: $" + myCoffee.getCost());
        
        boolean addingIngredients = true;
        
        while (addingIngredients) {
            System.out.println("Would you like to add Milk, Sugar, or Stop? (M/S/Stop)");
            String input = scanner.nextLine();
            
            switch (input.toLowerCase()) {
                case "m":
                    myCoffee = new Milk(myCoffee);
                    System.out.println("Added: Milk -> " + myCoffee.getDescription() + " Cost: $" + myCoffee.getCost());
                    break;
                case "s":
                    myCoffee = new Sugar(myCoffee);
                    System.out.println("Added: Sugar -> " + myCoffee.getDescription() + " Cost: $" + myCoffee.getCost());
                    break;
                case "stop":
                    addingIngredients = false;
                    break;
                default:
                    System.out.println("Invalid choice, please select M for Milk, S for Sugar, or type Stop to finish.");
                    break;
            }
        }
        
        System.out.println("Your final coffee: " + myCoffee.getDescription() + " Cost: $" + myCoffee.getCost());
    }
}
