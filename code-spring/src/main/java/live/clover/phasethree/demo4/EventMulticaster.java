package live.clover.phasethree.demo4;

/**
 * @author weibb
 * @date 2023-10-10
 */
public interface EventMulticaster {

    void multicastEvent(AbstractEvent event);

    void addEventListener(EventListener<?> listener);

    void removeEventListener(EventListener<?> listener);
}
