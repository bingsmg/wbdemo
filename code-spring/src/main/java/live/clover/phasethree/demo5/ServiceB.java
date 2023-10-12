package live.clover.phasethree.demo5;

import org.springframework.stereotype.Service;

/**
 * @author weibb
 * @date 2023-10-10
 */
@Service
public class ServiceB {

    private ServiceA serviceA;

    public ServiceA getServiceA() {
        return serviceA;
    }

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
