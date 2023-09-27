package live.clover.demo5;

/**
 * @author weibb
 * @date 2023-09-27
 */
public class ServiceC {
    private String name;
    private ServiceA serviceA;

    @Override
    public String toString() {
        return "ServiceC{" +
                "name='" + name + '\'' +
                ", serviceA=" + serviceA +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceA getServiceA() {
        return serviceA;
    }

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
