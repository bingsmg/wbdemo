package live.clover.observer.phase2;

/**
 * @author weibb
 */
public class CurrentConditionsDisplay implements Observer, DisplayElements {

    private float temperature;
    private float humidity;
    private final Subject weatherData; // keep reference

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + ", " + humidity);
    }
}
