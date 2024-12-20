package live.clover.observer.phase2;

/**
 * @author weibb
 */
public interface Observer {

    void update(float temperature, float humidity, float pressure);
}
