import java.util.ArrayList;
import java.util.List;

// Subject interface
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Observer interface
interface Observer {
    void update(String stockName, float price);
}

// Concrete Subject class
class StockData implements Subject {
    private List<Observer> observers;
    private String stockName;
    private float price;

    public StockData(String stockName) {
        this.stockName = stockName;
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }

    public void setPrice(float price) {
        this.price = price;
        notifyObservers();
    }
}

// Concrete Observer class for an Investor
class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, float price) {
        System.out.println("Investor " + name + " notified. " +
                           "Stock: " + stockName + " is now " + price);
    }
}

// Main class to demonstrate the Observer Pattern
public class Main {
    public static void main(String[] args) {
        StockData googleStock = new StockData("GOOGL");

        Investor investor1 = new Investor("Alice");
        Investor investor2 = new Investor("Bob");

        googleStock.registerObserver(investor1);
        googleStock.registerObserver(investor2);

        googleStock.setPrice(1345.67f);
        googleStock.setPrice(1370.23f);

        googleStock.removeObserver(investor1);

        googleStock.setPrice(1400.12f);
    }
}
