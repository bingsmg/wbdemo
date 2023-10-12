package live.clover.phasethree.demo4;

/**
 * @author weibb
 * @date 2023-10-10
 */
public interface EventListener<E extends AbstractEvent> {

    void onEvent(E event);
}
