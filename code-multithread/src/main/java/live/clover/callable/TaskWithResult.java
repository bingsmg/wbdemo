package live.clover.callable;

import java.util.concurrent.Callable;

/**
 * @author weibb
 * @date 2023-09-19
 */
public class TaskWithResult implements Callable<String> {

    private final int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        return "result of TaskWithResult " + id;
    }
}
