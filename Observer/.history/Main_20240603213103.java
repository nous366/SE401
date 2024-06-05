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
    void update(String orderStatus);
}

// Concrete Subject class
class Order implements Subject {
    private List<Observer> observers;
    private String orderStatus;

    public Order() {
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
            observer.update(orderStatus);
        }
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
        notifyObservers();
    }
}

// Concrete Observer class for a Customer
class Customer implements Observer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(String orderStatus) {
        System.out.println("Customer " + name + " notified. " +
                           "Order status: " + orderStatus);
    }
}

// Main class to demonstrate the Observer Pattern
public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng Order
        Order order = new Order();

        // Tạo các đối tượng Customer và đăng ký với Order
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        order.registerObserver(customer1);
        order.registerObserver(customer2);

        // Thay đổi trạng thái đơn hàng và thông báo cho các khách hàng
        System.out.println("Setting order status to 'Processing'");
        order.setOrderStatus("Processing");
        System.out.println();

        System.out.println("Setting order status to 'Shipped'");
        order.setOrderStatus("Shipped");
        System.out.println();

        
        System.out.println("Removing customer Alice from notification list");
        order.removeObserver(customer1);
        System.out.println();

        System.out.println("Setting order status to 'Delivered'");
        order.setOrderStatus("Delivered");
        System.out.println();

        
        Customer customer3 = new Customer("Charlie");
        System.out.println("Registering new customer Charlie");
        order.registerObserver(customer3);
        System.out.println();

        System.out.println("Setting order status to 'Completed'");
        order.setOrderStatus("Completed");
    }
}
