package live.clover.phasetwo.demo5;

import org.junit.jupiter.api.Test;

/**
 * @author weibb
 * @date 2023-09-28
 */
public class CostTimeProxyTest {
    @Test
    void test1() {
        Service1 service1 = new Service1();
        Service1 proxy = CostTimeProxy.createProxy(service1);
        proxy.m1();
    }
}
