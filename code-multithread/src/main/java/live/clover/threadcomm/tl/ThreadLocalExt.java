package live.clover.threadcomm.tl;

/**
 * @author weibb
 */
public class ThreadLocalExt extends ThreadLocal<String> {

    @Override
    protected String initialValue() {
        return "I am default value, first get is not null.";
    }
}
