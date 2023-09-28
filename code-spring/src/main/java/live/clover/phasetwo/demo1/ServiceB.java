package live.clover.phasetwo.demo1;

/**
 * @author weibb
 * @date 2023-09-28
 */
public class ServiceB {

    private ServiceA serviceA;

    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    @Override
    public String toString() {
        return "ServiceB{" +
                "serviceA=" + serviceA +
                '}';
    }
}
