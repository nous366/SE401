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
    void update(float temperature, float humidity);
}

// Concrete Subject class
class WeatherData implements Subject {
    private List<Observer> observers;
    private float temperature;
    private float humidity;

    public WeatherData() {
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
            observer.update(temperature, humidity);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        measurementsChanged();
    }
}

// Concrete Observer class for Phone Display
class PhoneDisplay implements Observer {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public PhoneDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Phone Display: Temperature is " + temperature + "°C and Humidity is " + humidity + "%");
    }
}

// Concrete Observer class for Dashboard Display
class DashboardDisplay implements Observer {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public DashboardDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Dashboard Display: Temperature is " + temperature + "°C and Humidity is " + humidity + "%");
    }
}

// Main class to demonstrate the Observer Pattern
public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        PhoneDisplay phoneDisplay = new PhoneDisplay(weatherData);
        DashboardDisplay dashboardDisplay = new DashboardDisplay(weatherData);

        weatherData.setMeasurements(25, 60);
        weatherData.setMeasurements(30, 65);
    }
}
