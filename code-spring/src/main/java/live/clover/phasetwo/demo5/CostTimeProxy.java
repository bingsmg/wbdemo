package live.clover.phasetwo.demo5;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

/**
 * @author weibb
 * @date 2023-09-28
 */
public class CostTimeProxy implements MethodInterceptor {

    private Object target;

    public CostTimeProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        StopWatch watch = new StopWatch();
        watch.start("统计方法调用执行时间");
        Object ans = method.invoke(target, objects);
        watch.stop();
        System.out.println(method + " 耗时：" + watch.getLastTaskTimeMillis());
        return ans;
    }

    public static <T> T createProxy(T target) {
        CostTimeProxy proxy = new CostTimeProxy(target);
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(proxy);
        enhancer.setSuperclass(target.getClass());
        return (T) enhancer.create();
    }


}
