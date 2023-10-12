package live.clover.phasefour.demo1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * @author weibb
 * @date 2023-10-11
 */
public class ProxyTest {

    @Test
    public void test1() {
        Service service = new Service();
        CostTimeInvocationHandler costTimeInvocationHandler = new CostTimeInvocationHandler(service);

        Object proxyObject = Proxy.newProxyInstance(service.getClass().getClassLoader(),
                new Class[]{IService1.class, IService2.class},
                costTimeInvocationHandler);

        System.out.println(proxyObject instanceof Service);
        System.out.println(proxyObject instanceof IService1);
        System.out.println(proxyObject instanceof IService2);

        assert proxyObject instanceof IService1;
        IService1 service1 = (IService1) proxyObject;
        service1.m1();

        assert proxyObject instanceof IService2;
        IService2 service2 = (IService2) proxyObject;
        service2.m2();

        System.out.println(proxyObject.getClass());
    }
}
