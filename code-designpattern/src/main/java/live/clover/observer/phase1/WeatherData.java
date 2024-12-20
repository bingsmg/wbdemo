package live.clover.observer.phase1;

/**
 * @author weibb
 */
public class WeatherData {

    private float temperature;
    private float humidity;
    private float pressure;

    private CurrentConditionsDisplay currentConditionsDisplay; // 目前状况
    private StatisticsDisplay statisticsDisplay; // 气象统计
    private ForecastDisplay forecastDisplay; // 天气预报


    public void measurementsChanged(){
        //...
        float temperature = getTemperature();
        float humidity = getHumidity();
        float pressure = getPressure();

        currentConditionsDisplay.update(temperature, humidity, pressure); // 目前状况
        statisticsDisplay.update(temperature, humidity, pressure); // 气象统计
        forecastDisplay.update(temperature, humidity, pressure); // 天气预报
    }

    public float getHumidity() {
        return humidity;
    }
    public float getPressure() {
        return pressure;
    }
    public float getTemperature() {
        return temperature;
    }
}
