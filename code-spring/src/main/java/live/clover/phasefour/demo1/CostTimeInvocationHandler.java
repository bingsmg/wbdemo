package live.clover.phasefour.demo1;

import org.springframework.util.StopWatch;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author weibb
 * @date 2023-10-11
 */
public class CostTimeInvocationHandler implements InvocationHandler {

    private final Object target;

    public CostTimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        StopWatch watch = new StopWatch("Statistical execution time");
        watch.start();
        Object result = method.invoke(this.target, args);
        watch.stop();
        System.out.println(method + ", cost time:" + watch.getTotalTimeNanos());
        return result;
    }
}
