package live.clover.phasethree.demo4;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author weibb
 * @date 2023-10-10
 */
public class SimpleEventMulticaster implements EventMulticaster {

    private Map<Class<?>, List<EventListener>> eventObjEventListenerMap = new ConcurrentHashMap<>();

    @Override
    public void multicastEvent(AbstractEvent event) {
        List<EventListener> eventListeners = this.eventObjEventListenerMap.get(event.getClass());
        if (Objects.nonNull(eventListeners)) {
            eventListeners.forEach(eventListener -> eventListener.onEvent(event));
        }
    }

    @Override
    public void addEventListener(EventListener<?> listener) {

    }

    @Override
    public void removeEventListener(EventListener<?> listener) {

    }
}
