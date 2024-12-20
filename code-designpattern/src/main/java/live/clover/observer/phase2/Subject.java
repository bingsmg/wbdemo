package live.clover.observer.phase2;

/**
 * @author weibb
 */
public interface Subject {
    void registerObserver(Observer o);;
    void removeObserver(Observer o);;
    void notifyObservers();
}
