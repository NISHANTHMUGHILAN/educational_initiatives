import java.util.ArrayList;
import java.util.List;

// Subject interface
interface WeatherSubject {
    void addObserver(WeatherObserver observer);
    void removeObserver(WeatherObserver observer);
    void notifyObservers();
}

// Observer interface
interface WeatherObserver {
    void update(float temperature, float humidity, float pressure);
}

// Concrete Subject
class WeatherStation implements WeatherSubject {
    private List<WeatherObserver> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }

    @Override
    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
}

// Concrete Observer
class WeatherDisplay implements WeatherObserver {
    private String name;

    public WeatherDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println(name + " received weather update: Temp=" + temperature + " Humidity=" + humidity + " Pressure=" + pressure);
    }
}

// Main class to test the pattern
public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        WeatherDisplay display1 = new WeatherDisplay("Display 1");
        WeatherDisplay display2 = new WeatherDisplay("Display 2");

        station.addObserver(display1);
        station.addObserver(display2);

        station.setMeasurements(25.5f, 65f, 1013f);
        station.setMeasurements(26.5f, 70f, 1012f);
    }
}
