package live.clover.phasethree.demo4;

/**
 * @author weibb
 * @date 2023-10-10
 */
public class AbstractEvent {

    protected Object source;

    public AbstractEvent(Object source) {
        this.source = source;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }
}
