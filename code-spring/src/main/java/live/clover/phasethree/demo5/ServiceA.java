package live.clover.phasethree.demo5;

import org.springframework.stereotype.Service;

/**
 * @author weibb
 * @date 2023-10-10
 */
@Service
public class ServiceA {

    private ServiceB serviceB;

    public ServiceB getServiceB() {
        return serviceB;
    }

    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }
}
