package live.clover.phaseone.demo7;

import org.springframework.util.StopWatch;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author weibb
 * @date 2023-09-27
 */
public class CostTimeInvocationHandler implements InvocationHandler {

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        StopWatch watch = new StopWatch();
        watch.start();
        Object invoke = method.invoke(this.target, args);
        watch.stop();
        System.out.println(this.target.getClass() + "方法耗时：" + watch.getTotalTimeSeconds());
        return invoke;
    }
}
