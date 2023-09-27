package live.clover.phaseone.demo7;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author weibb
 * @date 2023-09-26
 */
class MainTest {

    @Test
    void test1() {
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("我是 Invocation Handler 被调用的方法是： " + method.getName());
                return null;
            }
        };

        IService o = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(), new Class[]{IService.class}, invocationHandler);
        o.m1();
        o.m2();
        o.m3();
    }

    @Test
    void test2() {
        Enhancer enhancer = new Enhancer();
        MethodInterceptor methodInterceptor = (o, method, objects, methodProxy) -> null;
        enhancer.setSuperclass(IService.class);
        enhancer.setCallback(methodInterceptor);
        Object o1 = enhancer.create();
        System.out.println(o1);
    }
}